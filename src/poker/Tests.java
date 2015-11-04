package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	@Test
	public void testCardConstructor() {
		Card c;
		try {
			c = new Card(4, "Hearts");
			assertEquals(4, c.getValue());
			assertEquals("Hearts", c.getSuit());
		} catch (CardException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBadCardConstructor() {
		try { 
			Card c = new Card(-1,"Bad");
			fail();
		} catch(CardException e) {
			System.out.println("This is expected.");
		}
	}
	@Test
	public void testDeckConstructor() {
		try {
			Deck d = new Deck();
			assertEquals(52, d.getDeckSize());
		} catch (CardException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testShuffle() {
		try {
			Deck d = new Deck();
			d.shuffle();
			assertEquals(52, d.getDeckSize());
		} catch(CardException e) {
			e.printStackTrace();
		}
	}
	
//	@Test 
//	public void testHandSort() {
//		try{
//			Poker p = new Poker(5);
//		} catch(CardException e) {
//			e.printStackTrace();
//		} catch(HandSizeException e) {
//			e.printStackTrace();
//		}
//	}
}
