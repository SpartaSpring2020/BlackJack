package blackJackGame;


import java.util.ArrayList;

public class Card {
    private String shape;
    private String type;
    private int num;
    private String name;
    private int gameValue;
    
    public Card(int number, String shape) {
        this.num = number;
        this.shape = shape;
        gameValue = number;

        switch (num) {
        case 11:
            type = "J";
            name = "Jack";
            gameValue = 10;
        case 12:
            type = "Q";
            name = "Queen";
            gameValue = 10;
        case 13:
            type = "K";
            name = "King";
            gameValue = 10;
        case 14:
            type = "A";
            name = "Ace";
            gameValue = 11;
        }
    }
    
    public String getShape() {return shape;}
    public int getNum() {return num;}
    public String getType() {return type;}
    public String getName() {return name;}
    public int getValue() {return gameValue;}
    
    
}