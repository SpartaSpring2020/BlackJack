package blackJackGame;

import java.util.ArrayList;

public class Player {
	private Hand myHand = new Hand();
	private String myName;

	public Player(String name) {
		if(name.isEmpty()) {
			myName = "Anonymous";
		}
		else {
		myName = name;
		}
	}

	public Hand getHand() {return myHand;}
	public String getName() {return myName;}
	public int getTotalValue() { return myHand.getHandValue(); }

}
