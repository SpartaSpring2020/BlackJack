package blackJackGame;

import java.util.ArrayList;

public class Hand {
	ArrayList <Card> cards;
	private int value;

	public Hand()
	{
		cards = new ArrayList <Card>();
	}

	public void addCard(Card thisCard) {
		cards.add(thisCard);
		handValue();
	}


	public void handValue()
	{
		int value = 0;
		for (Card c : cards) {
			if (c.getCardValue() == 1)
			{
				value = value + 11;
			}
			else{
				value = value + c.getCardValue();
			}
		}
		 this.value = value;
	}

	public int getHandValue() {return value;}
	public ArrayList <Card> getCards() {return cards;}
}
