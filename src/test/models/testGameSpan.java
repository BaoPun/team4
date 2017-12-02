package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testGameSpan {

    private GameSpan g;

    @Before
    public void before(){
        g = new GameSpan();
    }

    @Test
    public void testMakeGame() {
        assertEquals(50, g.deck.getSize());
        assertEquals(4, g.cols.size());
    }

    @Test
    public void testDeal() {
        int decksize = g.deck.getSize();
        g.dealFour();
        String size = Integer.toString(decksize-4);
        assertEquals(size, Integer.toString(g.deck.getSize()));
    }

}
