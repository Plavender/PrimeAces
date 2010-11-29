package poker;
import java.util.Random;

/**
 * This class will control the computer players betting.
 * @author Ryuu
 */
public class Computer extends Player {
	
	//standard constructor
	public Computer(int m) {
		super(m);
	}
	/**
	 * This method will determine the amount of money the computer will bet with a given hand. 
	 * @return int bet
	 */
	public int bet(){
		int bet = 0;
		int betPercent = 0;
		int randBet = 0;
		final int minBet = 5; //5 is a placeholder for the minimum bet
		int score = this.hand.getScore();
		if(score <= 13)
			betPercent = 5 + score / 2;
		else if(score <= 27)
			betPercent = 10 + score / 3;
		else if (score <= 41)
			betPercent = 15 + score / 4;
		else if (score <= 55)
			betPercent = 20 + score / 5;
		else if (score <= 69)
			betPercent = 25 + score / 6;
		else if (score <= 83)
			betPercent = 30 + score / 7;
		else if (score <= 97)
			betPercent = 35 + score / 8;
		else if (score <= 111)
			betPercent = 40 + score / 9;
		else if (score <= 125)
			betPercent = 45 + score / 10;
		else
			betPercent = 50 + score / 11;
		Random rand = new Random((System.nanoTime() % 2147483647));
		randBet = (int) ((rand.nextFloat() * betPercent) / 2);
		if(randBet < 5)
			randBet = (int) (rand.nextFloat() * 10);
		betPercent += randBet;// bluffing algorithm  
		if(minBet > ((betPercent * chips) / 100))
			bet = 0;//fold, you guys need to let me know what to put here.
		bet = (betPercent * chips) / 100;
		return bet;
	}
	

}
