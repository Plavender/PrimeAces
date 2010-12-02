package poker;

import javax.swing.JOptionPane;



public class Dealer {

	/**
	 * Removed main from the HoldEm class and placed it within its own
	 */
	public static int Ante() {
		int ante = 0;
		table.clear();
		for(int i = 0; i < numPlayers; i++){
			ante += player[i].dealIn(10, playDeck.draw(), playDeck.draw());
		}
		return ante;
	}
	
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
		while(numPlayers > 1 && player[0].getChips() > 0){
			playDeck = new Deck();
			playDeck.shuffle();
			pot = Ante();
			render(pot);
			pot += placeBets();
			revealCards(3);
			render(pot);
			pot += placeBets();
			for(int i = 0; i < 2; i++){
				revealCards(1);
				render(pot);
				pot += placeBets();
			}
			Player winner = pickWinner();
			winner.addChips(pot);
			render(0, true);
			if(winner.equals(player[0])) {
				JOptionPane.showMessageDialog(null, "You won $" + pot + "!");
			} else {
				JOptionPane.showMessageDialog(null, winner.toString() + " won $" + pot + ".");
			}
			removeDeadPlayers();
		}
		if(player[0].getChips() > 0) {
			JOptionPane.showMessageDialog(null, "You walked away with $" + pot + "!");
		} else {
			JOptionPane.showMessageDialog(null, "You walked away with... well, the clothes on your back.");
		}
		table.frame.dispose();
	}
	
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

	private static int placeBets() {
		int wagers = 0;
		for(int i = 0; i < numPlayers; i++)
			wagers += player[i].takeChips(player[i].placeBet());
		return wagers;
	}
	
	public static void render(int pool){
		table.cleanupGUI();
		for(int i = 0; i < numPlayers; i++){
			player[i].render(table);
		}
		table.render(pool);
	}

	public static void render(int pool, boolean show){
		table.cleanupGUI();
		for(int i = 0; i < numPlayers; i++){
			player[i].render(table, show);
		}
		table.render(pool);
	}

	public static Player pickWinner(){ 
		int tempHigh = 0;
		for (int i = 1; i < numPlayers; i++) {
				if (player[i].tieBreaker() > player[tempHigh].tieBreaker())
					tempHigh = i;
		}
		return player[tempHigh];
	}
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
