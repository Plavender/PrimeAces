package poker;


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Rather than reinvent the wheel, I kept the original GUI layout
 * and added code where it was needed produce the desired effect.
 * This version does not contain code as of yet to allow the user to
 * continue playing with their accrued winnings (still in development)
 *
 *@version 1.2
 */
@SuppressWarnings("serial")
public class HoldEm extends JPanel implements ActionListener {
	private Button Bet1, Bet2, Bet3, Bet4, Fold;
	private int pool;
	private Play playArea = new Play();
	private JLabel AICard1Fliped, AICard2Fliped, AICard1Text, AICard1,
			AICard2Text, AICard2, TableCard1Text, TableCard1, TableCard2Text,
			TableCard2, TableCard3Text, TableCard3, TableCard4Text, TableCard4,
			TableCard5Text, TableCard5, potChipNum, playerChipNum, compChipNum;
	private JLabel H1, H2, H3, H4, H5;
	private int pBet;
	private int humanMon = 250;
	private int compMon = 250;
	private String bet, h1, h2, a1, a2, hd1, hd2, ad1, ad2, c1, c2, c3, c4, c5,
			cd1, cd2, cd3, cd4, cd5;
	private Suit hd1s, hd2s, ad1s, ad2s, cd1s, cd2s, cd3s, cd4s, cd5s;
	private JFrame frame;
	private Player human = new Player(0);
	private Player computer = new Player(0);
	

	public HoldEm() {

		Deck playDeck = new Deck();
		playDeck.makeDeck();
		pool = 0;
		
		// creating play area
		computer.addMoney(compMon);
		human.addMoney(humanMon);
		
		/**
		 * While loop used to control single game flow- this is an area
		 * that can be modified to allow continual play, perhaps by changing
		 * the test condition to while humanMon > 0 and other code revisions
		 */
		boolean playing = true;
		int x = 1;
		while (playing) {

			// shuffle the deck
			playDeck.shuffle();

			// getting the card data
			// dealing cards
			h1 = playDeck.getCard();
			h2 = playDeck.getCard();
			a1 = playDeck.getCard();
			a2 = playDeck.getCard();

			human.getCard(h1);
			computer.getCard(a1);
			human.getCard(h2);
			computer.getCard(a2);

			hd1 = (h1.substring(1, 2));
			hd2 = (h2.substring(1, 2));
			ad1 = (a1.substring(1, 2));
			ad2 = (a2.substring(1, 2));

			// getting and organizing play card data
			c1 = playDeck.getCard();
			c2 = playDeck.getCard();
			c3 = playDeck.getCard();
			c4 = playDeck.getCard();
			c5 = playDeck.getCard();

			playArea.addToPlay(c1);
			playArea.addToPlay(c2);
			playArea.addToPlay(c3);
			playArea.addToPlay(c4);
			playArea.addToPlay(c5);

			// finding the value on the cards
			cd1 = (c1.substring(1, 2));
			cd2 = (c2.substring(1, 2));
			cd3 = (c3.substring(1, 2));
			cd4 = (c4.substring(1, 2));
			cd5 = (c5.substring(1, 2));

			String[] ct = new String[9];

			// getting rid of the ts
			ct[0] = hd1;
			ct[1] = hd2;
			ct[2] = ad1;
			ct[3] = ad2;
			ct[4] = cd1;
			ct[5] = cd2;
			ct[6] = cd3;
			ct[7] = cd4;
			ct[8] = cd5;

			for (x = 0; x < 9; x++) {
				String s = ct[x];
				if (s.equals("t"))
					ct[x] = "10";
			}

			hd1 = ct[0];
			hd2 = ct[1];
			ad1 = ct[2];
			ad2 = ct[3];
			cd1 = ct[4];
			cd2 = ct[5];
			cd3 = ct[6];
			cd4 = ct[7];
			cd5 = ct[8];

			// making the suit objects to identify card suits
			hd1s = new Suit(h1);
			hd2s = new Suit(h2);
			ad1s = new Suit(a1);
			ad2s = new Suit(a2);
			cd1s = new Suit(c1);
			cd2s = new Suit(c2);
			cd3s = new Suit(c3);
			cd4s = new Suit(c4);
			cd5s = new Suit(c5);

			/**
			 * Setup of the GUI; GridBagLayout seems to work best for this play area.
			 * Tried to use a GridLayout, however the major issue with it was getting
			 * the money values to appear within the poker chips- with the latter
			 * it wouldn't work.
			 */
			frame = new JFrame("Texas Hold em'");
			//new code added here- program wasn't closing because the 
			//frame wasn't set to exit on close.
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			Container Table = frame.getContentPane();
			Table.setBackground(new Color(34, 139, 34));
			Table.setLayout(new GridBagLayout());
			GridBagConstraints f = new GridBagConstraints();
			
			/**
			 * Getting the players name; with the impending code revision, this
			 * snippet will probably be moved to the main driver class- setting
			 * up the string variable to be read outside of the class may be 
			 * a bit of a challenge.
			 * 
			 * Code also has to be added (if/else) to terminate the program
			 * is no name is chosen.
			 */
			String playerName = JOptionPane.showInputDialog(null,
					"Enter your player name");
			
			//Images for play area- new chip image
			ImageIcon deck = new ImageIcon("cardback.jpg");
			ImageIcon chip = new ImageIcon("chip2.jpg");
			
			/**
			 * Top section of table; computer's play area
			 */
			//Computer player name label and placement on the board
			JLabel Comp = new JLabel("Player: Billy");
			f.gridx = 0;
			f.gridy = 0;
			Comp.setFont(new Font("sansserif", Font.BOLD, 24));
			Comp.setForeground(Color.white);
			Table.add(Comp, f);
			
			//Computers first card; bg shown, actual values with suit hidden
			AICard1Fliped = new JLabel(deck);
			f.gridx = 1;
			f.gridy = 0;
			Table.add(AICard1Fliped, f);
			AICard1Text = new JLabel(ad1);
			f.gridx = 1;
			f.gridy = 0;
			AICard1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(AICard1Text, f);
			AICard1Text.setVisible(false);
			AICard1 = new JLabel(ad1s.getImage());
			f.gridx = 1;
			f.gridy = 0;
			Table.add(AICard1, f);
			AICard1.setVisible(false);
			
			//Computers second card; bg shown, actual values with suit hidden
			AICard2Fliped = new JLabel(deck);
			f.gridx = 2;
			f.gridy = 0;
			Table.add(AICard2Fliped, f);
			AICard2Text = new JLabel(ad2);
			f.gridx = 2;
			f.gridy = 0;
			AICard2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(AICard2Text, f);
			AICard2Text.setVisible(false);
			AICard2 = new JLabel(ad2s.getImage());
			f.gridx = 2;
			f.gridy = 0;
			Table.add(AICard2, f);
			AICard2.setVisible(false);
			
			//computers chips with value; new chip image and fonts
			compChipNum = new JLabel("$" + computer.getMoney());
			f.gridx = 3;
			f.gridy = 0;
			compChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			compChipNum.setForeground(Color.black);
			Table.add(compChipNum, f);
			JLabel AIChips = new JLabel(chip);
			f.gridx = 3;
			f.gridy = 0;
			Table.add(AIChips, f);
			
			/**
			 * Center section of table with community cards
			 */
			//Sets card 1 to the cover image initially- new code
			H1 = new JLabel(deck);
			f.gridx = 0;
			f.gridy = 1;
			Table.add(H1, f);
			H1.setVisible(true);
			
			//Sets card 1 to its true value; visibility set to false 
			TableCard1Text = new JLabel(cd1);
			f.gridx = 0;
			f.gridy = 1;
			TableCard1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard1Text, f);
			TableCard1 = new JLabel(cd1s.getImage());
			f.gridx = 0;
			f.gridy = 1;
			Table.add(TableCard1, f);
			TableCard1Text.setVisible(false);
			TableCard1.setVisible(false);

			//Sets card 2 to the cover image initially- new code
			H2 = new JLabel(deck);
			f.gridx = 1;
			f.gridy = 1;
			Table.add(H2, f);
			H2.setVisible(true);
			
			//Sets card 2 to its true value; visibility set to false
			TableCard2Text = new JLabel(cd2);
			f.gridx = 1;
			f.gridy = 1;
			TableCard2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard2Text, f);
			TableCard2 = new JLabel(cd2s.getImage());
			f.gridx = 1;
			f.gridy = 1;
			Table.add(TableCard2, f);
			TableCard2Text.setVisible(false);
			TableCard2.setVisible(false);

			//Sets card 3 to the cover image initially- new code
			H3 = new JLabel(deck);
			f.gridx = 2;
			f.gridy = 1;
			Table.add(H3, f);
			H3.setVisible(true);
			
			//Sets card 3 to its true value; visibility set to false
			TableCard3Text = new JLabel(cd3);
			f.gridx = 2;
			f.gridy = 1;
			TableCard3Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard3Text, f);
			TableCard3 = new JLabel(cd3s.getImage());
			f.gridx = 2;
			f.gridy = 1;
			Table.add(TableCard3, f);
			TableCard3Text.setVisible(false);
			TableCard3.setVisible(false);

			//Sets card 4 to the cover image initially- new code
			H4 = new JLabel(deck);
			f.gridx = 3;
			f.gridy = 1;
			Table.add(H4, f);
			H4.setVisible(true);
			
			//Sets card 4 to its true value; visibility set to false
			TableCard4Text = new JLabel(cd4);
			f.gridx = 3;
			f.gridy = 1;
			TableCard4Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard4Text, f);
			TableCard4 = new JLabel(cd4s.getImage());
			f.gridx = 3;
			f.gridy = 1;
			Table.add(TableCard4, f);
			TableCard4Text.setVisible(false);
			TableCard4.setVisible(false);

			//Sets card 5 to the cover image initially- new code
			H5 = new JLabel(deck);
			f.gridx = 4;
			f.gridy = 1;
			Table.add(H5, f);
			H5.setVisible(true);
			
			//Sets card 5 to its true value; visibility set to false
			TableCard5Text = new JLabel(cd5);
			f.gridx = 4;
			f.gridy = 1;
			TableCard5Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard5Text, f);
			TableCard5 = new JLabel(cd5s.getImage());
			f.gridx = 4;
			f.gridy = 1;
			Table.add(TableCard5, f);
			TableCard5Text.setVisible(false);
			TableCard5.setVisible(false);

			// sets the table pot; new chip image and fonts
			potChipNum = new JLabel("$" + pool);
			f.gridx = 5;
			f.gridy = 1;
			potChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			potChipNum.setForeground(Color.black);
			Table.add(potChipNum, f);
			JLabel PotChips = new JLabel(chip);
			f.gridx = 5;
			f.gridy = 1;
			Table.add(PotChips, f);

			/**
			 * Lower section of table; players area
			 */
			// sets player name from user input
			JLabel player = new JLabel("Player: " + playerName);
			f.gridx = 0;
			f.gridy = 2;
			player.setFont(new Font("sansserif", Font.BOLD, 24));
			player.setForeground(Color.white);
			Table.add(player, f);

			// sets players first card
			JLabel PlayerCard1Text = new JLabel(hd1);
			f.gridx = 1;
			f.gridy = 2;
			PlayerCard1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(PlayerCard1Text, f);
			JLabel PlayerCard1 = new JLabel(hd1s.getImage());
			f.gridx = 1;
			f.gridy = 2;
			Table.add(PlayerCard1, f);

			// sets players second card
			JLabel PlayerCard2Text = new JLabel(hd2);
			f.gridx = 2;
			f.gridy = 2;
			PlayerCard2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(PlayerCard2Text, f);
			JLabel PlayerCard2 = new JLabel(hd2s.getImage());
			f.gridx = 2;
			f.gridy = 2;
			Table.add(PlayerCard2, f);

			// sets players chips- new chip image and fonts
			playerChipNum = new JLabel("$" + human.getMoney());
			f.gridx = 3;
			f.gridy = 2;
			playerChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			playerChipNum.setForeground(Color.black);
			Table.add(playerChipNum, f);
			JLabel PlayerChips = new JLabel(chip);
			f.gridx = 3;
			f.gridy = 2;
			Table.add(PlayerChips, f);

			// adds buttons and liseners
			//initial betting button
			Bet1 = new Button("    Bet    ");
			f.gridx = 4;
			f.gridy = 2;
			Table.add(Bet1, f);
			//second betting button- set to false until the flop
			Bet2 = new Button("    Bet    ");
			f.gridx = 4;
			f.gridy = 2;
			Table.add(Bet2, f);
			Bet2.setVisible(false);
			//Third betting button- set to false until the turn
			Bet3 = new Button("    Bet    ");
			f.gridx = 4;
			f.gridy = 2;
			Table.add(Bet3, f);
			Bet3.setVisible(false);
			//Fourth betting button- set to false until the river
			Bet4 = new Button("    Bet    ");
			f.gridx = 4;
			f.gridy = 2;
			Table.add(Bet4, f);
			Bet4.setVisible(false);
			//fold button
			Fold = new Button("Fold");
			f.gridx = 5;
			f.gridy = 2;
			Table.add(Fold, f);
			//add the action listeners
			Bet1.addActionListener(this);
			Bet2.addActionListener(this);
			Bet3.addActionListener(this);
			Bet4.addActionListener(this);
			Fold.addActionListener(this);
		
			
			frame.pack();
			frame.setVisible(true);
		}
	}

	

	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getSource());
		if (e.getSource() == Fold) {
			playArea.wipe();
			human.wipe();
			computer.wipe();
			JOptionPane.showMessageDialog(null, "You fold, Billy wins");
			frame.dispose();
			new HoldEm();
		} else if (e.getSource() == Bet1) {
			JOptionPane.showMessageDialog(null, "Auto ante of $10");
			human.takeMoney(10);
			System.out.println(human.getMoney());
			computer.takeMoney(10);
			System.out.println(computer.getMoney());
			pool += 20;
			System.out.println(pool);
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			pBet = Integer.parseInt(bet);
			if (pBet >= human.getMoney())
				pBet = human.getMoney();
			human.takeMoney(pBet);
			computer.takeMoney(pBet);
			pool += pBet * 2;
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getMoney());
			playerChipNum.setText("$" + human.getMoney());
			Bet1.setVisible(false);
			Bet2.setVisible(true);
			TableCard1Text.setVisible(true);
			TableCard1.setVisible(true);
			//remove the deck card for card one- replace with true value- new code
			H1.setVisible(false);
			TableCard2Text.setVisible(true);
			TableCard2.setVisible(true);
			//remove the deck card for card two- replace with true value- new code
			H2.setVisible(false);
			TableCard3Text.setVisible(true);
			TableCard3.setVisible(true);
			//remove the deck card for card three- replace with true value- new code
			H3.setVisible(false);
			frame.pack();
			frame.setVisible(true);
			validate();
		} else if (e.getSource() == Bet2) {
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			pBet = Integer.parseInt(bet);
			human.takeMoney(pBet);
			computer.takeMoney(pBet);
			pool += pBet * 2;
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getMoney());
			playerChipNum.setText("$" + human.getMoney());
			Bet2.setVisible(false);
			Bet3.setVisible(true);
			TableCard4Text.setVisible(true);
			TableCard4.setVisible(true);
			//remove the deck card for card four- replace with true value- new code
			H4.setVisible(false);
			frame.pack();
			frame.setVisible(true);
			validate();
		} else if (e.getSource() == Bet3) {
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			pBet = Integer.parseInt(bet);
			human.takeMoney(pBet);
			computer.takeMoney(pBet);
			pool += pBet * 2;
			Bet3.setVisible(false);
			TableCard5Text.setVisible(true);
			TableCard5.setVisible(true);
			//remove the deck card for card five- replace with true value- new code
			H5.setVisible(false);
			Bet4.setVisible(true);
			frame.pack();
			frame.setVisible(true);
			validate();
		} else if (e.getSource() == Bet4) {
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			pBet = Integer.parseInt(bet);
			human.takeMoney(pBet);
			computer.takeMoney(pBet);
			pool += pBet * 2;
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getMoney());
			playerChipNum.setText("$" + human.getMoney());
			Bet4.setEnabled(false);
			humanMon = human.getMoney();
			compMon = computer.getMoney();
			AICard1Fliped.setVisible(false);
			AICard2Fliped.setVisible(false);
			AICard1Text.setVisible(true);
			AICard1.setVisible(true);
			AICard2Text.setVisible(true);
			AICard2.setVisible(true);
			frame.pack();
			frame.setVisible(true);
			validate();
			Sets chooser = new Sets(human.getHand(), computer.getHand(),
					playArea.getInPlay());
			// boolean win = chooser.Winner();
			int win = Score.playerWin(chooser.hplayer, chooser.cplayer,
					chooser.hcards);
			if (win == 0) {
				JOptionPane.showMessageDialog(null, "You win");
				human.addMoney(pool); 
				frame.dispose();
				new HoldEm();
				if (human.getMoney() == 0)
					JOptionPane.showMessageDialog(null, "you lose");
			} else if (win == 1) {
				JOptionPane.showMessageDialog(null, "You lose");
				computer.addMoney(pool);
				frame.dispose();
				new HoldEm();
			} else {
				JOptionPane.showMessageDialog(null, "The game is a tie");
				playArea.wipe();
				human.wipe();
				computer.wipe();
				frame.dispose();
				//new code
				

				new HoldEm();
				
			}
		}
	}

	//Removed and placed in its own class- cosmetic purposes
//	public static void main(String[] args) {
//		new HoldEm();
//	}

}
