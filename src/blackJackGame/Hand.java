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
//			if (c.getValue() == 1)
//			{
//				value = value + 11;
//			}
//			else{
////				value = value + c.getValue();
//			}
		}
		 this.value = value;
	}
	
	public int getValue() {return value;}
	public ArrayList <Card> getHand() {return cards;}
}
