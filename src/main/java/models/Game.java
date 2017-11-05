package models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        // 2d array is initialized here, cannot do algorithms outside any method
        for(int i = 0; i < 4; i++)
        {
            cols.add(new ArrayList<Card>());
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
		Random randomGen = new Random();                        //Initialize random number generator object
		for(int i=0; i<200; i++){                               //Perform 200 times just to ensure the deck is shuffled
			int randomInt = randomGen.nextInt(52);      //Get the indexes of two random cards
			int randomInt2 = randomGen.nextInt(52);
			Card tempCard = deck.get(randomInt);                //Store the value of both cards
			Card tempCard2 = deck.get(randomInt2);
			deck.remove(randomInt);                             //Remove the card at the first index and copy the second card over
			deck.add(randomInt, tempCard2);
			deck.remove(randomInt2);                            //Remove the card at the second index and copy the first card over
			deck.add(randomInt2, tempCard);
		}

		/*for(int i=0; i<52; i++){              //Print the entire deck for testing purposes
			System.out.println(deck.get(i));
		}*/
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        if(deck.size() >= 0) {
            for (int i = 0; i < 4; i++) {
                Card top = deck.get(deck.size() - 1);        //retrieve top card of deck
                deck.remove(deck.size() - 1);                //remove it right after LuL
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
                if ((toRemove.getSuit() == temp.getSuit()) && (toRemove.getValue() < temp.getValue())) {
                    removeCardFromCol(columnNumber);
                    return;
                }
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        //System.out.println("Column " + (columnNumber + 1) + " has this many cards: " + cols.get(columnNumber).size());
        return (this.cols.get(columnNumber).size() != 0);
    }

    private Card getTopCard(int columnNumber) {
        //System.out.println("Top card in col " + (columnNumber + 1) + ": " + this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1));
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        
       if(columnHasCards(columnFrom)) {
           Card temp = getTopCard(columnFrom);
           if (!columnHasCards(columnTo) && temp.getValue() == 14) {
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
