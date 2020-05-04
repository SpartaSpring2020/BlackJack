package blackJackGame;

import java.util.ArrayList;

public class playGame implements Runnable {


	static Dealer dealer = null;// = new Dealer();
	static GUI gui = null;//new GUI(dealer);
	static int numOfPlayers = 2;

	public static void main(String[] args) {
		dealer = new Dealer(numOfPlayers);
		gui = new GUI(dealer);
		boolean isGameCompleted = gui.checkForGameCompletion();
		if (!isGameCompleted) {
			new Thread(new playGame()).start();
		}
	}

	public void run() {
		while (true) {
			gui.repaint();
		}
	}

	public static GUI getGUI() {
		return gui;
	}

	public static void newRound() {
		System.out.println("Players Score is: " + dealer.getPlayers().get(0).getScore());
		System.out.println("Starting New Round...");
		dealer.newRound();
		if( null != gui )
		{
			gui.setVisible(false);
			gui.dispose();
		}
		gui = new GUI(dealer);
		new Thread(new playGame()).start();

	}

	public static void newGame() {
		System.out.println("Starting New Game...");
		if( null != gui )
		{
			gui.setVisible(false);
			gui.dispose();
		}
		dealer = null;
		dealer = new Dealer(numOfPlayers);    	
		gui = new GUI(dealer);
		new Thread(new playGame()).start();
	}

	public Dealer getDealer() {return dealer;}
}
