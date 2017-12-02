package models;

import models.GameReg;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testGameReg {

    private GameReg g;

    @Before
    public void before(){
        g = new GameReg();
    }

    @Test
    public void testMakeGame() {
        assertEquals(52, g.deck.getSize());
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
