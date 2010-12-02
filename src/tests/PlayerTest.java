package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;
import poker.Player;


public class PlayerTest {

	public Hand testCase;
	public Hand tester;
	public Card card1;
	public Card card2;
	public Card card3;
	public Card card4;
	public Card card5;
	public Card card6;
	public Card card7;
	
	@Before
	public void setUp(){
		testCase = new Hand(7);
		card1 = new Card("Heart", "Queen", 11);
		card2 = new Card("Heart", "Jack", 10);
		card3 = new Card("Heart", "Ten", 9);
		card4 = new Card("Club", "Six", 5);
		card5 = new Card("Heart", "King", 12);
		card6 = new Card("Heart", "Nine", 8);
		card7 = new Card("Heart", "Ace", 13);
	}
	@Test
	public void testPlayer() {
		Player testPlayer = new Player(7, "Fred");
		Player testPlayer2 = new Player(6, "Azathoth");
		Player testPlayer3 = new Player(8, "WHY ME");
		assertEquals("checking chips of player 1", 7, testPlayer.getChips());
		assertEquals("Checking chips of player 2", 6, testPlayer2.getChips());
		assertEquals("Checking chips of player 3", 8, testPlayer3.getChips());
	}

	@Test
	public void testGetChips() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddChips() {
		fail("Not yet implemented");
	}

	@Test
	public void testTakeChips() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetScore() {
		testCase.addCard(card1);
		testCase.addCard(card2);
		testCase.addCard(card3);
		testCase.addCard(card4);
		testCase.addCard(card5);
		testCase.addCard(card6);
		testCase.addCard(card7);
		assertEquals("Hand should be a Royal Flush", 139, testCase.getScore());
	}

	@Test
	public void testTiebreaker() {
		testCase.addCard(card1);
		testCase.addCard(card2);
		testCase.addCard(card3);
		testCase.addCard(card4);
		testCase.addCard(card5);
		testCase.addCard(card6);
		testCase.addCard(card7);
		assertEquals(139.0 + (12.0 / 14.0) + (11.0 / (14.0 * 14.0)) + (10.0 / (14.0 * 14.0 * 14.0)) + (9.0 / (14.0 * 14.0 * 14.0 * 14.0)) + (8.0 / (14.0 * 14.0 * 14.0 * 14.0 * 14.0)) + (5.0 / (14.0 * 14.0 * 14.0 * 14.0 * 14.0 * 14.0)),testCase.tieBreaker(), 0.5);
	}
	
	@Test
	public void testAddCard(){
		assertEquals("Adding first card", 1, testCase.addCard(card1));
		assertEquals("Adding Second card", 2, testCase.addCard(card2));
		assertEquals("Adding Third card", 3, testCase.addCard(card3));
		assertEquals("Adding Forth card", 4, testCase.addCard(card4));
		assertEquals("Adding Fifth card", 5, testCase.addCard(card5));
		assertEquals("Adding Sixth card", 6, testCase.addCard(card6));
		assertEquals("Adding Seventh card", 7, testCase.addCard(card7));
	}
}
