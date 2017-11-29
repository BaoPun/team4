package models;

import java.util.ArrayList;

public class RegDeck extends Deck {

    public RegDeck() {
        d = new ArrayList<>();
        size = 0;
        makeRegDeck();
        shuffleDeck();
    }

    public void makeRegDeck(){
        for(int i = 2; i < 15; i++){
            this.d.add(new Card(i,Suit.Clubs));
            this.d.add(new Card(i,Suit.Hearts));
            this.d.add(new Card(i,Suit.Diamonds));
            this.d.add(new Card(i,Suit.Spades));
        }
        this.size = d.size();
    }


}
