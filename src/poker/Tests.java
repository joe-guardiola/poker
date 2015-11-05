package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
	@Test 
	public void testHandSort() {
		try{
			ArrayList <Card> testHand = new ArrayList <Card>();
			testHand.add(new Card(2,"Hearts"));
			testHand.add(new Card(3,"Hearts"));
			testHand.add(new Card(4,"Hearts"));
			testHand.add(new Card(5,"Hearts"));
			testHand.add(new Card(6,"Hearts"));
			Poker p = new Poker(5);
			p.sortHand();
			for(int i = 0; i < p.getPokerHand().size()-1; i++) {
				if(p.getPokerHand().get(i).getValue() >= p.getPokerHand().get(i+1).getValue()) {
					fail();
				}
			}
		} catch(CardException e) {
			e.printStackTrace();
		} catch(HandSizeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetStraightFlush() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(2,"Hearts"));
			testHand.add(new Card(3,"Hearts"));
			testHand.add(new Card(4,"Hearts"));
			testHand.add(new Card(5,"Hearts"));
			testHand.add(new Card(6,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(5, p.getStraightFlush().size());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsRoyalFlush() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(14,"Hearts"));
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(12,"Hearts"));
			testHand.add(new Card(11,"Hearts"));
			testHand.add(new Card(10,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isRoyalFlush());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsStraightFlush() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(12,"Hearts"));
			testHand.add(new Card(11,"Hearts"));
			testHand.add(new Card(10,"Hearts"));
			testHand.add(new Card(9,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isStraightFlush());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsFourOfAKind() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(12,"Spades"));
			testHand.add(new Card(11,"Hearts"));
			testHand.add(new Card(10,"Hearts"));
			testHand.add(new Card(9,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(false, p.isFourOfAKind());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsFullHouse() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(13,"Spades"));
			testHand.add(new Card(13,"Diamonds"));
			testHand.add(new Card(10,"Hearts"));
			testHand.add(new Card(10,"Spades"));
			testHand.add(new Card(2,"Hearts"));
			testHand.add(new Card(3,"Clubs"));
			Poker p = new Poker(7);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isFullHouse());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsFlush() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(8,"Hearts"));
			testHand.add(new Card(10,"Hearts"));
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(4,"Hearts"));
			testHand.add(new Card(2,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isFlush());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsStraight() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(2,"Hearts"));
			testHand.add(new Card(3,"Spades"));
			testHand.add(new Card(4,"Clubs"));
			testHand.add(new Card(5,"Hearts"));
			testHand.add(new Card(6,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isStraight());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsThreeOfAKind() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(13,"Spades"));
			testHand.add(new Card(13,"Clubs"));
			testHand.add(new Card(12,"Diamonds"));
			testHand.add(new Card(9,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isThreeOfAKind());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsTwoPair() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(13,"Spades"));
			testHand.add(new Card(12,"Clubs"));
			testHand.add(new Card(12,"Diamonds"));
			testHand.add(new Card(9,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isTwoPair());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsPair() {
		ArrayList <Card> testHand = new ArrayList <Card>();
		try {
			testHand.add(new Card(13,"Hearts"));
			testHand.add(new Card(13,"Spades"));
			testHand.add(new Card(11,"Clubs"));
			testHand.add(new Card(12,"Diamonds"));
			testHand.add(new Card(9,"Hearts"));
			Poker p = new Poker(5);
			p.setPokerHand(testHand);
			p.sortHand();
			assertEquals(true, p.isPair());
			
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HandSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
