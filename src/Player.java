import java.util.ArrayList;
//whoever wrote the other portions of this needs to add their comments and an author here.
/**
 * The constructor adds to an array of players for determining the winner of a game.  There are 
 * also functions that are used to call for functions in the hand class from classes that cannot 
 * call hands directly.  The static array of players is callable by anywhere. 
 * @author Steven Honda
 *
 */
public abstract class Player {
	
	protected int chips; 
	protected Hand hand;
	static int numPlayers = 0;
	static public Player[] players = new Player[6];
	int hNum;
	
	public Player(int m)
	{
		players[numPlayers++] = this;
		hand = new Hand();
//		m = chips;
		chips = m;  // I am assuming this is what you mean 
	}
	public int getChips()
	{
		return chips;
	}
	
	public void addChips(int x)	
	{
		chips += x;
	}
	
	public void takeChips(int y)
	{
		chips -= y;
	}
	/**
	 * this method is for getting the score of the current poker hands for a player from somewhere 
	 * else in the program.
	 * @return int
	 * @author Steven Honda
	 */
	public int getScore(){
		return hand.getScore();
	}
	/**
	 * this method is for determining who has won a game when a tie has occurred and 
	 * @return double
	 * @author Steven Honda
	 */
	public double tiebreaker(){
		return hand.tiebreaker();
	}
}



