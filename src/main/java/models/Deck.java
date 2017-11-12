package models;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public java.util.List<Card> d;

    public int size;

    public Deck(){
        d = new ArrayList<>();
        size = 0;
        makeDeck();
        shuffleDeck();
    }

    public void makeDeck(){
        for(int i = 2; i < 15; i++){
            this.d.add(new Card(i,Suit.Clubs));
            this.d.add(new Card(i,Suit.Hearts));
            this.d.add(new Card(i,Suit.Diamonds));
            this.d.add(new Card(i,Suit.Spades));
        }
        this.size = d.size();
    }

    public void shuffleDeck(){
        Random randomGen = new Random();                        //Initialize random number generator object
        for(int i=0; i<200; i++){                               //Perform 200 times just to ensure the deck is shuffled
            int randomInt = randomGen.nextInt(52);      //Get the indexes of two random cards
            int randomInt2 = randomGen.nextInt(52);
            Card tempCard = this.d.get(randomInt);                //Store the value of both cards
            Card tempCard2 = this.d.get(randomInt2);
            this.d.remove(randomInt);                             //Remove the card at the first index and copy the second card over
            this.d.add(randomInt, tempCard2);
            this.d.remove(randomInt2);                            //Remove the card at the second index and copy the first card over
            this.d.add(randomInt2, tempCard);
        }
    }

    public int getSize() {
        return this.size;
    }

    public Card popCard(int i){
        return this.d.get(i);
    }

    public void removeCard(int i){
        this.d.remove(i);
        this.size = d.size();
    }
}
