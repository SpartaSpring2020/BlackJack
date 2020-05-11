package blackJackGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Caller extends JFrame
{
	
	ArrayList <Player> players= new ArrayList<Player>();
	Dealer dealer;
	
	JButton  playgame =  new JButton("PLAY GAME");

	JButton player1_dollar10 = new JButton();
	JButton player1_dollar20 = new JButton();
	    
    JButton player1_dollar50 = new JButton();
    JButton player1_dollar100 = new JButton();
	    
	JButton player2_dollar10 = new JButton();
	JButton player2_dollar20 = new JButton();
	    
	JButton player2_dollar50 = new JButton();
	JButton player2_dollar100 = new JButton();		
    
    JButton skip = new JButton();
    Font fontButton = new Font("Times New Roman", Font.PLAIN, 20);
	Font fontButton2 = new Font("Times New Roman", Font.PLAIN, 18);
	Font fontCard = new Font("Times New Roman", Font.BOLD, 30);
	Font labelFont = new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 20);

	Color colorBackground = new Color(0, 128, 0);
	Color colorButton = new Color(250, 250, 250);


	int width = 1200; // Screen Height
	int height = 900; // Screen Width
	
	public Caller(ArrayList <Player> plyrs, Dealer dlr)
	{
		
		this.dealer = dlr;
		
		for (Player p: plyrs) {
			players.add(p);
		}
		
		
		player1_dollar10.setBounds(100, 200, 160, 40);
		player1_dollar10.setFont(fontButton);
		player1_dollar10.setBackground(colorButton);
		player1_dollar10.setText("$10");
		

		player1_dollar20.setBounds(100, 250, 160, 40);
		player1_dollar20.setFont(fontButton);
		player1_dollar20.setBackground(colorButton);
		player1_dollar20.setText("$20");
		
		
		player1_dollar50.setBounds(300, 200, 160, 40);
		player1_dollar50.setFont(fontButton);
		player1_dollar50.setBackground(colorButton);
		player1_dollar50.setText("$50");
		

		player1_dollar100.setBounds(300, 250, 160, 40);
		player1_dollar100.setFont(fontButton);
		player1_dollar100.setBackground(colorButton);
		player1_dollar100.setText("$100");
		
		
		
		
		player2_dollar10.setBounds(500, 200, 160, 40);
		player2_dollar10.setFont(fontButton);
		player2_dollar10.setBackground(colorButton);
		player2_dollar10.setText("$10");
		

		player2_dollar20.setBounds(500, 250, 160, 40);
		player2_dollar20.setFont(fontButton);
		player2_dollar20.setBackground(colorButton);
		player2_dollar20.setText("$20");
		
		
		player2_dollar50.setBounds(700, 200, 160, 40);
		player2_dollar50.setFont(fontButton);
		player2_dollar50.setBackground(colorButton);
		player2_dollar50.setText("$50");
		

		player2_dollar100.setBounds(700, 250, 160, 40);
		player2_dollar100.setFont(fontButton);
		player2_dollar100.setBackground(colorButton);
		player2_dollar100.setText("$100");
		
		
		skip.setBounds(600, 450, 200, 40);
		skip.setFont(fontButton);
		skip.setBackground(colorButton);
		skip.setText("SKIP BETTING");
		
		
		
		setSize(width, height);
		setTitle("BlackJack");
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame2 F2 = new Frame2();
		setContentPane(F2);
		setLayout(null);
		F2.add(player1_dollar10);
		F2.add(player1_dollar20);
		F2.add(player1_dollar50);
		F2.add(player1_dollar100);
		
		F2.add(player2_dollar10);
		F2.add(player2_dollar20);
		F2.add(player2_dollar50);
		F2.add(player2_dollar100);
		F2.add(skip);
		F2.add(playgame);
	
		player1_dollar10.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(0).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $10");
					balance = balance - 10;
					players.get(0).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(0).getBalance());
					dealer.addMoneytoPot(10);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
			
		});
		
		player1_dollar20.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(0).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $20");
					balance = balance - 20;
					players.get(0).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(0).getBalance());
					dealer.addMoneytoPot(20);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
			
		});
	
		player1_dollar50.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(0).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $50");
					balance = balance - 50;
					players.get(0).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(0).getBalance());
					dealer.addMoneytoPot(50);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
				
		});
		
		player1_dollar100.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(0).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $100");
					balance = balance - 100;
					players.get(0).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(0).getBalance());
					dealer.addMoneytoPot(100);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
			
		});
		
		player2_dollar10.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(1).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $10");
					balance = balance - 10;
					players.get(1).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(1).getBalance());
					dealer.addMoneytoPot(10);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
			
		});
		
		player2_dollar20.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(1).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $20");
					balance = balance - 20;
					players.get(1).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(1).getBalance());
					dealer.addMoneytoPot(20);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
			
		});
	
		player2_dollar50.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(1).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $50");
					balance = balance - 50;
					players.get(1).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(1).getBalance());
					dealer.addMoneytoPot(50);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
				
		});
		
		player2_dollar100.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int balance = players.get(1).getBalance();
				if (balance > 0) {
					System.out.println("Player Balance: $" + balance);
					System.out.println("Betting $100");
					balance = balance - 100;
					players.get(1).setBalance(balance);
					System.out.println("Player Balance: $" + players.get(1).getBalance());
					dealer.addMoneytoPot(100);
				}
				else {
					System.out.println("You're Broke, go Home!");
				}
				dispose();
			}
			
		});
		
		

		skip.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
			dispose();
			}
		});

	}

		public class Frame2 extends JPanel {


			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(colorBackground);
				g.fillRect(0, 0, width, height);
				//Temp grid
				g.setColor(Color.black);
				Graphics2D eg = (Graphics2D) g;
				Color white = new Color(255, 255, 255);
				eg.setColor(white);
				eg.setFont(labelFont);
				eg.drawString("BETTING", 425, 100);
				eg.drawString("PLAYER1", 225, 150);
				eg.drawString("PLAYER2", 625, 150);
		}


	}
	}

