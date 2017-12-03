package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class testGameSpan {

    private GameSpan g;

    @Before
    public void before(){
        g = new GameSpan();
    }

    @Test
    public void testMakeGame() {
        assertNotNull(g);
    }

    @Test
    public void testDeal() {
        int deckSize = g.deck.getSize();
        g.dealFour();
        String size = Integer.toString(deckSize-4);
        assertEquals(size, Integer.toString(g.deck.getSize()));
    }

    @Test
    public void testMove(){
        g.customDeal();
        //Card c = new Card(11, Suit.Clubs);
        g.move(0, 1);
        assertEquals("1Copas", g.cols.get(0).cards.get(0).toString());
        g.remove(1);
        g.move(0, 1);
        assertEquals("1Copas", g.cols.get(1).cards.get(0).toString());
    }

    @Test
    public void testRemove(){
        g.remove(0);
        assertEquals(0, g.cols.get(0).cards.size());
        g.customDeal();
        g.remove(0);
        assertEquals(0, g.cols.get(0).cards.size());
        assertEquals(0, g.cols.get(3).cards.size());
        g.remove(1);
        assertEquals(0, g.cols.get(1).cards.size());
        g.remove(2);
        assertEquals(1, g.cols.get(2).cards.size());
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
