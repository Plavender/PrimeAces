import java.util.ArrayList;
import java.util.List;

/* 
 * Made by Davis
 *  array of cards used for poker deck
 */
public class Deck 
{

	protected ArrayList<card> cardDeck = new ArrayList<card>();
	
	// creates an array of 52 card objects - standard poker cards 3 parameters 1st string denotes suit
	// second string tells card number, 3rd perameter is an int for comparing the value of the cards
	public void makeDeck()
	{
		
		
		String[] numbers = new String[13];  
	    numbers[0] = "2";                          
	    numbers[1] = "3";
		numbers[2] = "4";
		numbers[3] = "5";
		numbers[4] = "6";
		numbers[5] = "7";
		numbers[6] = "8";
		numbers[7] = "9";
		numbers[8] = "10";
		numbers[9] = "j";
		numbers[10] = "q";
		numbers[11] = "k";
		numbers[12] = "a";
	
	int val =1;	
	int x = 0;
	card c;
	
		for(int y = 0; y < 13; y++)
		{
			c = new card("clubs", numbers[y], val);
			cardDeck.add(c);
			x++;
			val++;
		}
	val = 1;
		for(int z = 0; z < 13; z++)
		{
			c = new card("diamonds", numbers[z], val);
			cardDeck.add(c);
			x++;
			val++;
		}
	val = 1;
		for(int f = 0; f < 13; f++)
		{
			c = new card("clubs", numbers[f], val);
			cardDeck.add(c);
			x++;
			val++;

		}
	val = 1; 
		for(int d = 0; d < 13; d++)
		{
			c = new card("clubs", numbers[d], val);
			cardDeck.add(c);
			x++;
			val++;

		}
	
	}
		// sorts the array into a random order
		public void shuffle()
	{
		// will do this
	}
		// returns the card on top of the deck (card at 0 in the array) 
		// and puts it at the bottom of the deck
	
		public card getCard()
	{
		card retCard = cardDeck.get(0);;
		cardDeck.remove(0);
		return retCard;
	}
		public String toString()
		{
		String s = new String();
			for(int v = 0; v < 51; v++)
			{	
				s += cardDeck.get(v).toString() + "\n"; 
			}
		return s;
		}
}
