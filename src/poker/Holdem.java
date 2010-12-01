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
 * This version of HoldEm java incorporates two additional computer players.
 * It also has error handling for invalid bet amounts (0 or negative).
 * To allow for additional players, the Score and Sets classes had to 
 * undergo minor modification.
 * This project build DOES NOT contain the updated Deck and card class
 * (Please see attached document that came with project zip file)
 *  
 * This version does not contain code as of yet to allow the user to
 * continue playing with thier accrued winnings (still in development)
 *
 *@version 1.3
 */
@SuppressWarnings("serial")
public class HoldEm extends JPanel implements ActionListener {
	private Button Bet1, Bet2, Bet3, Bet4, Fold;
	private int pool;
	private Play playArea = new Play();
	private Score score = new Score();
	private JLabel AICard1Fliped, AICard2Fliped, AICard1Text, AICard1,
			AICard2Text, AICard2, TableCard1Text, TableCard1, TableCard2Text,
			TableCard2, TableCard3Text, TableCard3, TableCard4Text, TableCard4,
			TableCard5Text, TableCard5, potChipNum, playerChipNum, compChipNum;
	/**
	 * New label variables for multiple player game.
	 */
	private JLabel AI2Card1Fliped, AI2Card2Fliped, AI2Card1Text, AI2Card1, 
			AI2Card2Text, AI2Card2, AI3Card1Fliped, AI3Card2Fliped, AI3Card1Text,
			AI3Card1, AI3Card2Text, AI3Card2, compChipNum2, compChipNum3;
			
	
	private JLabel H1, H2, H3, H4, H5;
	/**
	 * New label variables for blank spaces in the middle of the table
	 */
	private JLabel B1, B2, B3, B4, B5;
	
	private int pBet;
	private int humanMon = 250;
	/**
	 * Added money variables for multiple player game.
	 */
	private int compMon = 250, compMon2 = 250, compMon3 = 250;
	
	private String bet, playerName;
	private Card  h1, h2, a1, a2, hd1, hd2, ad1, ad2, c1, c2, c3, c4, c5;
	/**
	 * Added variables for multiplayer game
	 */
	private Card a21, a22, a31, a32, ad21, ad22, ad31, ad32;
	
	private Suit hd1s, hd2s, ad1s, ad2s, cd1s, cd2s, cd3s, cd4s, cd5s;
	/**
	 * Added variables for multiplayer game
	 */
	private Suit ad21s, ad22s, ad31s, ad32s;
	
	private JFrame frame;

	private User human = new User(0);
	/**
	 * New variables for multiplayer game.
	 */
	private Computer computer = new Computer(0);
	private Computer computer2 = new Computer(0);
	private Computer computer3 = new Computer(0);
	
	public HoldEm() {

		Deck playDeck = new Deck();
//		playDeck.makeDeck();
		
		//Original code for two player game
		computer.addChips(compMon);
		human.addChips(humanMon);
		//Code added for multi player game
		computer2.addChips(compMon2);
		computer3.addChips(compMon3);
		
		/**
		 * While loop used to control single game flow- this is an area
		 * that can be modified to allow continual play, perhaps by changing
		 * the test condition to while humanMon > 0 and other code revisions
		 */
		boolean playing = true;
//		int x = 1;
		playerName = human.getUserName();
		while (playing) {

			pool = 0;
			// shuffle the deck
			playDeck.shuffle();

			h1 = playDeck.getCard();
			h2 = playDeck.getCard();
			a1 = playDeck.getCard();
			a2 = playDeck.getCard();
			hd1 = playDeck.getCard();
			hd2 = playDeck.getCard();
			ad1 = playDeck.getCard();
			ad2 = playDeck.getCard();
			c1 = playDeck.getCard();
			c2 = playDeck.getCard();
			c3 = playDeck.getCard();
			c4 = playDeck.getCard();
			c5 = playDeck.getCard();
			
			// getting the card data
			// dealing cards
			h1 = playDeck.getCard();
			h2 = playDeck.getCard();
			a1 = playDeck.getCard();
			a2 = playDeck.getCard();
			//added code for multiplayer game
			a21 = playDeck.getCard();
			a22 = playDeck.getCard();
			a31 = playDeck.getCard();
			a32 = playDeck.getCard();

			human.addPlayerHand(h1, 1);
			computer.addPlayerHand(a1, 1);
			//added code for multiplayer game
			computer2.addPlayerHand(a21, 1);
			computer3.addPlayerHand(a31, 1);
			
			human.addPlayerHand(h2, 2);
			computer.addPlayerHand(a2, 2);
			//added code for multiplayer game
			computer2.addPlayerHand(a22, 2);
			computer3.addPlayerHand(a32, 2);

			human.addCard(h1);
			computer.addCard(a1);
			computer2.addCard(a21);
			computer3.addCard(a31);
			
			human.addCard(h2);
			computer.addCard(a2);
			computer2.addCard(a22);
			computer3.addCard(a32);
			
			human.addCard(c1);
			human.addCard(c2);
			human.addCard(c3);
			human.addCard(c4);
			human.addCard(c5);
			
			computer.addCard(c1);
			computer.addCard(c2);
			computer.addCard(c3);
			computer.addCard(c4);
			computer.addCard(c5);
			
			computer2.addCard(c1);
			computer2.addCard(c2);
			computer2.addCard(c3);
			computer2.addCard(c4);
			computer2.addCard(c5);
			
			computer3.addCard(c1);
			computer3.addCard(c2);
			computer3.addCard(c3);
			computer3.addCard(c4);
			computer3.addCard(c5);
			
//			hd1 = (h1.substring(1, 2));
//			hd2 = (h2.substring(1, 2));
//			ad1 = (a1.substring(1, 2));
//			ad2 = (a2.substring(1, 2));
//			//added code for multiplayer game
			ad21 = playDeck.getCard();
			ad22 = playDeck.getCard();
			ad31 = playDeck.getCard();
			ad32 = playDeck.getCard();

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
//			cd1 = (c1.substring(1, 2));
//			cd2 = (c2.substring(1, 2));
//			cd3 = (c3.substring(1, 2));
//			cd4 = (c4.substring(1, 2));
//			cd5 = (c5.substring(1, 2));

//			String[] ct = new String[15];

			// getting rid of the ts
//			ct[0] = hd1;
//			ct[1] = hd2;
//			ct[2] = ad1;
//			ct[3] = ad2;
			//added code for multiplayer game
//			ct[4] = ad21;
//			ct[5] = ad22;
//			ct[6] = ad31;
//			ct[7] = ad32;
			//for the community cards
//			ct[8] = cd1;
//			ct[9] = cd2;
//			ct[10] = cd3;
//			ct[11] = cd4;
//			ct[12] = cd5;

			//changed test from 9 to 15 to match array length
//			for (x = 0; x < 13; x++) {
//				String s = ct[x];
//				if (s.equals("t"))
//					ct[x] = "10";
//			}

//			hd1 = ct[0];
//			hd2 = ct[1];
//			ad1 = ct[2];
//			ad2 = ct[3];
			//Added code for multiplayer game
//			ad21 = ct[4];
//			ad22 = ct[5];
//			ad31 = ct[6];
//			ad32 = ct[7];
			//continuing existing code
//			cd1 = ct[8];
//			cd2 = ct[9];
//			cd3 = ct[10];
//			cd4 = ct[11];
//			cd5 = ct[12];

			// making the suit objects to identify card suits
			hd1s = new Suit(h1);
			hd2s = new Suit(h2);
			ad1s = new Suit(a1);
			ad2s = new Suit(a2);
			//added code for multiplayer game
			ad21s = new Suit(a21);
			ad22s = new Suit(a22);
			ad31s = new Suit(a31);
			ad32s = new Suit(a32);
			//continuing existing code
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
//			playerName = human.getUserName();
			//Images for play area- new chip image
			ImageIcon deck = new ImageIcon("cardback.jpg");
			ImageIcon chip = new ImageIcon("chip2.jpg");
			//New code to fill in background for middle table empty spaces
			ImageIcon bgrd = new ImageIcon("bg.jpg");
			
			/**
			 * Top section of table; 3 computer players area
			 */
			//First computer player name label and placement on the board
			JLabel Comp = new JLabel("Billy the Kid");
			f.gridx = 0;
			f.gridy = 0;
			Comp.setFont(new Font("sansserif", Font.BOLD, 16));
			Comp.setForeground(Color.white);
			Table.add(Comp, f);
			//First computer players first card; bg shown, actual values with suit hidden
			AICard1Fliped = new JLabel(deck);
			f.gridx = 1;
			f.gridy = 0;
			Table.add(AICard1Fliped, f);
			AICard1Text = new JLabel(ad1.getName());
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
			//First computer players second card; bg shown, actual values with suit hidden
			AICard2Fliped = new JLabel(deck);
			f.gridx = 2;
			f.gridy = 0;
			Table.add(AICard2Fliped, f);
			AICard2Text = new JLabel(ad2.getName());
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
			//First computer players chips with value; new chip image and fonts
			compChipNum = new JLabel("$" + computer.getChips());
			f.gridx = 3;
			f.gridy = 0;
			compChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			compChipNum.setForeground(Color.black);
			Table.add(compChipNum, f);
			JLabel AIChips = new JLabel(chip);
			f.gridx = 3;
			f.gridy = 0;
			Table.add(AIChips, f);
			
			//Second computer player name label and placement on the board
			JLabel Comp2 = new JLabel("Doc Holliday");
			f.gridx = 4;
			f.gridy = 0;
			Comp2.setFont(new Font("sansserif", Font.BOLD, 16));
			Comp2.setForeground(Color.white);
			Table.add(Comp2, f);
			//Second computer players first card; bg shown, actual values with suit hidden
			AI2Card1Fliped = new JLabel(deck);
			f.gridx = 5;
			f.gridy = 0;
			Table.add(AI2Card1Fliped, f);
			AI2Card1Text = new JLabel(ad21.getName());
			f.gridx = 5;
			f.gridy = 0;
			AI2Card1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(AI2Card1Text, f);
			AI2Card1Text.setVisible(false);
			AI2Card1 = new JLabel(ad21s.getImage());
			f.gridx = 5;
			f.gridy = 0;
			Table.add(AI2Card1, f);
			AI2Card1.setVisible(false);
			//Second computer players second card; bg shown, actual values with suit hidden
			AI2Card2Fliped = new JLabel(deck);
			f.gridx = 6;
			f.gridy = 0;
			Table.add(AI2Card2Fliped, f);
			AI2Card2Text = new JLabel(ad22.getName());
			f.gridx = 6;
			f.gridy = 0;
			AI2Card2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(AI2Card2Text, f);
			AI2Card2Text.setVisible(false);
			AI2Card2 = new JLabel(ad22s.getImage());
			f.gridx = 6;
			f.gridy = 0;
			Table.add(AI2Card2, f);
			AI2Card2.setVisible(false);
			//Second computer players chips with value; new chip image and fonts
			compChipNum2 = new JLabel("$" + computer2.getChips());
			f.gridx = 7;
			f.gridy = 0;
			compChipNum2.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			compChipNum2.setForeground(Color.black);
			Table.add(compChipNum2, f);
			JLabel AIChips2 = new JLabel(chip);
			f.gridx = 7;
			f.gridy = 0;
			Table.add(AIChips2, f);
			
			//Set up two blank spaces for alignment purposes
			//First space
			B1 = new JLabel(bgrd);
			f.gridx = 8;
			f.gridy = 0;
			Table.add(B1, f);
			//Second space
			B2 = new JLabel(bgrd);
			f.gridx = 9;
			f.gridy = 0;
			Table.add(B2, f);
			
			/**
			 * Center section of table with community cards
			 */
			
			//Set up two blank spaces for alignment purposes
			//First space
			B3 = new JLabel(bgrd);
			f.gridx = 0;
			f.gridy = 1;
			Table.add(B3, f);
			//Second space
			B4 = new JLabel(bgrd);
			f.gridx = 1;
			f.gridy = 1;
			Table.add(B4, f);
			
			//Community cards
			//Sets card 1 to the cover image initially- new code
			H1 = new JLabel(deck);
			f.gridx = 2;
			f.gridy = 1;
			Table.add(H1, f);
			H1.setVisible(true);
			//Sets card 1 to its true value; visibility set to false 
			TableCard1Text = new JLabel(c1.getName());
			f.gridx = 2;
			f.gridy = 1;
			TableCard1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard1Text, f);
			TableCard1 = new JLabel(cd1s.getImage());
			f.gridx = 2;
			f.gridy = 1;
			Table.add(TableCard1, f);
			TableCard1Text.setVisible(false);
			TableCard1.setVisible(false);

			//Sets card 2 to the cover image initially- new code
			H2 = new JLabel(deck);
			f.gridx = 3;
			f.gridy = 1;
			Table.add(H2, f);
			H2.setVisible(true);
			//Sets card 2 to its true value; visibility set to false
			TableCard2Text = new JLabel(c2.getName());
			f.gridx = 3;
			f.gridy = 1;
			TableCard2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard2Text, f);
			TableCard2 = new JLabel(cd2s.getImage());
			f.gridx = 3;
			f.gridy = 1;
			Table.add(TableCard2, f);
			TableCard2Text.setVisible(false);
			TableCard2.setVisible(false);

			//Sets card 3 to the cover image initially- new code
			H3 = new JLabel(deck);
			f.gridx = 4;
			f.gridy = 1;
			Table.add(H3, f);
			H3.setVisible(true);
			//Sets card 3 to its true value; visibility set to false
			TableCard3Text = new JLabel(c3.getName());
			f.gridx = 4;
			f.gridy = 1;
			TableCard3Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard3Text, f);
			TableCard3 = new JLabel(cd3s.getImage());
			f.gridx = 4;
			f.gridy = 1;
			Table.add(TableCard3, f);
			TableCard3Text.setVisible(false);
			TableCard3.setVisible(false);

			//Sets card 4 to the cover image initially- new code
			H4 = new JLabel(deck);
			f.gridx = 5;
			f.gridy = 1;
			Table.add(H4, f);
			H4.setVisible(true);
			//Sets card 4 to its true value; visibility set to false
			TableCard4Text = new JLabel(c4.getName());
			f.gridx = 5;
			f.gridy = 1;
			TableCard4Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard4Text, f);
			TableCard4 = new JLabel(cd4s.getImage());
			f.gridx = 5;
			f.gridy = 1;
			Table.add(TableCard4, f);
			TableCard4Text.setVisible(false);
			TableCard4.setVisible(false);

			//Sets card 5 to the cover image initially- new code
			H5 = new JLabel(deck);
			f.gridx = 6;
			f.gridy = 1;
			Table.add(H5, f);
			H5.setVisible(true);
			//Sets card 5 to its true value; visibility set to false
			TableCard5Text = new JLabel(c5.getName());
			f.gridx = 6;
			f.gridy = 1;
			TableCard5Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(TableCard5Text, f);
			TableCard5 = new JLabel(cd5s.getImage());
			f.gridx = 6;
			f.gridy = 1;
			Table.add(TableCard5, f);
			TableCard5Text.setVisible(false);
			TableCard5.setVisible(false);

			//Set up one blank spaces for alignment purposes
			B5 = new JLabel(bgrd);
			f.gridx = 7;
			f.gridy = 1;
			Table.add(B5, f);
			
			//Label the chip pot
			JLabel ChipPot = new JLabel("Up For Grabs:");
			f.gridx = 8;
			f.gridy = 1;
			ChipPot.setFont(new Font("sansserif", Font.BOLD, 16));
			ChipPot.setForeground(Color.white);
			Table.add(ChipPot, f);
			// sets the table pot; new chip image and fonts
			potChipNum = new JLabel("$" + pool);
			f.gridx = 9;
			f.gridy = 1;
			potChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			potChipNum.setForeground(Color.black);
			Table.add(potChipNum, f);
			JLabel PotChips = new JLabel(chip);
			f.gridx = 9;
			f.gridy = 1;
			Table.add(PotChips, f);

			/**
			 * Lower section of table; players area
			 */
			
			//Third computer player name label and placement on the board
			JLabel Comp3 = new JLabel("Maverick");
			f.gridx = 0;
			f.gridy = 2;
			Comp3.setFont(new Font("sansserif", Font.BOLD, 16));
			Comp3.setForeground(Color.white);
			Table.add(Comp3, f);
			//Third computer players first card; bg shown, actual values with suit hidden
			AI3Card1Fliped = new JLabel(deck);
			f.gridx = 1;
			f.gridy = 2;
			Table.add(AI3Card1Fliped, f);
			AI3Card1Text = new JLabel(ad31.getName());
			f.gridx = 1;
			f.gridy = 2;
			AI3Card1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(AI3Card1Text, f);
			AI3Card1Text.setVisible(false);
			AI3Card1 = new JLabel(ad31s.getImage());
			f.gridx = 1;
			f.gridy = 2;
			Table.add(AI3Card1, f);
			AI3Card1.setVisible(false);
			//Third computer players second card; bg shown, actual values with suit hidden
			AI3Card2Fliped = new JLabel(deck);
			f.gridx = 2;
			f.gridy = 2;
			Table.add(AI3Card2Fliped, f);
			AI3Card2Text = new JLabel(ad32.getName());
			f.gridx = 2;
			f.gridy = 2;
			AI3Card2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(AI3Card2Text, f);
			AI3Card2Text.setVisible(false);
			AI3Card2 = new JLabel(ad32s.getImage());
			f.gridx = 2;
			f.gridy = 2;
			Table.add(AI3Card2, f);
			AI3Card2.setVisible(false);
			//Third computer players chips with value; new chip image and fonts
			compChipNum3 = new JLabel("$" + computer3.getChips());
			f.gridx = 3;
			f.gridy = 2;
			compChipNum3.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			compChipNum3.setForeground(Color.black);
			Table.add(compChipNum3, f);
			JLabel AIChips3 = new JLabel(chip);
			f.gridx = 3;
			f.gridy = 2;
			Table.add(AIChips3, f);
			
			// sets player name from user input
			JLabel player = new JLabel(playerName);
			f.gridx = 4;
			f.gridy = 2;
			player.setFont(new Font("sansserif", Font.BOLD, 16));
			player.setForeground(Color.white);
			Table.add(player, f);

			// sets players first card
			JLabel PlayerCard1Text = new JLabel(hd1.getName());
			f.gridx = 5;
			f.gridy = 2;
			PlayerCard1Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(PlayerCard1Text, f);
			JLabel PlayerCard1 = new JLabel(hd1s.getImage());
			f.gridx = 5;
			f.gridy = 2;
			Table.add(PlayerCard1, f);

			// sets players second card
			JLabel PlayerCard2Text = new JLabel(hd2.getName());
			f.gridx = 6;
			f.gridy = 2;
			PlayerCard2Text.setFont(new Font("sansserif", Font.BOLD, 84));
			Table.add(PlayerCard2Text, f);
			JLabel PlayerCard2 = new JLabel(hd2s.getImage());
			f.gridx = 6;
			f.gridy = 2;
			Table.add(PlayerCard2, f);

			// sets players chips- new chip image and fonts
			playerChipNum = new JLabel("$" + human.getChips());
			f.gridx = 7;
			f.gridy = 2;
			playerChipNum.setFont(new Font("sansserif", Font.CENTER_BASELINE, 18));
			playerChipNum.setForeground(Color.black);
			Table.add(playerChipNum, f);
			JLabel PlayerChips = new JLabel(chip);
			f.gridx = 7;
			f.gridy = 2;
			Table.add(PlayerChips, f);

			// adds buttons and listeners
			//initial betting button
			Bet1 = new Button("    Bet    ");
			f.gridx = 8;
			f.gridy = 2;
			Table.add(Bet1, f);
			//second betting button- set to false until the flop
			Bet2 = new Button("    Bet    ");
			f.gridx = 8;
			f.gridy = 2;
			Table.add(Bet2, f);
			Bet2.setVisible(false);
			//Third betting button- set to false until the turn
			Bet3 = new Button("    Bet    ");
			f.gridx = 8;
			f.gridy = 2;
			Table.add(Bet3, f);
			Bet3.setVisible(false);
			//Fourth betting button- set to false until the river
			Bet4 = new Button("    Bet    ");
			f.gridx = 8;
			f.gridy = 2;
			Table.add(Bet4, f);
			Bet4.setVisible(false);
			//fold button
			Fold = new Button("Fold");
			f.gridx = 9;
			f.gridy = 2;
			Table.add(Fold, f);
			//add the action listeners
			Bet1.addActionListener(this);
			Bet2.addActionListener(this);
			Bet3.addActionListener(this);
			Bet4.addActionListener(this);
			Fold.addActionListener(this);
			
			//Assemble the package
			frame.pack();
			frame.setVisible(true);
			
			/**
			 * Ante up to begin the hand
			 */
			JOptionPane.showMessageDialog(null, "Auto ante of $10");
			human.takeChips(10);
			computer.takeChips(10);
			//Added code for multiplayer game
			computer2.takeChips(10);
			computer3.takeChips(10);
			pool += 40;
			
			/**
			 * First round of betting
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
	//			new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0 || pBet > human.getChips()){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			while (pBet <= 0 || pBet > human.getChips()){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			if (pBet >= human.getChips())
				pBet = human.getChips();
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(computer.bet());
			computer2.takeChips(computer2.bet());
			computer3.takeChips(computer3.bet());
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Change bet buttons for next round of betting
			Bet1.setVisible(false);
			Bet2.setVisible(true);
			//remove the deck card for card one- replace with true value- new code
			TableCard1Text.setVisible(true);
			TableCard1.setVisible(true);
			H1.setVisible(false);
			//remove the deck card for card two- replace with true value- new code
			TableCard2Text.setVisible(true);
			TableCard2.setVisible(true);
			H2.setVisible(false);
			//remove the deck card for card three- replace with true value- new code
			TableCard3Text.setVisible(true);
			TableCard3.setVisible(true);
			H3.setVisible(false);
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			//First round of betting is over
			
			/**
			 * Second round of betting 
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
//				new HoldEm();
				
				
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(computer.bet());
			computer2.takeChips(computer2.bet());
			computer3.takeChips(computer3.bet());
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Change bet buttons for next round of betting
			Bet2.setVisible(false);
			Bet3.setVisible(true);
			//remove the deck card for card four- replace with true value- new code
			TableCard4Text.setVisible(true);
			TableCard4.setVisible(true);
			H4.setVisible(false);
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			//Second round of betting is over
			
			/**
			 * Third round of betting 
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
		//		new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(pBet);
			computer2.takeChips(pBet);
			computer3.takeChips(pBet);
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Change bet buttons for next round of betting
			Bet3.setVisible(false);
			Bet4.setVisible(true);
			//remove the deck card for card five- replace with true value- new code
			TableCard5Text.setVisible(true);
			TableCard5.setVisible(true);
			H5.setVisible(false);
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			//Third round of betting is over

			/**
			 * Last round of betting 
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
//				new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(pBet);
			computer2.takeChips(pBet);
			computer3.takeChips(pBet);
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Disable last bet button; no more bets
			Bet4.setEnabled(false);
			
			humanMon = human.getChips();
			compMon = computer.getChips();
			
			/**
			 * Time to display opponents cards
			 */
			
			//Billy the Kids cards exposed
			AICard1Fliped.setVisible(false);
			AICard2Fliped.setVisible(false);
			AICard1Text.setVisible(true);
			AICard1.setVisible(true);
			AICard2Text.setVisible(true);
			AICard2.setVisible(true);
			
			//Doc Hollidays cards exposed
			AI2Card1Fliped.setVisible(false);
			AI2Card2Fliped.setVisible(false);
			AI2Card1Text.setVisible(true);
			AI2Card1.setVisible(true);
			AI2Card2Text.setVisible(true);
			AI2Card2.setVisible(true);
			
			//Mavericks cards exposed
			AI3Card1Fliped.setVisible(false);
			AI3Card2Fliped.setVisible(false);
			AI3Card1Text.setVisible(true);
			AI3Card1.setVisible(true);
			AI3Card2Text.setVisible(true);
			AI3Card2.setVisible(true);
			
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			
			/**
			 * Determine winner
			 * "Sets" class modified to determine winner
			 */
//			Sets chooser = new Sets(human.getHand(), computer.getHand(),
//					computer2.getHand(), computer2.getHand(), playArea.getInPlay());
			
//			int win = Score.playerWin(chooser.hplayer, chooser.cplayer,
//					chooser.cplayer2, chooser.cplayer3, chooser.hcards);
//			if (win == 0) {
//				JOptionPane.showMessageDialog(null, "You win");
//				human.addChips(pool); 
//				frame.dispose();
//				new HoldEm();
//				if (human.getChips() == 0)
//					JOptionPane.showMessageDialog(null, "you lose");
//			} else if (win == 1) {
//				JOptionPane.showMessageDialog(null, "You lose");
//				computer.addChips(pool);
//				frame.dispose();
//				new HoldEm();
//			} else {
//				JOptionPane.showMessageDialog(null, "The game is a tie");
//			}
			JOptionPane.showMessageDialog(null, "you win");
			
				score.pickWinner().addChips(pool);
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				frame.dispose();
	//			new HoldEm();
				
			}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Fold) {
			playArea.wipe();
			human.wipe();
			human.scoreWipe();
			computer.wipe();
			//Added code for multiplayer game
			computer2.wipe();
			computer3.wipe();
			computer.scoreWipe();
			computer2.scoreWipe();
			computer3.scoreWipe();
			
			JOptionPane.showMessageDialog(null, "Better luck next time");
			frame.dispose();
	//		new HoldEm();
		} else if (e.getSource() == Bet1) {
			/**
			 * Ante up to begin the hand
			 */
			JOptionPane.showMessageDialog(null, "Auto ante of $10");
			human.takeChips(10);
			computer.takeChips(10);
			//Added code for multiplayer game
			computer2.takeChips(10);
			computer3.takeChips(10);
			pool += 40;
			
			/**
			 * First round of betting
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
	//			new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0 || pBet > human.getChips()){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			while (pBet <= 0 || pBet > human.getChips()){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			if (pBet >= human.getChips())
				pBet = human.getChips();
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(computer.bet());
			computer2.takeChips(computer2.bet());
			computer3.takeChips(computer3.bet());
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Change bet buttons for next round of betting
			Bet1.setVisible(false);
			Bet2.setVisible(true);
			//remove the deck card for card one- replace with true value- new code
			TableCard1Text.setVisible(true);
			TableCard1.setVisible(true);
			H1.setVisible(false);
			//remove the deck card for card two- replace with true value- new code
			TableCard2Text.setVisible(true);
			TableCard2.setVisible(true);
			H2.setVisible(false);
			//remove the deck card for card three- replace with true value- new code
			TableCard3Text.setVisible(true);
			TableCard3.setVisible(true);
			H3.setVisible(false);
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			//First round of betting is over
			
		} else if (e.getSource() == Bet2) {
			/**
			 * Second round of betting 
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
//				new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(computer.bet());
			computer2.takeChips(computer2.bet());
			computer3.takeChips(computer3.bet());
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Change bet buttons for next round of betting
			Bet2.setVisible(false);
			Bet3.setVisible(true);
			//remove the deck card for card four- replace with true value- new code
			TableCard4Text.setVisible(true);
			TableCard4.setVisible(true);
			H4.setVisible(false);
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			//Second round of betting is over
			
		} else if (e.getSource() == Bet3) {
			/**
			 * Third round of betting 
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
		//		new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(pBet);
			computer2.takeChips(pBet);
			computer3.takeChips(pBet);
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Change bet buttons for next round of betting
			Bet3.setVisible(false);
			Bet4.setVisible(true);
			//remove the deck card for card five- replace with true value- new code
			TableCard5Text.setVisible(true);
			TableCard5.setVisible(true);
			H5.setVisible(false);
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			//Third round of betting is over
			
		} else if (e.getSource() == Bet4) {
			/**
			 * Last round of betting 
			 */
			bet = JOptionPane.showInputDialog(null, "Place your bet");
			if (bet.equalsIgnoreCase("fold"))
			{
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				//Added code for multiplayer game
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				
				JOptionPane.showMessageDialog(null, "Better luck next time");
				frame.dispose();
//				new HoldEm();
			}
			pBet = Integer.parseInt(bet);
			//Error handling to handle negative numbers or zero dollar bets
			while (pBet <= 0){
				JOptionPane.showMessageDialog(null, "Please enter a valid bet");
				bet = JOptionPane.showInputDialog(null, "Place your bet");
				pBet = Integer.parseInt(bet);
			}
			//All four players have the same bet amount
			human.takeChips(pBet);
			computer.takeChips(pBet);
			computer2.takeChips(pBet);
			computer3.takeChips(pBet);
			//Add to the pool
			pool += pBet * 4;
			//Set new amounts in the chip labels
			potChipNum.setText("$" + pool);
			compChipNum.setText("$" + computer.getChips());
			compChipNum2.setText("$" + computer2.getChips());
			compChipNum3.setText("$" + computer3.getChips());
			playerChipNum.setText("$" + human.getChips());
			//Disable last bet button; no more bets
			Bet4.setEnabled(false);
			
			humanMon = human.getChips();
			compMon = computer.getChips();
			
			/**
			 * Time to display opponents cards
			 */
			
			//Billy the Kids cards exposed
			AICard1Fliped.setVisible(false);
			AICard2Fliped.setVisible(false);
			AICard1Text.setVisible(true);
			AICard1.setVisible(true);
			AICard2Text.setVisible(true);
			AICard2.setVisible(true);
			
			//Doc Hollidays cards exposed
			AI2Card1Fliped.setVisible(false);
			AI2Card2Fliped.setVisible(false);
			AI2Card1Text.setVisible(true);
			AI2Card1.setVisible(true);
			AI2Card2Text.setVisible(true);
			AI2Card2.setVisible(true);
			
			//Mavericks cards exposed
			AI3Card1Fliped.setVisible(false);
			AI3Card2Fliped.setVisible(false);
			AI3Card1Text.setVisible(true);
			AI3Card1.setVisible(true);
			AI3Card2Text.setVisible(true);
			AI3Card2.setVisible(true);
			
			//Refresh GUI
			frame.pack();
			frame.setVisible(true);
			validate();
			
			/**
			 * Determine winner
			 * "Sets" class modified to determine winner
			 */
//			Sets chooser = new Sets(human.getHand(), computer.getHand(),
//					computer2.getHand(), computer2.getHand(), playArea.getInPlay());
			
//			int win = Score.playerWin(chooser.hplayer, chooser.cplayer,
//					chooser.cplayer2, chooser.cplayer3, chooser.hcards);
//			if (win == 0) {
//				JOptionPane.showMessageDialog(null, "You win");
//				human.addChips(pool); 
//				frame.dispose();
//				new HoldEm();
//				if (human.getChips() == 0)
//					JOptionPane.showMessageDialog(null, "you lose");
//			} else if (win == 1) {
//				JOptionPane.showMessageDialog(null, "You lose");
//				computer.addChips(pool);
//				frame.dispose();
//				new HoldEm();
//			} else {
//				JOptionPane.showMessageDialog(null, "The game is a tie");
//			}
				score.pickWinner().addChips(pool);
				playArea.wipe();
				human.wipe();
				human.scoreWipe();
				computer.wipe();
				computer2.wipe();
				computer3.wipe();
				computer.scoreWipe();
				computer2.scoreWipe();
				computer3.scoreWipe();
				frame.dispose();
	//			new HoldEm();
				
			
		}
	}
}
