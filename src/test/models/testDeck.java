package models;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;


public class testDeck{

        @Test
        public void testRegDeck()
        {
                GameReg g1 = new GameReg();
                g1.deck.shuffleDeck();
                GameReg g2 = new GameReg();
                g2.deck.shuffleDeck();
                // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
                assertFalse(Arrays.equals(g1.deck.d.toArray(), g2.deck.d.toArray()));
        }

        @Test
        public void testPopCard()
        {
            RegDeck deck = new RegDeck();
            Card c = deck.d.get(51);
            Card get = deck.popCard(51);
            assertEquals(c, get);

            SpanDeck deck2 = new SpanDeck();
            c = deck2.d.get(49);
            get = deck2.popCard(49);
            assertEquals(c, get);
        }

        @Test
        public void testSpanDeck()
        {
                GameSpan g1 = new GameSpan();
                g1.deck.shuffleDeck();
                GameSpan g2 = new GameSpan();
                g2.deck.shuffleDeck();
                // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
                assertFalse(Arrays.equals(g1.deck.d.toArray(), g2.deck.d.toArray()));
        }


}