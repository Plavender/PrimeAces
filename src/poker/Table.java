package poker;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This version of HoldEm java incorporates two additional computer players.
 * It also has error handling for invalid bet amounts (0 or negative).
 * To allow for additional players, the Score and Sets classes had to 
 * undergo minor modification.
 * This project build DOES NOT contain the updated Deck and card class
 * (Please see attached document that came with project zip file)
 *  
 * This version does not contain code as of yet to allow the user to
 * continue playing with their accrued winnings (still in development)
 *@author Allen
 *@version 1.3
 */
@SuppressWarnings("serial")
public class Table extends JPanel {	
	public JFrame frame = null;
	public Container GUI = null;
	public GridBagConstraints coord = null;
	//Images for play area- new chip image
	public static ImageIcon chipImg = new ImageIcon("chip2.jpg");
	//New code to fill in background for middle table empty spaces
	public static ImageIcon background = new ImageIcon("bg.jpg");

	// array of cards for play area maximum of 5 
	Card[] cards = new Card[5];
	int inPlay = 0;

	public Table() {
		frame = new JFrame("Texas Hold em'");
//		this.add(frame);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		GUI = frame.getContentPane();
		GUI.setBackground(new Color(34, 139, 34));
		GUI.setLayout(new GridBagLayout());
		coord = new GridBagConstraints();
		frame.pack();
		frame.setVisible(true);
		GUI.validate();
	}

	public void cleanupGUI() {
		GUI.removeAll();
	}

	public void clear(){
		inPlay = 0;
	}
	public void render(int pot){
		/**
		 * Setup of the GUI; GridBagLayout seems to work best for this play area.
		 * Tried to use a GridLayout, however the major issue with it was getting
		 * the money values to appear within the poker chips- with the latter
		 * it wouldn't work.
		 */
		GUI.setBackground(new Color(34, 139, 34));

		for(int i = 0; i < 5; i++) {
			coord.gridx = 2 + i;
			coord.gridy = 1;
			if(i < inPlay) {
				cards[i].render(GUI, coord, true);
			} else {
				new Card("", "", 0).render(GUI, coord, false);
			}
		}
		//Label the chip pot
		JLabel ChipPot = new JLabel("Up For Grabs:");
		coord.gridx = 8;
		coord.gridy = 1;
		ChipPot.setFont(new Font("sansserif", Font.BOLD, 16));
		ChipPot.setForeground(Color.white);
		GUI.add(ChipPot, coord);
		// sets the table pot; new chip image and fonts
		JLabel potChipNum = new JLabel("$" + pot);
		coord.gridx = 9;
		coord.gridy = 1;
		potChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
		potChipNum.setForeground(Color.black);
		GUI.add(potChipNum, coord);
		JLabel PotChips = new JLabel(chipImg);
		coord.gridx = 9;
		coord.gridy = 1;
		GUI.add(PotChips, coord);

		frame.pack();
		frame.setVisible(true);
		GUI.validate();
	}	
	
	// adds a card object to the playArea array
	public void addCard(Card c)
	{
		if (inPlay < 5)
		{
			cards[inPlay] = c;
			inPlay++;
		}	
	}
	
	
}
