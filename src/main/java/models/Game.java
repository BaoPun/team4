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
	for(int i = 0; i < 4; i++){
	        //because addCardToCol is private, have to declare and invoke addCardToCol method to access the function
            //try and catch is required for Java to not have a compiling error...
            //terminal output will have comments, omit if you wish
            Method gAddCol, gTopCol, gEmptyCol;
            Game game = new Game();
            try{
		//first 6 lines are essentially just allowing us to access private methods
                gAddCol = Game.class.getDeclaredMethod("addCardToCol", int.class, Card.class);
                gTopCol = Game.class.getDeclaredMethod("getTopCard", int.class);
                gEmptyCol = Game.class.getDeclaredMethod("columnHasCards", int.class);
                gAddCol.setAccessible(true);
                gTopCol.setAccessible(true);
                gEmptyCol.setAccessible(true);
                Card top = deck.get(deck.size() - 1 - i);   		//retrieve top card of deck
                deck.remove(deck.size() - 1 - i);           		//remove it right after LuL
                gAddCol.invoke(game, i, top);               		//call addCardToCol method
                Card t = (Card) gTopCol.invoke(game, i); 		//terminal, call getTopCard method
                boolean empty = (boolean) gEmptyCol.invoke(game, i); 	//terminal, call columnHasCards method
                System.out.println("\n");
            }
            catch (NoSuchMethodException e) {
                //e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                //e.printStackTrace();
            }
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        System.out.println("Column " + (columnNumber + 1) + " has this many cards: " + this.cols.get(columnNumber).size());
        return (this.cols.get(columnNumber).size() != 0);
    }

    private Card getTopCard(int columnNumber) {
        System.out.println("Top card in col " + (columnNumber + 1) + ": " + this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1));
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
