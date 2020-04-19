
public class Cards {
	String shape;
	int num;
	boolean used = false;
	String type;
	String name;
	int code;
	public Cards(int number, String shape, int code)
	{
		this.num= number;
		this.shape = shape;
		this.code = code; 
		
		if (num < 11)
		{
			type = Integer.toString(num);
			name =Integer.toString(num);
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
			}
		
		}
	}

