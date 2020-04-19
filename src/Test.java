
public class Test implements Runnable {
	GUI gui  = new GUI();
	
	public static void main(String[] args) {
		new Thread (new Test()).start();
		
		

	}

	@Override
	public void run() {
		
		while (true)
			{
			gui.repaint();
			}
		// TODO Auto-generated method stub
	}
	}
