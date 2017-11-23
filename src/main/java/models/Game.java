package models;

import java.util.ArrayList;


public class Game {

    public SpanDeck deck = new SpanDeck();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){

        for(int i = 0; i < 4; i++)
        {
            cols.add(new ArrayList<Card>());
        }
    }


    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        if(deck.getSize() > 0) {
            for (int i = 0; i < 4 && deck.getSize() > 0; i++) {
                Card top = deck.popCard(deck.getSize() - 1);        //retrieve top card of deck
                deck.removeCard(deck.getSize() - 1);                //remove it right after LuL
                addCardToCol(i, top);
            }
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if (columnHasCards(columnNumber) == false)
            return;
        Card toRemove = getTopCard(columnNumber);
        //System.out.println("toRemove is a " + toRemove.getValue() + " of " + toRemove.getSuit());
        for (int i = 0; i < 4; i++) {
            if (i != columnNumber && columnHasCards(i)) {
                Card temp = getTopCard(i);
                if ((toRemove.getSuit() == temp.getSuit()) && (toRemove.getValue() < temp.getValue() || temp.getValue() == 1)) {
                    removeCardFromCol(columnNumber);
                    return;
                }
            }
        }for(int i = 0; i < 4; i++) {
            if(i != columnNumber && columnHasCards(i)){
                Card temp = getTopCard(i);
                if(temp.getValue() == 0){
                    removeCardFromCol(columnNumber);
                    removeCardFromCol(i);
                }
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return (this.cols.get(columnNumber).size() != 0);
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        
       if(columnHasCards(columnFrom)) {
           Card temp = getTopCard(columnFrom);
           if (!columnHasCards(columnTo) && ((temp.getValue() == 14) || (temp.getValue() == 0) || (temp.getValue() == 1))) {
               removeCardFromCol(columnFrom);
               addCardToCol(columnTo, temp);
           }
       }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size() - 1);
    }
}
