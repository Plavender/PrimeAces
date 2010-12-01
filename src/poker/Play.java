package poker;

public class Play 
{
	// array of cards for play area maximum of 5 
	public static Card[] playArea = new Card[5];
	int inPlay = 0;
	
	// adds a card object to the playArea array
	public void addToPlay(Card f)
	{
		if (inPlay < 5)
		{
			playArea[inPlay] = f;
			inPlay++;
		}	
	}
	
	// returns the card objects stored in the cardHeld array/ the players hand 
	public Card[] getInPlay()
	{
		return playArea;
	}
	public void wipe()
	{
		for (int x = 0; x < 5; x++)
		{
			playArea[x] = null;
		}
		inPlay = 0;
	}
}