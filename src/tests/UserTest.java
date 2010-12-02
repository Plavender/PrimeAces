package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.User;

public class UserTest {

	@Test
	public void testUser() {
		User testPlayer = new User(7, "Bob", 0, 0);
		assertEquals("Testing the name", "Bob", testPlayer.toString());
	}

	@Test
	public void testToString() {
		User testPlayer = new User(7, "Bob", 0, 0);
		assertEquals("Testing the name", "Bob", testPlayer.toString());
	}

}
