package blackJackGame;


public class Player {
	private Hand myHand = new Hand();
	private boolean isCurrentPlayer = false;
	private String myName;
	private int score = 0;
	private boolean isHitComplete = false;

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
	}


	public int getScore() {
		return score;
	}

	public boolean isCurrentPlayer()
	{
		return isCurrentPlayer;
	}

	public void setToPlayerActivity(boolean isPlayersTurn)
	{
		isCurrentPlayer = isPlayersTurn;
	}
	
	public boolean isHitComplete()
	{
		return isHitComplete;
	}
	
	public void setHitComplete()
	{
		isHitComplete = true;
	}
}