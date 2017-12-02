package models;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class testSpanDeck {

    @Test
    public void testMakeSpanDeck() {
        Deck span = new SpanDeck();
        assertEquals(50, span.d.size());    //Check deck size = 50


        int zeros = 0, ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0, sevens = 0, eights = 0, nines = 0, tens = 0, elevens = 0, twelves = 0;
        int oros = 0, espadas = 0, copas = 0, bastos = 0, comodines = 0;

        for(int i=0; i<span.d.size(); i++){
            Card c = span.d.get(i);

            if(c.value == 0){ zeros += 1; }
            else if(c.value == 1){ ones += 1; }
            else if(c.value == 2){ twos += 1; }
            else if(c.value == 3){ threes += 1; }
            else if(c.value == 4){ fours += 1; }
            else if(c.value == 5){ fives += 1; }
            else if(c.value == 6){ sixes += 1; }
            else if(c.value == 7){ sevens += 1; }
            else if(c.value == 8){ eights += 1; }
            else if(c.value == 9){ nines += 1; }
            else if(c.value == 10){ tens += 1; }
            else if(c.value == 11){ elevens += 1; }
            else if(c.value == 12){ twelves += 1; }

            if(c.suit.toString().equals("Oros")){ oros += 1; }
            else if(c.suit.toString().equals("Espadas")){ espadas += 1; }
            else if(c.suit.toString().equals("Bastos")){ bastos += 1; }
            else if(c.suit.toString().equals("Copas")){ copas += 1; }
            else if(c.suit.toString().equals("Comodine")){ comodines += 1; }
        }
        assertEquals(2, zeros);     //Check that the deck has the right number of each type of card
        assertEquals(4, ones);
        assertEquals(4, twos);
        assertEquals(4, threes);
        assertEquals(4, fours);
        assertEquals(4, fives);
        assertEquals(4, sixes);
        assertEquals(4, sevens);
        assertEquals(4, eights);
        assertEquals(4, nines);
        assertEquals(4, tens);
        assertEquals(4, elevens);
        assertEquals(4, twelves);

        assertEquals(2, comodines);
        assertEquals(12, bastos);
        assertEquals(12, espadas);
        assertEquals(12, copas);
        assertEquals(12, oros);
    }


}
