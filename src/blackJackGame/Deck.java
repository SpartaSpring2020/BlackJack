package blackJackGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
    ArrayList < Card > cards; 
    private static Deck instance;
    
    public static Deck getInstance() {
    	
    	if (instance == null) {
    		instance = new Deck();
    	}
    	return instance;
    }
    
    private Deck() {
    	cards = new ArrayList < Card > ();
    }

    public void generateDeck() {
        for (int i = 2; i < 15; i++) {
            Card club = new Card(i, "Clubs");
            Card heart = new Card(i, "Hearts");
            Card spade = new Card(i, "Spades");
            Card diamond = new Card(i, "Diamonds");
            cards.add(club);
            cards.add(heart);
            cards.add(spade);
            cards.add(diamond);
        }

    }

    public void shuffleDeck() {
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            for (int shfl = 0; shfl < 52; shfl++) {
                int r = shfl + rand.nextInt(52 - shfl);
                Collections.swap(cards, r, shfl);
            }
        }
    }

    public ArrayList < Card > getDeck() {
        return cards;
    }
    public Card drawCard() {
    	if( null == cards || cards.isEmpty() || null == cards.get(0) )
    	{
    		generateDeck();
    		shuffleDeck();
    	}
        Card myCard = cards.get(0);
        cards.remove(0);
        return myCard;
    }
}