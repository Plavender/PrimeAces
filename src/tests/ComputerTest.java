package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Computer;
import poker.Player;


public class ComputerTest {

	public Card card1;
	public Card card2;
	public Card card3;
	public Card card4;
	public Card card5;
	public Card card6;
	public Card card7;
	public Computer testCase;
	
	@Test
	public void testComputer() {
		Computer testPlayer = new Computer(7);
		Computer testPlayer2 = new Computer(6);
		Computer testPlayer3 = new Computer(8);
		assertEquals("checking chips of player 1", 7, testPlayer.getChips());
		assertEquals("Checking chips of player 2", 6, testPlayer2.getChips());
		assertEquals("Checking chips of player 3", 8, testPlayer3.getChips());
		assertSame("Added player 1 to array", Player.players[0], testPlayer);
		assertSame("Added player 2 to array", Player.players[1], testPlayer2);
		assertSame("Added player 3 to array", Player.players[2], testPlayer3);
	}

	@Test
	public void testBet() {
		card1 = new Card("Heart", "Queen", 11);
		card2 = new Card("Heart", "Jack", 10);
		card3 = new Card("Heart", "Ten", 9);
		card4 = new Card("Club", "Six", 5);
		card5 = new Card("Heart", "King", 12);
		card6 = new Card("Heart", "Nine", 8);
		card7 = new Card("Heart", "Ace", 13);
		testCase = new Computer(100);
		testCase.addCard(card1);
		testCase.addCard(card2);
		testCase.addCard(card3);
		testCase.addCard(card4);
		testCase.addCard(card5);
		testCase.addCard(card6);
		testCase.addCard(card7);
		assertEquals("This should give the range of betting", 77 ,testCase.bet(), 16);
	}

}
