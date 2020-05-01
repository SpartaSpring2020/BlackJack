package blackJackGame;

import java.util.ArrayList;

public class Hand {
    ArrayList < Card > cards;
    private int value;

    public Hand() {
        cards = new ArrayList < Card > ();
    }

    public void addCard(Card thisCard) {
        cards.add(thisCard);
        handValue();
    }


    public void handValue() {
        value = 0;
        boolean hasAce = false;
        for (Card c: cards) {
            if (c.isAce()) {
                hasAce = true;
            }
            value = value + c.getCardValue();
        }
        if (value > 21 && hasAce) {
            value = value - 10;
        }
    }

    public int getHandValue() {
        return value;
    }
    public ArrayList < Card > getCards() {
        return cards;
    }
}