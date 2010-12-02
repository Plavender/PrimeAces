package poker;

import javax.swing.JOptionPane;
/**
 * This is the main method.
 * @author Davis
 */


/**
	 * Removed main from the HoldEm class and placed it within its own
	 */
public class Dealer {

	/**
	 * Method that resets tables, takes ten chips from every player
	 * and assigns two cards two each player.
	 */
	
	public static int Ante() {
		
		int ante = 0;
	
		table.clear();
	
		for(int i = 0; i < numPlayers; i++){
			ante += player[i].dealIn(10, playDeck.draw(), playDeck.draw());
		}
		return ante;
	}
	
	/**
	 * Sets up the player Array for a total possible of 4.
	 * declares the constructors it will use
	 */
	protected static int numPlayers = 4;
	protected static Player[] player = new Player[4];
	protected static Deck playDeck;
	protected static Table table;
	
	
	
	public static void main(String[] args) {
		// Initiate new game
		//Initiate new table
		table = new Table();
		int pot = 0;
		//Initialize User
		player[0] = new User(250, JOptionPane.showInputDialog(null, "Enter your player name"), 4, 8);
		//Initialize computer players
		player[1] = new Computer(250, "Billy the Kid", 0, 0);
		player[2] = new Computer(250, "Doc Holliday", 4, 0);
		player[3] = new Computer(250, "Maverick", 0, 8);
		//While loop of main method.  Game ceased if player chips are less than 0
		while(numPlayers > 1 && player[0].getChips() > 0){
			//creates new deck object and shuffles it.
			playDeck = new Deck();
			playDeck.shuffle();
			//calls ante method.
			pot = Ante();
			// renders the GUI to show increase in pot (also updates cards).
			render(pot);
			//  Place bets method is called returns with wagers.
			pot += placeBets();
			// Places three cards on the table automatically set to visible 
			revealCards(3);
			// Updates the pot for the GUI
			render(pot);
			// Another round of betting
			pot += placeBets();
			//  Loop for last two rounds of betting and placing cards
			for(int i = 0; i < 2; i++){
				revealCards(1);
				render(pot);
				pot += placeBets();
			}
			// Calls pick winner method, adds chips then updates for GUI
			Player winner = pickWinner();
			winner.addChips(pot);
			render(0, true);
			//  dialogue box opens to display winner
			if(winner.equals(player[0])) {
				JOptionPane.showMessageDialog(null, "You won $" + pot + "!");
			} else {
				JOptionPane.showMessageDialog(null, winner.toString() + " won $" + pot + ".");
			}
			//  Remove dead players method is called,  anyone who is less then 0
			//   or equal to 0 is cut out of the array.  Player 0 or User will simple lose at while loop opening 
			removeDeadPlayers();
		}
		//  Final declaration of winning or losing
		if(player[0].getChips() > 0) {
			JOptionPane.showMessageDialog(null, "You walked away with $" + player[0].getChips() + "!");
		} else {
			JOptionPane.showMessageDialog(null, "You walked away with... well, the clothes on your back.");
		}
		table.frame.dispose();
	}
	/**
	 * Remove dead players method
	 */
	private static void removeDeadPlayers() {
		int i = 1;
		while(i < numPlayers) {
			if(player[i].getChips() <= 0){
				player[i] = player[numPlayers - 1];
				numPlayers--;
			} else {
				i++;
			}
		}
	}

	/**
	 * Place bets method sorts fines the highest bet among players, computers will
	 always match the highest unless their bet is 0.  Then asks the user
 if they would like to match the bet.  Then takes the highest bet 
 from those who did not fold.
    @return int wagers
	 
	 */
	private static int placeBets() {
		int wagers = 0;
		int theBet = 0;
		int betsa;
		int userBet = 0;
		for(int i = 0; i < numPlayers; i++)
		{	
			betsa = player[i].placeBet();
			if(betsa >= theBet )
			{
				theBet = betsa;
				if(i == 0)
				userBet = betsa;
				
			}
			
			if(betsa == 0 && player[i].getChips() != 0) 
			{
				player[i].folded = true;
			}
		}
		if(userBet < theBet && player[0].folded != true){
			int temp = 0;
			int needBet= 0;
			String bet;
			if(player[0].getChips() < theBet)
			{
			needBet = player[0].getChips();
			}
			else
			{
			needBet = theBet;
			}
			bet = JOptionPane.showInputDialog(null, "Enter the amount of " + needBet + " if you wish to call");
			
			try
			{
			temp = Integer.parseInt(bet);
			}
			catch(NumberFormatException e)
			{
				bet = JOptionPane.showInputDialog(null, "Place your bet must be an integer; no decimals or letters");
				temp = Integer.parseInt(bet);
			}
			
			if(temp != theBet && player[0].getChips() != 0){
				player[0].folded = true;
			}
			
		}
		for(int i = 0; i < numPlayers; i++){
			if(player[i].folded != true)
			wagers += player[i].takeChips(theBet);
		}
		return wagers;
			
	}
			
		
	/**
	 * 
	 */
	public static void render(int pool){
		table.cleanupGUI();
		for(int i = 0; i < numPlayers; i++){
			player[i].render(table);
		}
		table.render(pool);
	}
	/**
	 * Method updates GUI to show loss of players and change in chips.
	 */ 
	public static void render(int pool, boolean show){
		table.cleanupGUI();
		for(int i = 0; i < numPlayers; i++){
			player[i].render(table, show);
		}
		table.render(pool);
	}
	/**
	 *Calls method in hand to decide who has highest hand value 
	 *@return int tempHigh
	 */
	public static Player pickWinner(){ 
		int tempHigh = 0;
		for (int i = 1; i < numPlayers; i++) {
				if (player[i].tieBreaker() > player[tempHigh].tieBreaker())
					tempHigh = i;
		}
		return player[tempHigh];
	}
	/**
	 * Method when card is placed on table instantly updates it for the gui.
	 */
	public static void revealCards(int n){
		for(int i = 0; i < n; i++){
			Card tCard = playDeck.draw();
			table.addCard(tCard);
			for(int j = 0; j < numPlayers; j++){
				player[j].hand.addCard(tCard);
			}
		}
	}
}
