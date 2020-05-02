package blackJackGame;

import java.util.ArrayList;

public class Player {
    private Hand myHand = new Hand();
    private String myName;
    private int score = 0;

    public Player(String name) {
        if (name.isEmpty()) {
            myName = "Anonymous";
        } else {
            myName = name;
        }
    }

    public Hand getHand() {
        return myHand;
    }
    public String getName() {
        return myName;
    }
    public int getTotalValue() {
        return myHand.getHandValue();
    }
    
    public void emptyHand() {
    	myHand = null;
    	myHand = new Hand();
    }
    
    public void hasWon() {
    	score = score + 1;
    	System.out.println("Player's Score: " + score);
    }



}