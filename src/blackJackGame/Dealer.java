package blackJackGame;

import java.util.ArrayList;


public class Dealer {
	private Deck cardsDeck;
	ArrayList < Player > players = new ArrayList < Player > ();
	private Hand myHand = new Hand();
	//private int score;

	public Dealer(int numOfPlayers) {
		cardsDeck = new Deck();
		cardsDeck.generateDeck();
		cardsDeck.shuffleDeck();
		for( int cnt = 0; cnt < numOfPlayers; ++cnt )
		{
			Player player = new Player("Name"+(cnt+1));
			players.add(player);
		}
		//players.get(0).setToPlayerActivity(true);
	}

	public void deal() {
		for( int cnt = 1; cnt <= (players.size()+1)*2; ++cnt )
		{
			if( null == cardsDeck || null == cardsDeck.drawCard() )
			{
				cardsDeck.generateDeck();
				cardsDeck.shuffleDeck();
			}
			//Card topCard = cardsDeck.getDeck().get(0);
			//cardsDeck.getDeck().remove(0);
			Card topCard = cardsDeck.drawCard();
			if( cnt % (players.size()+1) == 0 )
			{
				//Dealer Cards
				myHand.addCard(topCard);
			}
			else
			{
				players.get((cnt % (players.size()+1))-1).getHand().addCard(topCard);
			}
		}
		/*for (Player p: players) {
			Card topCard;
			for (int i = 1; i <= 4; i++) {
				if( null == cardsDeck || null == cardsDeck.getDeck() || null == cardsDeck.getDeck().get(0) )
				{
					cardsDeck.generateDeck();
					cardsDeck.shuffleDeck();
				}
				topCard = cardsDeck.getDeck().get(0);
				if (i % 2 == 0) {
					myHand.addCard(topCard);

				} else {
					p.getHand().addCard(topCard);
				}
			}

		}*/
	}

	public void newRound() {
		for (Player p: players) {
			p.emptyHand();
		}
		this.emptyHand();
	}



	public ArrayList < Player > getPlayers() {
		return players;
	}
	public Hand getHand() {
		return myHand;
	}
	public Deck getCardsDeck() {
		return cardsDeck;
	}
	public int getDealerValue() {
		return myHand.getHandValue();
	}
	public int getPlayerValue(int playerNumber) {
		if( playerNumber < 1 || playerNumber >= players.size() )
			return -1;
		return players.get(playerNumber-1).getTotalValue();
	}
	public void emptyHand() {
		myHand = null;
		myHand = new Hand();
	}



}
