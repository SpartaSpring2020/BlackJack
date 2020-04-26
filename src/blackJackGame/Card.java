package blackJackGame;

public class Card {
    private String shape;
    private String type;
    private int num;
    private String name;
    private int gameValue;

    public Card(int number, String shape) {
    	this.num= number;
		this.shape = shape;
		gameValue = 10;
		if (num < 11)
		{
			type = Integer.toString(num);
			name = Integer.toString(num);
			gameValue = number;
		}
		else if(num ==11)
			{
				type = "J";
				name = "Jack";
			}
			else if(num ==12)
			{
				type = "Q";
				name = "Queen";
			}
			else if(num ==13)
			{
				type = "K";
				name = "King";
			}
			else if(num==14)
			{
				type = "A";
				name = "Ace";
				gameValue = 11;
			}

		}


    public String getShape() {return shape;}
    public int getNum() {return num;}
    public String getType() {return type;}
    public String getName() {return name;}
    public int getCardValue() {return gameValue;}


}
