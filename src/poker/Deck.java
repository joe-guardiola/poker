package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deckOfCards = new ArrayList<Card>();
	public Deck() throws CardException {
		ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Spades", "Clubs"));
		for(int suitCounter = 0; suitCounter < suits.size(); suitCounter++) {
			for(int valuesCounter = 2; valuesCounter < 15; valuesCounter++) {
					Card tempCard = new Card(valuesCounter, suits.get(suitCounter));
					deckOfCards.add(tempCard);
			}
		}
	}
	public int getDeckSize() {
		return deckOfCards.size();
	}
	public void shuffle() throws CardException {
		Random r = new Random();
		for(int i = 0; i < deckOfCards.size(); i++) {
			int pos = r.nextInt(52 - 0) + 0;
			Card tempCard = new Card(deckOfCards.get(i).getValue(), deckOfCards.get(i).getSuit());
			deckOfCards.get(i).setValue(deckOfCards.get(pos).getValue());
			deckOfCards.get(i).setSuit(deckOfCards.get(pos).getSuit());
			deckOfCards.get(pos).setValue(tempCard.getValue());
			deckOfCards.get(pos).setSuit(tempCard.getSuit());
		}
	}
	
	public void dealCards(ArrayList <Card> hand, int numCards)
	{
		for(int i = 0; i<numCards;i++)
		{
			hand.add(deckOfCards.get(deckOfCards.size() - 1));
			deckOfCards.remove(deckOfCards.size() - 1);
		}
	}
	
	public void printDeck() {
		for(int i = 0; i < 52; i++) {
			deckOfCards.get(i).print();
		}
	}
}
