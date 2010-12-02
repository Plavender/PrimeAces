package poker;
/**
 * Constructor for Human user
 * @author Colin
 */

import javax.swing.JOptionPane;

public class User extends Player {
     
	 private int betAmount;
 	
     public User(int money, String myName, int x, int y) {
		super(money, myName, x, y);
		isUser = true;
	}
	
	@Override
	public String toString() {
		return name;
	}
	/**
	 * Place bet for user,  overrides to catch mistakes
	 * @return int pBet
	 */

	public int placeBet() {
		int	pBet = 0;
		String bet;
		if(!folded)
		{
			do {
				
			String[] selectionValues = new String[2];
			selectionValues[0] = "Bet";
			selectionValues[1] = "Fold";
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			}
			while(bet == null);
			}
		else
		{
			bet = "0";
		}
		try
		{
		pBet = Integer.parseInt(bet);
		}
		catch(NumberFormatException e)
		{
			bet = JOptionPane.showInputDialog(null, "Place your bet must be an integer; no decimals or letters");
			pBet = Integer.parseInt(bet);
		}
		
		//Error handling to handle negative numbers or zero dollar bets
		while (pBet <= 0 || pBet > chips){
			JOptionPane.showMessageDialog(null, "Please enter a valid bet");
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			pBet = Integer.parseInt(bet);
		}
		return pBet;
	}

		
       
}
