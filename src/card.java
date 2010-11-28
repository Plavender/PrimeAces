/*
 * 
 */
public class card
{
	protected String name = new String();
	protected String suit = new String();
	protected int value;
	
	// Constructor for card takes 3 paramaters 
	// two strings and one int for the value of the card

	public card( String cSuit, String cName,int cValue)
	{
		suit = cSuit;
		name = cName;
		value = cValue;
	}
	// returns the suit of the card in a string
	public String getSuit()
	{
		return suit;
	}
	// returns the name of the card in a string example 1, 2, king
	public String getName()
	{
		return name;
	}
	// returns the value of the card 1 - 13
	public int getValue()
	{
		return value;
	}
	// toString method that gives the suit and name of the card
	public String toString()
	{
		String suitName = new String(suit + " " + name);
		return suitName;		
	}
		
}
