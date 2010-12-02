package poker;
/*
 * 
 */

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

public class Card
{
	protected String name = new String();
	protected String suit = new String();
	protected int value;
	
	// Constructor for card takes 3 paramaters 
	// two strings and one int for the value of the card

	public Card( String cSuit, String cName,int cValue)
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
	@Override
	public String toString()
	{
		String suitName = new String(suit + " " + name + "[" + value + "]");
		return suitName;		
	}
	
	public void render(Container GUI, GridBagConstraints coord, boolean showFace)
	{
		if(showFace) {
			JLabel CardText = new JLabel(this.name);
			CardText.setFont(new Font("sansserif", Font.BOLD, 84));
			GUI.add(CardText, coord);
			JLabel CardFace = new JLabel(Deck.getImage(this.suit));
			GUI.add(CardFace, coord);
		} else {
			JLabel CardBack = new JLabel(Deck.cardImg[0]);
			GUI.add(CardBack, coord);
			CardBack.setVisible(true);
		}
		
	
	}
		
}
