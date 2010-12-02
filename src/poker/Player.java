package poker;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;

//whoever wrote the other portions of this needs to add their comments and an author here.
/**
 * The constructor adds to an array of players for determining the winner of a game.  There are 
 * also functions that are used to call for functions in the hand class from classes that cannot 
 * call hands directly.  The static array of players is call-able by anywhere. 
 * @author Steven Honda
 *
 */
public class Player {
	private int gridx, gridy;
	protected boolean isUser = false;
	protected String name;
	protected int chips;
	protected boolean folded;
	public Hand hand;
	public Card[] playerHand = new Card[2];
	
	public Player(int money, String myName, int x, int y)
	{
		gridx = x;
		gridy = y;
		hand = new Hand(7);
		if(hand.handSize > 0 || hand.getScore() > 0)
			name = "Mud";
		else
			name = myName;
//		m = chips;
		folded = false;
		chips = money;  // I am assuming this is what you mean 
	}
	public int getChips()
	{
		return chips;
	}
	
	public void addChips(int x)	
	{
		chips += x;
	}
	
	public int takeChips(int y)
	{
		chips -= y;
		return y;
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
	public double tieBreaker(){
		return hand.tieBreaker();
	}
	/**
	 * this method allows a player to add a card to their hand.
	 * @param newCard
	 * @return int handSize
	 */
	public int addCard(Card newCard){
		return hand.addCard(newCard);
	}
	
	public int dealIn(int cost, Card card1, Card card2){
		folded = false;
		hand.wipe();
		for (int i = 0; i < 2; i++)
		{
			playerHand[i] = null;
		}
		addPlayerHand(card1, 1);
		addPlayerHand(card2, 2);

		return takeChips(cost);

}
	
	public void addPlayerHand(Card newCard, int i){
		playerHand[i - 1] = newCard;
		System.out.println("Added:" + playerHand[i - 1].toString()+ "to playerHand at position " + i);
		hand.addCard(newCard);
	}
	
	public String ToString()
	{
		return name;
	}

	
	public void render(Table table) {
		render(table, isUser);
	}
	
	public void render(Table table, boolean show) {
		Container GUI = table.GUI;
		GridBagConstraints coord = table.coord;
		
		// TODO Auto-generated method stub
		//First computer player name label and placement on the board
		JLabel Comp = new JLabel(this.toString());
		coord.gridx = gridx;
		coord.gridy = gridy;
		Comp.setFont(new Font("sansserif", Font.BOLD, 16));
		Comp.setForeground(Color.white);
		GUI.add(Comp, coord);
		
		//player's first card; bg shown, actual values with suit hidden
		coord.gridx = gridx + 1;
		coord.gridy = gridy;
		playerHand[0].render(GUI, coord, show);

		//player's second card; bg shown, actual values with suit hidden
		coord.gridx = gridx + 2;
		coord.gridy = gridy;
		playerHand[1].render(GUI, coord, show);

		//player's chips with value; new chip image and fonts
		JLabel ChipNum = new JLabel("$" + getChips());
		coord.gridx = gridx + 3;
		coord.gridy = gridy;
		ChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
		ChipNum.setForeground(Color.black);
		GUI.add(ChipNum, coord);
		JLabel Chips = new JLabel(Table.chipImg);
		GUI.add(Chips, coord);
	}
	
	public int placeBet() {
		return 0;
	}
	
	public void fold() {
		folded = true;
	}
	
	public boolean hasFolded() {
		return folded;
	}

}



