package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class CardTest {

	@Test
	public void testCard() {
		Card testCard = new Card("Heart", "Queen", 12);
		assertEquals("Checking the cards value", 12, testCard.getValue());
	}

	@Test
	public void testGetSuit() {
		Card testCard = new Card("Heart", "Queen", 12);
		assertEquals("Checking the cards suit", "Heart", testCard.getSuit());
	}

	@Test
	public void testGetName() {
		Card testCard = new Card("Heart", "Queen", 12);
		assertEquals("Checking the cards suit", "Queen", testCard.getName());
	}

	@Test
	public void testGetValue() {
		Card testCard = new Card("Heart", "Queen", 12);
		assertEquals("Checking the cards value", 12, testCard.getValue());
	}

	@Test
	public void testToString() {
		Card testCard = new Card("Heart", "Queen", 12);
		assertEquals("Checking the cards toString", "Heart Queen[12]", testCard.toString());
	}

}
