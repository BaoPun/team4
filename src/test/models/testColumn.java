package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testColumn {

    @Test
    public void testColumn(){
        Column col = new Column(8);
        assertEquals(8,col.id);
    }

    @Test
    public void testDefaultColumnContructor(){
        Column c = new Column();
        assertNotNull(c);
    }
}
