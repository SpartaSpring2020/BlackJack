package blackJackGame;

import java.util.ArrayList;


public class Dealer {
	private Deck cardsDeck;
	ArrayList < Player > players = new ArrayList < Player > ();
	private Hand myHand = new Hand();
	private int bettingPot = 0;

	public Dealer(int numOfPlayers) {
		cardsDeck = Deck.getInstance();
		
		cardsDeck.generateDeck();
		cardsDeck.shuffleDeck();
		for( int cnt = 0; cnt < numOfPlayers; ++cnt )
		{
			Player player = new Player("Name"+(cnt+1));
			players.add(player);
		}
	}

	public void deal() {
		for( int cnt = 1; cnt <= (players.size()+1)*2; ++cnt )
		{
			if( null == cardsDeck || null == cardsDeck.drawCard() )
			{
				cardsDeck.generateDeck();
				cardsDeck.shuffleDeck();
			}

			Card topCard = cardsDeck.drawCard();
			if( cnt % (players.size()+1) == 0 )
			{

				myHand.addCard(topCard);
			}
			else
			{
				players.get((cnt % (players.size()+1))-1).getHand().addCard(topCard);
			}
		}
		
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
	
	public void addMoneytoPot(int money) {
		bettingPot = bettingPot + money;
	}
	
	public int getPot()
	{
		return bettingPot;
	}
	
	public void emptyPot()
	{
		bettingPot = 0;
	}



}
