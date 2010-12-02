package poker;


/**
 * This class handles the creation and usage of hands.  The Player class calls this class from the
 * scoring class to determine the winner of the game.  The Computer class calls this class to control
 * the betting based on what poker hand the computer currently has. 
 * @author Steven Honda
 */  
public class Hand {
	public Card[] hand;
	protected int handSize = 0;
	/**
	 * creates the ArrayList of card objects that make up a hand. 
	 * @author Steven Honda
	 */
	public Hand(int maxHandSize){
		hand = new Card[maxHandSize];
		for(int i = 0; i < maxHandSize; i++)
			hand[i] = null;
		handSize = 0;
	}
	/**
	 * This method adds a new card to the uninitialized array of card objects that make up a hand.
	 * @param newCard
	 * @return int
	 * @author Steven Honda
	 */
	public int addCard(Card newCard){
		hand[handSize] = newCard;
		System.out.println("Added:" + hand[handSize].toString()+ "to hand at index " + handSize);
		handSize++;
		return sortHand();
	}
	/**
	 * This method will sort the cards in the hand to help determine scoring.
	 * @return int
	 * @author Steven Honda
	 */
	public int sortHand() {
		int out, in;
		System.out.println("Sorting " + handSize + "cards:\n" + this.toString());
		for (out = handSize - 1; out >= 1; out--) {
			for (in = 0; in < out; in++)
				if (hand[in].getValue() < hand[in + 1].getValue())
					swap(in, in + 1);
		}
		System.out.println("Sorted to:\n" + this.toString());
		return handSize;
	}
	/**
	 * This method swaps two cards in the ArrayList to sort the array.
	 * @param Card one
	 * @param Card two
	 * @author Steven Honda
	 */
	public void swap(int one, int two){
		Card temp = hand[one];
		hand[one] = hand[two];
		hand[two] = temp;
	}
	/**
	 * This class will check for various poker hands. It will then set a numerical score to the hand
	 * and return this value to be used to determine winner and determine AI betting.
	 * @return int score
	 * @author Steven Honda
	 */
	public int getScore() {
		boolean isStraight = false, isFlush = false, isStraightFlush = false;
		String straightFlushSuit = "";
		int score = 0, kind1 = 0, kind2 = -1, kind3 = -1, straight = 0, straightFlush = 0, flushD = 0, flushH = 0, flushC = 0, flushS = 0, straightHigh = 0, possibleStraightHigh = 0;
		int thisCardV = 0, nextCardV = 0;
		if (handSize == 0) {
			score = 0;
		} 
		else {
			for (int i = 0; i < handSize; i++) {
				if (hand[i].getSuit().equalsIgnoreCase("Clubs")) {
					flushC++;
					if (flushC > 4)
						isFlush = true;
				} else if (hand[i].getSuit().equalsIgnoreCase("Diamonds")) {
					flushD++;
					if (flushD > 4)
						isFlush = true;
				} else if (hand[i].getSuit().equalsIgnoreCase("Hearts")) {
					flushH++;
					if (flushH > 4)
						isFlush = true;
				} else if (hand[i].getSuit().equalsIgnoreCase("Spades")) {
					flushS++;
					if (flushS > 4)
						isFlush = true;
				}
				thisCardV = hand[i].getValue();
				if(i == handSize - 1)
					nextCardV = 0;
				else
					nextCardV = hand[i + 1].getValue();

				if(i == handSize - 1)
					score = 0;	// this is to prevent checking for straight and flushes past the end of the array
				else if (thisCardV - nextCardV == 1) {//(hand[i + 1].getValue() - hand[i].getValue() == 1) {
					if (kind1 > 0 && kind2 == -1)
						kind2 = 0;
					else if (kind2 > 0 && kind3 == -1) {
						kind3 = 0;
					}
					straight++;
					if (straight > 3) {
						isStraight = true;
						if(straightFlushSuit.equalsIgnoreCase(hand[i].getSuit())){
							straightFlush++;
							if(straightFlush > 3){
								isStraightFlush = true;
							}
						}
						straightHigh = possibleStraightHigh;
					}
					else if(straight == 1){
						possibleStraightHigh = hand[i].getValue();
						straightFlushSuit = hand[i].getSuit();
						straightFlush = 1;
					}
					else if(straightFlushSuit.equalsIgnoreCase(hand[i].getSuit())){
						straightFlush++;
						if(straightFlush > 3){
							isStraightFlush = true;
						}
					}
				} else if (thisCardV - nextCardV > 1) {//(hand[i + 1].getValue() - hand[i].getValue() > 1) {
					if (kind1 > 0 && kind2 == -1)
						kind2 = 0;
					else if (kind2 > 0 && kind3 == -1) {
						kind3 = 0;
					}
					straight = 0;
				} else if (thisCardV == nextCardV) {//(hand[i + 1].getValue() == hand[i].getValue()) {
					if (kind2 == -1)
						kind1++;
					else if (kind3 == -1)
						kind2++;
					else
						kind3++;
				}
			}
			// check High card and add high card
			score = hand[0].getValue();
			//5 of a kind?  let me see your sleeves.
			if(kind1 > 3 || kind2 > 3 || kind3 > 3)
				score = -10000 - score;
			// check For Royal Flush and add high card
			if (isStraightFlush && straightHigh == 13)
				score = 126 + score;
			// check for Straight flush and add high card
			else if (isStraightFlush)
				score = 112 + score;
			// check for Four of a Kind and add high card
			else if (kind1 >= 3 || kind2 >= 3 || kind3 >= 3)
				score = 98 + score;
			// check for Full House and add high card
			else if ((kind1 > 1 || kind2 > 1 || kind3 > 1) && (kind2 > 0))
				score = 84 + score;
			// check for Flush and add high card
			else if (isFlush)
				score = 70 + score;
			// check for Straight and add high card
			else if (isStraight)
				score = 56 + score;
			// check for Three of a kind and add high card
			else if (kind1 > 1 || kind2 > 1 || kind3 > 1)
				score = 42 + score;
			// check for two pair and add high card
			else if (kind2 > 0)
				score = 28 + score;
			// check for single pair and add high card
			else if (kind1 > 0)
				score = 14 + score;
		}
		return score;
	}
	/**
	 * This method is used to determine the winner when there is a tie.
	 * @return double
	 * @author Steven Honda
	 */
	public double tieBreaker() {
		double tiebreaker = (double) getScore();
		double factor = 14.0;
		if (handSize > 1) {
			for (int i = 1; i < handSize; i++) {
				tiebreaker += ((double) hand[i].getValue()) / factor;
				factor *= 14;
			}
		}
		return tiebreaker;
	}
	@Override
	public String toString(){
		String handDisplay = "";
		for(int i = 0; i < handSize; i++){
			handDisplay += hand[i].toString() + "\n";
		}
		handDisplay += "\n" + getScore() + "\n";
		return handDisplay;
	}
	/**
	 * This method wipes each players hand
	 */
	public void wipe()
	{
		for (int x = 0; x < 2; x++)
		{
			hand[x] = null;
		}
		handSize = 0;
	}
}
