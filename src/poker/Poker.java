package poker;

import java.util.ArrayList;

public class Poker {
	private double numberOfHandsToPlay;
	private ArrayList <Card> pokerHand = new ArrayList <Card>();
	private int fiveOrSevenCard = -1;
	private int royalFlushCounter = 0;
	private int straightFlushCounter = 0;
	private int fourOfAKindCounter = 0;
	private int fullHouseCounter = 0;
	private int flushCounter = 0;
	private int straightCounter = 0;
	private int threeOfAKindCounter = 0;
	private int twoPairCounter = 0;
	private int pairCounter = 0;
	private int highCardCounter = 0;


	//make test
	public Poker(int c) throws HandSizeException
	{
		if(c != 7 && c != 5)
		{
			throw new HandSizeException();
		}
		else
		{
			fiveOrSevenCard = c;
		}
	}
	
	public void sortHand() throws CardException
	{
		for(int j = 0; j < (pokerHand.size() - 1); j++)
		{
			for(int i = 0; i < (pokerHand.size() - 1); i++)
			{
				if(pokerHand.get(i).getValue() > pokerHand.get(i+1).getValue())
				{
					Card temp = new Card(pokerHand.get(i+1).getValue(), pokerHand.get(i+1).getSuit());
					pokerHand.get(i+1).setValue(pokerHand.get(i).getValue());
					pokerHand.get(i+1).setSuit(pokerHand.get(i).getSuit());
					pokerHand.get(i).setValue(temp.getValue());
					pokerHand.get(i).setSuit(temp.getSuit());
				}
			}
		}
	}
	
	public  ArrayList <Card> getStraightFlush()
	{
		int spades = 0;
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;
		ArrayList <Card> straightCards = new ArrayList <Card>();
		int numStraightCards = 0;
		
		straightCards.add(pokerHand.get(0));

		for(int i = 0; i < pokerHand.size() - 1; i++)
		{
			//checks if the cards are in sequential order
			if((pokerHand.get(i+1).getValue() - pokerHand.get(i).getValue()) == 1)
			{
				straightCards.add(pokerHand.get(i+1));
				numStraightCards++;

			}
			//checks if the two cards are equal
			else if((pokerHand.get(i+1).getValue() - pokerHand.get(i).getValue()) == 0)
			{
				numStraightCards = numStraightCards + 0;
			}
			//means that the two cards could not be a part of a straight. 
			else
			{
				numStraightCards = 0;
				straightCards.clear();
				straightCards.add(pokerHand.get(i));
			}
		}


		if(straightCards.size() >= 5)
		{
			for(int i = 0; i < straightCards.size(); i++)
			{
				if(straightCards.get(i).getSuit() == "Spades")
				{
					spades++;
				}
				if(straightCards.get(i).getSuit() == "Clubs")
				{
					clubs++;
				}
				if(straightCards.get(i).getSuit() == "Hearts")
				{
					hearts++;
				}
				if(straightCards.get(i).getSuit() == "Diamonds")
				{
					diamonds++;
				}
			}
			if(!(spades >= 5 || clubs >= 5 || hearts >= 5 || diamonds >= 5))
			{
				straightCards.clear();
			}

		}
		return straightCards;
	}
	public boolean isRoyalFlush()
	{
		boolean retVal = false;
		ArrayList < Card > sf = getStraightFlush();
		if(sf.size() >= 5 && sf.get(sf.size() - 1).getValue() == 14)
		{
			retVal = true;
		}
		return retVal;
	}
	public boolean isStraightFlush()
	{
		boolean retVal = false;
		ArrayList < Card > sf = getStraightFlush();
		if(sf.size() >= 5)
		{
			retVal = true;
		}
		return retVal;
	}
	public boolean isFourOfAKind()
	{
		//counter of values
		int numOfValue = 0;
		for(int i = 0; i < pokerHand.size() - 1; i++)
		{
			//if the value ever hits three there are 4 of a kind and will break the loop
			if(numOfValue == 3)
			{
				break;
			}
			if(pokerHand.get(i).getValue() == pokerHand.get(i+1).getValue())
			{
				numOfValue++;
			}
			else
			{
				numOfValue = 0;
			}
		}
		return numOfValue == 3;
	}
	public boolean isFullHouse()
	{
		//counter of values
		int numPairs = 0;
		boolean retVal = false;
		for(int i = 0; i < pokerHand.size() - 2; i++)
		{
			//if there is a three of a kind it will be found
			if(pokerHand.get(i).getValue() == pokerHand.get(i+1).getValue() && pokerHand.get(i+1).getValue() == pokerHand.get(i + 2).getValue())
			{
				for(int j = 0; j < pokerHand.size() - 1; j++)
				{
					if(pokerHand.get(j).getValue() == pokerHand.get(j+1).getValue())
					{
						numPairs++;
					}
				}
				if(numPairs >=3)
				{
					retVal = true;
				}
			}
		}
		return retVal;
	}
	public boolean isFlush()
	{
		//counters
		int spades = 0;
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;
		for(int i = 0; i < pokerHand.size(); i++)
		{
			if(pokerHand.get(i).getSuit() == "Spades")
			{
				spades++;
			}
			if(pokerHand.get(i).getSuit() == "Clubs")
			{
				clubs++;
			}
			if(pokerHand.get(i).getSuit() == "Hearts")
			{
				hearts++;
			}
			if(pokerHand.get(i).getSuit() == "Diamonds")
			{
				diamonds++;
			}
		}
		return spades >= 5 || clubs >= 5 || hearts >= 5 || diamonds >= 5;
	}
	public boolean isStraight()
	{
		//creates a vector that will store the possible straight or any cards that are in sequencial order
		int straightCards = 0;
		for (int i = 0; i < pokerHand.size() - 1; i++)
		{
			//checks if the cards are in sequential order
			if((pokerHand.get(i+1).getValue() - pokerHand.get(i).getValue()) == 1)
			{
				straightCards++;
			}
			//checks if the two cards are equal
			else if((pokerHand.get(i+1).getValue() - pokerHand.get(i).getValue()) == 0)
			{
				straightCards = straightCards  + 0;
			}
			//means that the two cards could not be a part of a straight. 
			else
			{
				straightCards = 0;
			}
			if(straightCards == 4)
			{
				break;
			}

		}
		return straightCards >= 4; 

	}
	public boolean isThreeOfAKind()
	{
		//counter of values
		int numOfValue = 0;
		for(int i = 0; i < pokerHand.size() - 1; i++)
		{
			//if the value ever hits three there are 4 of a kind and will break the loop
			if(numOfValue == 2)
			{
				break;
			}
			if(pokerHand.get(i).getValue() == pokerHand.get(i+1).getValue())
			{
				numOfValue++;
			}
			else
			{
				numOfValue = 0;
			}
		}
		return numOfValue == 2;
	}
	public boolean isTwoPair()
	{
		int numOfValue = 0;
		for(int i = 0; i < pokerHand.size() - 1; i++)
		{
			if(numOfValue == 2)
			{
				break;
			}
			if(pokerHand.get(i).getValue() == pokerHand.get(i+1).getValue())
			{
				numOfValue++;
			}
		}
		return numOfValue == 2;
	}
	public boolean isPair()
	{
		//counter of values
		int numOfValue = 0;
		for(int i = 0; i < pokerHand.size() - 1; i++)
		{
			//if the value ever hits three there are 4 of a kind and will break the loop
			if(numOfValue == 1)
			{
				break;
			}
			if(pokerHand.get(i).getValue() == pokerHand.get(i+1).getValue())
			{
				numOfValue++;
			}
			else
			{
				numOfValue = 0;
			}
		}
		return numOfValue == 1;
	}

	public void playAndDisplay() throws CardException //Poker& p????
	{
		for(int i = 0; i < getNumberOfHandsToPlay(); i++)
		{
			
			Deck theDeck = new Deck();
			theDeck.shuffle();
			theDeck.dealCards(pokerHand, fiveOrSevenCard);
			sortHand();
			if(isRoyalFlush())
			{
				royalFlushCounter++;
			}
			else if (isStraightFlush())
			{
				straightFlushCounter++;	
			}
			else if (isFourOfAKind())
			{
				fourOfAKindCounter++;
			}
			else if (isFullHouse())
			{
				fullHouseCounter++;
			}
			else if (isFlush())
			{
				flushCounter++;
			}

			else if (isStraight())
			{
				straightCounter++;	
			}
			else if (isThreeOfAKind())
			{
				threeOfAKindCounter++;	
			}
			else if (isTwoPair())
			{
				twoPairCounter++;	
			}
			else if (isPair())
			{
				pairCounter++;
			}
			else
			{
				highCardCounter++;
			}
			//empty out the  collection of cards for the next hand
			pokerHand.clear();
		}
		System.out.println("There were " + (royalFlushCounter/getNumberOfHandsToPlay()) * 100 + "% where a Royal Flush was the best possible hand." );
		System.out.println("There were " + (straightFlushCounter/getNumberOfHandsToPlay()) * 100 + "% where a Straight Flush was the best possible hand." );
		System.out.println("There were " + (fourOfAKindCounter/getNumberOfHandsToPlay()) * 100 + "% where a Four of a Kind was the best possible hand." );
		System.out.println("There were " + (fullHouseCounter/getNumberOfHandsToPlay()) * 100 + "% where a Full Houses was the best possible hand." );
		System.out.println("There were " + (flushCounter/getNumberOfHandsToPlay()) * 100 + "% where a Flush was the best possible hand." );
		System.out.println("There were " + (straightCounter/getNumberOfHandsToPlay()) * 100 + "% where a Straight was the best possible hand." );
		System.out.println("There were " + (threeOfAKindCounter/getNumberOfHandsToPlay()) * 100 + "% where Three of a Kind was the best possible hand." );
		System.out.println("There were " + (twoPairCounter/getNumberOfHandsToPlay()) * 100 + "% where Two Pairs was the best possible hand." );
		System.out.println("There were " + (pairCounter/getNumberOfHandsToPlay()) * 100 + "% where a Pair was the best possible hand." );
		System.out.println("There were " + (highCardCounter/getNumberOfHandsToPlay()) * 100 + "% hands where the High Card was best possible hand." );
	}
	public int getFiveOrSevenCard() {
		return fiveOrSevenCard;
	}
	public void setFiveOrSevenCard(int fiveOrSevenCard) {
		this.fiveOrSevenCard = fiveOrSevenCard;
	}
	public int getRoyalFlushCounter() {
		return royalFlushCounter;
	}
	public void setRoyalFlushCounter(int royalFlushCounter) {
		this.royalFlushCounter = royalFlushCounter;
	}
	public int getStraightFlushCounter() {
		return straightFlushCounter;
	}
	public void setStraightFlushCounter(int straightFlushCounter) {
		this.straightFlushCounter = straightFlushCounter;
	}
	public int getFourOfAKindCounter() {
		return fourOfAKindCounter;
	}
	public void setFourOfAKindCounter(int fourOfAKindCounter) {
		this.fourOfAKindCounter = fourOfAKindCounter;
	}
	public int getFullHouseCounter() {
		return fullHouseCounter;
	}
	public void setFullHouseCounter(int fullHouseCounter) {
		this.fullHouseCounter = fullHouseCounter;
	}
	public int getFlushCounter() {
		return flushCounter;
	}
	public void setFlushCounter(int flushCounter) {
		this.flushCounter = flushCounter;
	}
	public int getStraightCounter() {
		return straightCounter;
	}
	public void setStraightCounter(int straightCounter) {
		this.straightCounter = straightCounter;
	}
	public int getThreeOfAKindCounter() {
		return threeOfAKindCounter;
	}
	public void setThreeOfAKindCounter(int threeOfAKindCounter) {
		this.threeOfAKindCounter = threeOfAKindCounter;
	}
	public int getTwoPairCounter() {
		return twoPairCounter;
	}
	public void setTwoPairCounter(int twoPairCounter) {
		this.twoPairCounter = twoPairCounter;
	}
	public int getPairCounter() {
		return pairCounter;
	}
	public void setPairCounter(int pairCounter) {
		this.pairCounter = pairCounter;
	}
	public int getHighCardCounter() {
		return highCardCounter;
	}
	public void setHighCardCounter(int highCardCounter) {
		this.highCardCounter = highCardCounter;
	}


	public double getNumberOfHandsToPlay() {
		return numberOfHandsToPlay;
	}


	public void setNumberOfHandsToPlay(double numberOfHandsToPlay) {
		this.numberOfHandsToPlay = numberOfHandsToPlay;
	}

}
