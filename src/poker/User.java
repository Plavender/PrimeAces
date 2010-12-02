package poker;

import javax.swing.JOptionPane;

public class User extends Player {
     
 	
     public User(int money, String myName, int x, int y) {
		super(money, myName, x, y);
		isUser = true;
	}
	
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int placeBet() {
		int pBet = 0;
		String bet;
		if(!folded)
		{
			String[] selectionValues = new String[2];
			selectionValues[0] = "Bet";
			selectionValues[1] = "Fold";
			bet = JOptionPane.showInputDialog(null, "Place your bet");
		}
		else
		{
			bet = "0";
		}
		
		pBet = Integer.parseInt(bet);
		
		//Error handling to handle negative numbers or zero dollar bets
		while (pBet <= 0){
			JOptionPane.showMessageDialog(null, "Please enter a valid bet");
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			pBet = Integer.parseInt(bet);
		}
		return pBet;
	}
}
