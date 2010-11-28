import java.util.ArrayList;

/**
 * This class handles the creation and usage of hands.  The Player class calls this class from the
 * scoring class to determine the winner of the game.  The Computer class calls this class to control
 * the betting based on what poker hand the computer currently has. 
 * @author Steven Honda
 */  
public class Hand {
	ArrayList<Card> hand;
	/**
	 * creates the ArrayList of card objects that make up a hand. 
	 * @author Steven Honda
	 */
	public Hand(){
		hand = new ArrayList<Card>();
	}
	/**
	 * This method adds a new card to the uninitialized array of card objects that make up a hand.
	 * @param newCard
	 * @return int
	 * @author Steven Honda
	 */
	public int addCard(Card newCard){
		hand.add(newCard);
		return sortHand();
	}
	/**
	 * This method will sort the cards in the hand to help determine scoring.
	 * @return int
	 * @author Steven Honda
	 */
	public int sortHand(){
		int out, in;
		for(out = hand.length - 1; out > 1; out--){
			for(in = 0; in < out; in++)
				if(hand[in].getValue() < hand[in + 1].getValue())
					swap(in, in + 1);
		}
		return hand.length;
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
	public int getScore(){
		boolean isStraight = false, isFlush = false;
		int score = 0, kind1 = 0, kind2 = -1, kind3 = -1, straight = 0, flushD = 0, flushH = 0, flushC = 0, flushS = 0, straightHigh = 0;
		for(int i = 0; i < hand.length; i++){
			if(hand[i].getSuit().equalsIgnoreCase("Club")){
				flushC++;
				if(flushC++ > 4)
					isFlush = true;
			}
			else if(hand[i].getSuit().equalsIgnoreCase("Diamond")){
				flushD++;
				if(flushD++ > 4)
					isFlush = true;
			}	
			else if(hand[i].getSuit().equalsIgnoreCase("Heart")){
				flushH++;
				if(flushH++ > 4)
					isFlush = true;
			}
			else if(hand[i].getSuit().equalsIgnoreCase("Spade")){
				flushS++;
				if(flushS++ > 4)
					isFlush = true;
			}
			if(hand[i + 1].getValue() - hand[i].getValue() == 1){
				if(kind1 > 0 && kind2 == -1)
					kind2 = 0;
				else if(kind2 > 0 && kind3 == -1){
					kind3 = 0;
				}
				straight++;
				if(straight > 4){
					isStraight = true;
					straightHigh = hand[i].getValue();
				}
			}
			else if(hand[i + 1].getValue() - hand[i].getValue() > 1)
				if(kind1 > 0 && kind2 == -1)
					kind2 = 0;
				else if(kind2 > 0 && kind3 == -1){
					kind3 = 0;
				}
				straight = 0;
			else if(hand[i + 1].getValue() == hand[i].getValue()){
				if(kind2 == -1)
					kind1++;
				else if (kind3 == -1)
					kind2++;
				else
					kind3++;
			}
		}
			//check High card and add high card
			score = hand[hand.getlength - 1].getValue();
			//check For Royal Flush and add high card
			if(isStraight && isFlush && straightHigh == 13)
				score = 126 + score;
			//check for Straight flush and add high card
			else if(isStraight && isFlush)
				score = 112 + score;
			//check for Four of a Kind and add high card
			else if(kind1 >= 3 || kind2 >=3 || kind3 >= 3)
				score = 98 + score;
			//check for Full House and add high card
			else if((kind1 > 1 || kind2 > 1 || kind3 > 1) && (kind2 > 0))
				score = 84 + score;
			//check for Flush and add high card
			else if(isFlush)
				score = 70 + score;
			//check for Straight and add high card
			else if(isStraight)
				score = 56 + score;
			//check for Three of a kind and add high card
			else if(kind1 > 1 || kind2 > 1 || kind3 > 1)
				score = 42 + score;
			//check for two pair and add high card
			else if(kind2 > 0)
				score = 28 + score;
			//check for single pair and add high card
			else if(kind1 > 0)
				score = 14 + score;
			return score;
	}
	/**
	 * This method is used to determine the winner when there is a tie.
	 * @return double
	 * @author Steven Honda
	 */
	public double tiebreaker(){
		double tiebreaker = (double)getScore();
		double factor = 14.0;
		for(int i = hand.getlength - 2; i >= 0; i--){
			tiebreaker += ((double) hand[i].getValue()) / factor;
			factor *= 14;
		}
		return tiebreaker;
	}
}
