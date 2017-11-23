package models;

import java.util.ArrayList;

public class SpanDeck extends Deck {

    public SpanDeck(){
        d = new ArrayList<>();
        size = 0;
        makeSpanDeck();
        shuffleDeck();
    }

    public void makeSpanDeck(){
        for(int i = 1; i < 13; i++){
            this.d.add(new Card(i,Suit.Bastos));
            this.d.add(new Card(i,Suit.Espadas));
            this.d.add(new Card(i,Suit.Oros));
            this.d.add(new Card(i,Suit.Copas));
        }
        this.d.add(new Card(0, Suit.Comodine));
        this.d.add(new Card(0, Suit.Comodine));
        this.size = d.size();
    }
}
