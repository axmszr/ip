public enum Command {
    //NAME      (str,           hasText,    save,   hasArr),
    BYE         ("bye",         false),
    LIST        ("list",        false,      false,      true),
    MARK        ("mark ",       true,       true),
    MARK_BAD    ("mark",        false),
    UNMARK      ("unmark ",     true,       true),
    UNMARK_BAD  ("unmark",      false),
    DELETE      ("delete ",     true,       true),
    DELETE_BAD  ("delete",      false),
    TODO        ("todo ",       true,       true),
    TODO_BAD    ("todo",        false),
    DEADLINE    ("deadline ",   true,       true),
    DEADLINE_BAD("deadline",    false),
    EVENT       ("event ",      true,       true),
    EVENT_BAD   ("event",       false),
    SORT        ("sort",        false,      true,       true),
    BEFORE      ("before ",     true,       false,      true),
    BEFORE_BAD  ("before",      false),
    AFTER       ("after ",      true,       false,      true),
    AFTER_BAD   ("after",       false),
    FILTER      ("filter ",     true,       false,      true),
    FILTER_BAD  ("filter",      false),
    NONE        ("",            false);
    
    private final String str;
    private final boolean hasText;
    private final boolean save;
    private final boolean hasArr;
    
    Command(String str, boolean hasText, boolean save, boolean hasArr) {
        this.str = str;
        this.hasText = hasText;
        this.save = save;
        this.hasArr = hasArr;
    }
    
    Command(String str, boolean hasText, boolean save) {
        this(str, hasText, save, false);
    }
    
    Command(String str, boolean hasText) {
        this(str, hasText, false, false);
    }
    
    boolean needSave() {
        return this.save;
    }
    
    boolean hasArray() {
        return this.hasArr;
    }
    
    int getLen() {
        return this.str.length();
    }
    
    boolean match(String input) {
        if (this.hasText && input.length() > getLen()) {
            return input.substring(0, getLen()).equals(this.str);
        } else {
            return input.equals(this.str);
        }
    }
    
    String getText(String input) {
        if (this.hasText) {
            return input.substring(getLen()).trim();
        }
        
        return "";
    }
    
    boolean missingText(String text) {
        return (this.hasText && text.length() == 0);
    }
}