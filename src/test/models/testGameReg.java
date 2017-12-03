package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class testGameReg {

    private GameReg g;

    @Before
    public void before(){
        g = new GameReg();
    }

    @Test
    public void testMakeGame() {
        assertNotNull(g);
    }

    @Test
    public void testDeal() {
        int decksize = g.deck.getSize();
        g.dealFour();
        String size = Integer.toString(decksize-4);
        assertEquals(size, Integer.toString(g.deck.getSize()));
    }

    @Test
    public void testMove(){
        g.customDeal(0);
        //Card c = new Card(11, Suit.Clubs);
        g.move(0, 1);
        assertEquals("11Clubs", g.cols.get(0).cards.get(0).toString());
        g.remove(1);
        g.move(3, 1);
        assertEquals("14Clubs", g.cols.get(1).cards.get(0).toString());
    }

    @Test
    public void testRemove(){
        g.remove(0);
        assertEquals(0, g.cols.get(0).cards.size());
        g.customDeal(0);
        g.remove(3);
        assertEquals("14Clubs", g.cols.get(3).cards.get(0).toString());
        g.remove(2);
        assertEquals(0, g.cols.get(2).cards.size());
        g.remove(2);
        assertEquals(0, g.cols.get(2).cards.size());
    }

    @Test
    public void testClear(){
        g.clearColumns();
        for(int i = 0; i < 4; i++){
            assertEquals(0, g.cols.get(i).cards.size());
        }
        g.dealFour();
        g.clearColumns();
        for(int i = 0; i < 4; i++){
            assertEquals(0, g.cols.get(i).cards.size());
        }
    }
}
