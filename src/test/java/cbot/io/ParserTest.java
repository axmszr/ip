package cbot.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ParserTest {
    @Test
    public void testIsByeTrue() throws PoorInputException {
        Parser p = new Parser("bye");
        assertTrue(p.isBye());
    }
    
    @Test
    public void testIsByeFalse() throws PoorInputException {
        Parser p = new Parser("list");
        assertFalse(p.isBye());
    }
    
    @Test
    public void testNeedSaveTrue() throws PoorInputException {
        Parser p = new Parser("sort");
        assertTrue(p.needSave());
    }
    
    @Test
    public void testNeedSaveFalse() throws PoorInputException {
        Parser p = new Parser("list");
        assertFalse(p.needSave());
    }
}