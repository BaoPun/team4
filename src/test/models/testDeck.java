package models;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public Class testDeck{
        @Test
        public void testRegDeck)()
        {
            RegDeck deck = new RegDeck();
            assertEquals(52, deck.getSize());
            deck.shuffleDeck();
            assertEquals(52, deck.getSize()); //make sure there are STILL 52 cards in deck after shuffling
            RegDeck test = new RegDeck(); //to fully compare that shuffle is not working, make a test deck
            assertEquals(52, test.getSize());
            int val = 0;
            int deckSize = deck.getSize();
            for(int i = deck.getSize() - 1; i >= 0; i--) //compare each deck; if shuffle works, then val cannot be 52.
            {
                Card popDeck = deck.popCard(i);
                Card popTest = test.popCard(i);
                if(popDeck.getValue() == popTest.getValue())
                    val++;
            }
            assertThat(val, not(equalTo(deckSize)));
        }

        @Test
        public void testPopCard()
        {
            RegDeck deck = new RegDeck();
            Card get = deck.popCard(51);
            assertEquals(14, get.getValue());

            SpanDeck deck2 = new SpanDeck();
            Card get2 = deck2.popCard(49);
            assertEquals(0, get2.getValue());
        }

        @Test
        public void testSpanDeck()
        {
            SpanDeck deck = new SpanDeck();
            assertEquals(52, deck.getSize());
            deck.shuffleDeck();
            assertEquals(52, deck.getSize()); //make sure there are STILL 52 cards in deck after shuffling
            SpanDeck test = new SpanDeck(); //to fully compare that shuffle is not working, make a test deck
            assertEquals(52, test.getSize());
            int val = 0;
            int deckSize = deck.getSize();
            for(int i = deck.getSize() - 1; i >= 0; i--) //compare each deck; if shuffle works, then val cannot be 50.
            {
                Card popDeck = deck.popCard(i);
                Card popTest = test.popCard(i);
                if(popDeck.getValue() == popTest.getValue())
                    val++;
            }
            assertThat(val, not(equalTo(deckSize)));
        }


}