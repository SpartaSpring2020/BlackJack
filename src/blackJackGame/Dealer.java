package blackJackGame;

import java.util.ArrayList;


public class Dealer {
    private Deck cardsDeck;
    ArrayList < Player > players = new ArrayList < Player > ();
    private Hand myHand = new Hand();
    private int score;

    public Dealer() {
        cardsDeck = new Deck();
        cardsDeck.generateDeck();
        cardsDeck.shuffleDeck();
        Player player1 = new Player("Name");
        players.add(player1);
    }

    public void deal() {
        for (Player p: players) {
            Card topCard;
            for (int i = 1; i <= 4; i++) {
                topCard = cardsDeck.getDeck().get(0);
                if (i % 2 == 0) {
                    myHand.addCard(topCard);

                } else {
                    p.getHand().addCard(topCard);
                }
                cardsDeck.getDeck().remove(0);
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
    public int getPlayerValue() {
        return players.get(0).getTotalValue();
    }
    public void emptyHand() {
    	myHand = null;
    	myHand = new Hand();
    }
    
    

}
