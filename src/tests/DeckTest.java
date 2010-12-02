package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Deck;

public class DeckTest {

	@Test
	public void testDeck() {
		Deck testDeck = new Deck();
		Card testCard = new Card("Spades", "2", 1);
		assertEquals("Testing the deck", testCard.toString(), testDeck.draw().toString());
	}

	@Test
	public void testMakeDeck() {
		Deck testDeck = new Deck();
		Card testCard = new Card("Spades", "2", 1);
		assertEquals("Testing the deck", testCard.toString(), testDeck.draw().toString());
	}

	@Test
	public void testDraw() {
		Deck testDeck = new Deck();
		Card testCard = new Card("Spades", "2", 1);
		assertEquals("Testing the deck", testCard.toString(), testDeck.draw().toString());
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
