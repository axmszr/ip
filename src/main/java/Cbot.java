import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

public class Cbot {
    private TaskList tl;
    private final FileStuff fs;
    private final UI ui;
    
    private static final String PATH = "../data/cbot_save.txt";

    public Cbot(String filePath) throws IOException {
        this.fs = new FileStuff(filePath);
        this.ui = new UI();

        try {
            // i prefer an if-else :(
            this.tl = fs.loadFile();
        } catch (FileNotFoundException e) {
            fs.makeFile();
            UI.sayNewFile(fs);
            this.tl = new TaskList();
        }
    }

    public void run() throws IOException {
        UI.sayHi();
        
        boolean doLoop = true;
        boolean doSave = false;
        
        while (doLoop) {
            String userInput = "";
            Parser p = null;
            
            try {
                userInput = this.ui.askUser();
                p = new Parser(userInput);
                
                if (p.isBye()) {
                    doLoop = false;
                } else {
                    if (p.needSave()) {
                        doSave = true;
                    }
                    p.respond(tl);
                }
            } catch (BadInputException e) {
                UI.warnBad(e);
            } catch (PoorInputException e) {
                UI.warn(e);
            } catch (DateTimeParseException e) {
                UI.warnTime();
            }
            
            if (doSave) {
                this.fs.saveFile(tl);
                doSave = false;
            }
        }
        
        UI.sayBye();
    }

    public static void main(String[] args) throws IOException {
        new Cbot(PATH).run();
    }
}