package poker;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

/* 
 * Made by Davis
 *  array of cards used for poker deck
 */
public class Deck 
{

	public static ImageIcon[] cardImg = new ImageIcon[5];
	protected ArrayList<Card> cardDeck = new ArrayList<Card>();
	
	public Deck(){
		makeDeck();
	}
	// creates an array of 52 card objects - standard poker cards 3 parameters 1st string denotes suit
	// second string tells card number, 3rd perameter is an int for comparing the value of the cards
	public static ImageIcon getImage(String suit) {
		ImageIcon bkg = cardImg[0];
		if(suit.equalsIgnoreCase("Spades"))
			bkg = cardImg[1];
		else if(suit.equalsIgnoreCase("Hearts"))
			bkg = cardImg[2];
		else if(suit.equalsIgnoreCase("Clubs"))
			bkg = cardImg[3];
		else if(suit.equalsIgnoreCase("Diamonds"))
			bkg = cardImg[4];
		return bkg;
	}
	
	public void makeDeck()
	{
		String[] suitName = new String[5];
		suitName[0] = "";
		suitName[1] = "Spades";
		suitName[2] = "Hearts";
		suitName[3] = "Clubs";
		suitName[4] = "Diamonds";

		cardImg[0] = new ImageIcon("cardback.jpg");
		cardImg[1] = new ImageIcon("spades.jpg");
		cardImg[2] = new ImageIcon("hearts.jpg");
		cardImg[3] = new ImageIcon("clubs.jpg");
		cardImg[4] = new ImageIcon("diamonds.jpg");
		
		String[] numbers = new String[14];  
		numbers[0] = "";
		numbers[1] = "2";                          
	    numbers[2] = "3";
		numbers[3] = "4";
		numbers[4] = "5";
		numbers[5] = "6";
		numbers[6] = "7";
		numbers[7] = "8";
		numbers[8] = "9";
		numbers[9] = "10";
		numbers[10] = "J";
		numbers[11] = "Q";
		numbers[12] = "K";
		numbers[13] = "A";
	
	for(int suit = 1; suit <= 4; suit++) {
		for(int val = 1; val <= 13; val++) {
			cardDeck.add(new Card(suitName[suit], numbers[val], val));
		}
	}
}
		// sorts the array into a random order
public void shuffle() {
		Collections.shuffle(cardDeck);
}
		// returns the card on top of the deck (card at 0 in the array) 
		// and puts it at the bottom of the deck
	
public Card draw() {
		Card retCard = cardDeck.get(0);
		cardDeck.remove(0);
//		cardDeck.add(51, retCard);
		return retCard;
}

@Override
public String toString() {
	String s = new String();
		for(int v = 0; v < 51; v++)
		{	
			s += cardDeck.get(v).toString() + "\n"; 
		}
	return s;
	}
}


