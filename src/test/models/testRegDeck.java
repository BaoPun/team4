package models;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class testRegDeck {

    @Test
    public void testMakeRegDeck() {
        Deck reg = new RegDeck();
        assertEquals(52, reg.d.size());    //Check deck size = 52


        int twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0, sevens = 0, eights = 0, nines = 0, tens = 0, elevens = 0, twelves = 0, thirteens = 0, fourteens = 0;
        int spades = 0, clubs = 0, diamonds = 0, hearts = 0;

        for(int i=0; i<reg.d.size(); i++){
            Card c = reg.d.get(i);

            if(c.value == 2){ twos += 1; }
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
            else if(c.value == 13){ thirteens += 1; }
            else if(c.value == 14){ fourteens += 1; }

            if(c.suit.toString().equals("Spades")){ spades += 1; }
            else if(c.suit.toString().equals("Clubs")){ clubs += 1; }
            else if(c.suit.toString().equals("Diamonds")){ diamonds += 1; }
            else if(c.suit.toString().equals("Hearts")){ hearts += 1; }
        }

        assertEquals(4, twos);      //Check that the deck has the right number of each type of card
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
        assertEquals(4, thirteens);
        assertEquals(4, fourteens);

        assertEquals(13, spades);
        assertEquals(13, clubs);
        assertEquals(13, diamonds);
        assertEquals(13, hearts);
    }


}
