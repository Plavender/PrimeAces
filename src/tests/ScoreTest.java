package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;
import poker.Player;
import poker.Score;


public class ScoreTest {

	
	public Hand testCase;
	public Hand tester;
	public Card card1p1;
	public Card card2p1;
	public Card card3p1;
	public Card card4p1;
	public Card card5p1;
	public Card card6p1;
	public Card card7p1;
	
	@Before
	public void setUp(){
		testCase = new Hand(7);
		card1p1 = new Card("Heart", "Queen", 11);
		card2p1 = new Card("Heart", "Jack", 10);
		card3p1 = new Card("Heart", "Ten", 9);
		card4p1 = new Card("Club", "Six", 5);
		card5p1 = new Card("Heart", "King", 12);
		card6p1 = new Card("Heart", "Nine", 8);
		card7p1 = new Card("Heart", "Ace", 13);
	}
	@Test
	public void testPickWinner() {
		Player player1 = new Player(50, "Cthulhu");
		Player player2 = new Player(50, "Azathoth");
		Player player3 = new Player(50, "Qwjibo");
		Player player4 = new Player(50, "Ummmmmmm");
		Card card1p2 = new Card("Diamond", "Seven", 6);
		Card card2p2 = new Card("Heart", "Nine", 8);
		Card card3p2 = new Card("Diamond", "Queen", 11);
		Card card4p2 = new Card("Club", "Ace", 13);
		Card card5p2 = new Card("Heart", "Three", 2);
		Card card6p2 = new Card("Diamond", "Ten", 9);
		Card card7p2 = new Card("Spade", "Queen", 11);
		Card card1p3 = new Card("Heart", "Four", 3);
		Card card2p3 = new Card("Heart", "Six", 5);
		Card card3p3 = new Card("Diamond", "Jack", 10);
		Card card4p3 = new Card("Club", "Five", 4);
		Card card5p3 = new Card("Heart", "Three", 2);
		Card card6p3 = new Card("Heart", "Ten", 9);
		Card card7p3 = new Card("Spade", "Seven", 6);
		Card card1p4 = new Card("Club", "Two", 1);
		Card card2p4 = new Card("Diamond", "Six", 5);
		Card card3p4 = new Card("Spade", "Jack", 10);
		Card card4p4 = new Card("Heart", "Three", 2);
		Card card5p4 = new Card("Spade", "Three", 2);
		Card card6p4 = new Card("Heart", "Ten", 9);
		Card card7p4 = new Card("Spade", "Seven", 6);
		player2.addCard(card1p1);
		player2.addCard(card2p1);
		player2.addCard(card3p1);
		player2.addCard(card4p1);
		player2.addCard(card5p1);
		player2.addCard(card6p1);
		player2.addCard(card7p1);
		player1.addCard(card1p2);
		player1.addCard(card2p2);
		player1.addCard(card3p2);
		player1.addCard(card4p2);
		player1.addCard(card5p2);
		player1.addCard(card6p2);
		player1.addCard(card7p2);
		player3.addCard(card1p3);
		player3.addCard(card2p3);
		player3.addCard(card3p3);
		player3.addCard(card4p3);
		player3.addCard(card5p3);
		player3.addCard(card6p3);
		player3.addCard(card7p3);
		player4.addCard(card1p4);
		player4.addCard(card2p4);
		player4.addCard(card3p4);
		player4.addCard(card4p4);
		player4.addCard(card5p4);
		player4.addCard(card6p4);
		player4.addCard(card7p4);
		assertSame("Winner should be player 2 with " + "\n" + player2.hand.toString() + "\nWinner was actually " + Score.pickWinner().hand.toString(), player2, Score.pickWinner());
	}

	@Test
	public void testSwap() {
		assertEquals("Adding first card", 1, testCase.addCard(card1p1));
		assertEquals("Adding Second card", 2, testCase.addCard(card2p1));
		assertEquals("Adding Third card", 3, testCase.addCard(card3p1));
		assertEquals("Adding Forth card", 4, testCase.addCard(card4p1));
		assertEquals("Adding Fifth card", 5, testCase.addCard(card5p1));
		assertEquals("Adding Sixth card", 6, testCase.addCard(card6p1));
		assertEquals("Adding Seventh card", 7, testCase.addCard(card7p1));
	}
}
