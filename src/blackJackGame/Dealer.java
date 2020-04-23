package blackJackGame;

import java.util.ArrayList;


public class Dealer {
	private Deck cards;
	ArrayList <Player> players = new ArrayList <Player>();
	private Hand myHand = new Hand();
	
	public Dealer() {
	cards = new Deck();
	cards.generateDeck();
	cards.shuffleDeck();
    Player player1 = new Player("Name");
    players.add(player1);
	}
	
	public void deal()
	{
		for (Player p : players) {
			Card topCard;
		for (int i=0; i<4; i++) {
			topCard = cards.getDeck().get(0);
			if (i%2 == 0)
			{
				myHand.addCard(topCard);
				
			}
			else {
				p.getHand().addCard(topCard);
			}
			cards.getDeck().remove(0);
		}
		
	}
	}
	
	public void score() {
		int dealerScore = myHand.getValue();
		int playerScore = players.get(0).getHand().getValue();
	}
	
	public ArrayList <Player> getPlayers(){return players;}
	public Hand getHand() {return myHand;}
	
}
	

