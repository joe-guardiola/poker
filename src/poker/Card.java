package poker;

public class Card {
	private String suit;  
	private int value;
	
	public Card(int v, String s) throws CardException{
		setValue(v);
		setSuit(s);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) throws CardException{
		if(value >= 2 && value <= 14) {
			this.value = value;
		} else {
			throw new CardException();
		}
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) throws CardException {
		if(suit == "Hearts" || suit == "Spades" || suit == "Diamonds" || suit == "Clubs") {
			this.suit = suit;
		} else {
			throw new CardException();
		}
	}
	
	public void print()
	{
		if(getValue() <= 10)
		{
			System.out.print(getValue());
		}
		else if(getValue() == 11)
		{
			System.out.print("J");
		}
		else if(getValue() == 12)
		{
			System.out.print("Q");
		}
		else if(getValue() == 13)
		{
			System.out.print("K");
		}
		else if(getValue() == 14)
		{
			System.out.print("A");
		}

		System.out.print(" of ");
		System.out.print( getSuit());
	}
}
