package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class testDeck {

    @Test
    public void testBuildDeck(){
        Deck reg = new RegDeck();
        assertEquals(52,reg.d.size());

        Deck span = new SpanDeck();
        assertEquals(50,span.d.size());
    }

}
