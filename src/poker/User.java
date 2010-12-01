package poker;

import javax.swing.JOptionPane;

public class User extends Player {
     
 	
     public User(int m) {
		super(m);
	}

//	protected String[] hand = new String[2]; 		// this is old code 
	public String getUserName(){
     	String playerName = JOptionPane.showInputDialog(null,
     	"Enter your player name");
     	return playerName;
	}
}
