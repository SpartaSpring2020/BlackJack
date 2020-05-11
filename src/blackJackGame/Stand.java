package blackJackGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Stand implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI gui = playGame.getGUI();
		Dealer dealer = gui.dealer;
		Deck cardsDeck = dealer.getCardsDeck();
		ArrayList<Player> players = dealer.players;
        Player CurrentPlayer = null;
        int playerNum = -1;
		for( int cnt = 0; cnt < players.size(); ++cnt )
		{
			if(players.get(cnt).isCurrentPlayer())
			{
				CurrentPlayer = players.get(cnt);
				playerNum = cnt+1;
				if( cnt != ( players.size() - 1 ) )
				{
					CurrentPlayer.setToPlayerActivity(false);
					players.get(cnt+1).setToPlayerActivity(true);
				}
				else
				{
					CurrentPlayer.setToPlayerActivity(false);
					CurrentPlayer = null;
				}
				break;
			}
		}
		if(null == CurrentPlayer)
		{		
			checkForWin( gui, dealer, players, cardsDeck );
			playGame.newRound();
		}
	}

	private void checkForWin(GUI gui, Dealer dealer, ArrayList<Player> players, Deck cardsDeck)
	{
		int p1Count = players.get(0).getTotalValue();
		int p2Count = players.get(1).getTotalValue();
		int dealerCount = dealer.getDealerValue();
		
		if( p1Count > 21 && p2Count > 21 )
		{
			gui.refreshDealerCards();
			JOptionPane.showMessageDialog(null, "Both Player's total has exceeded 21.", "Both Players lost the round", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if( dealerCount > p1Count && dealerCount > p2Count )
		{
			gui.refreshDealerCards();
			JOptionPane.showMessageDialog(null, "Dealer has highest total.", "Both Players lost the round", JOptionPane.INFORMATION_MESSAGE);
			return;			
		}
		
		for( int cnt = 0; cnt < players.size(); ++cnt )
		{
			int playerTotal = players.get(cnt).getTotalValue();
			int dealerTotal = dealer.getDealerValue();
			if (playerTotal > dealerTotal && playerTotal <= 21 ) {
				for (; dealer.getDealerValue() <= 20;) {
					Card topCard = cardsDeck.drawCard();
					gui.addDealerCard(topCard);
					gui.refreshDealerCards();
				}
			}
		}
		dealerCount = dealer.getDealerValue();
		gui.refreshDealerCards();
		
		
		displayResult(dealer);

	}
		private void displayResult(Dealer deal)
		{
			Player player1 = deal.getPlayers().get(0);
			Player player2 = deal.getPlayers().get(1);
			int dealerCount = deal.getDealerValue();
			int p1Count = player1.getTotalValue();
			int p2Count = player2.getTotalValue();
			boolean dealerWins = false;
			boolean dealerLoss = false;
			boolean p1Loss = false;
			boolean p2Loss = false;
			int pot = deal.getPot();
			int p1Bal = player1.getBalance();
			int p2Bal = player2.getBalance();
			if (dealerCount > 21) {
				JOptionPane.showMessageDialog(null, "Dealer's total exceeded 21", "Dealer Lost", JOptionPane.INFORMATION_MESSAGE);
				dealerLoss = true;
			}
			if( p1Count > 21 )
			{
				JOptionPane.showMessageDialog(null, "Player 1's total exceeded 21", "Player 1 Lost", JOptionPane.INFORMATION_MESSAGE);
				p1Loss = true;
			}
			if (p2Count > 21)
			{
				JOptionPane.showMessageDialog(null, "Player 2's total exceeded 21", "Player 2 Lost", JOptionPane.INFORMATION_MESSAGE);
				p2Loss = true;
			}
			if (p1Loss && p2Loss || dealerCount == 21) {
				dealerWins = true;
			}
			//Dealer Wins
			if (dealerWins) {
				JOptionPane.showMessageDialog(null, "Oh No!", "Dealer Won the Round", JOptionPane.INFORMATION_MESSAGE);
				deal.emptyPot();
				return;
			}
			if (dealerLoss)
			{
				System.out.println("Dealer loses");
				//Player 1 Wins
				if (p1Loss == false && p1Count > p2Count || p2Loss == true) {
					JOptionPane.showMessageDialog(null, "Player 1's total is: " + p1Count, "Player 1 Wins!", JOptionPane.INFORMATION_MESSAGE);
					player1.setGamesWon(player1.getGamesWon() + 1);
					player1.setBalance(p1Bal + pot);
					deal.emptyPot();
					return;
				}
				//Player 2 Wins
				else if (p2Loss == false && p2Count > p1Count || p1Loss == true)
				{
					JOptionPane.showMessageDialog(null, "Player 2's total is: " + p2Count, "Player 2 Wins!", JOptionPane.INFORMATION_MESSAGE);
					player2.setGamesWon(player2.getGamesWon() + 1);
					player2.setBalance(p2Bal + pot);
					deal.emptyPot();
					return;
				}
				//Tie
				else if (p1Count == p2Count) {
					JOptionPane.showMessageDialog(null, "It's A Tie", "Nobody Wins", JOptionPane.INFORMATION_MESSAGE);
					deal.emptyPot();
					return;
				}
			}
			else if (dealerLoss == false){
				System.out.println("Dealer Did'nt lose");
			//Player 1 Wins
			if(p1Count > p2Count && p1Count > dealerCount && p1Loss == false) {
				JOptionPane.showMessageDialog(null, "Player 1's total is: " + p1Count, "Player 1 Wins!", JOptionPane.INFORMATION_MESSAGE);
				player1.setGamesWon(player1.getGamesWon() + 1);
				player1.setBalance(p1Bal + pot);
				deal.emptyPot();
				return;
			}
			//Player 2 Wins
			else if (p2Count > p1Count && p2Count > dealerCount && p2Loss == false) {
				JOptionPane.showMessageDialog(null, "Player 2's total is: " + p2Count, "Player 2 Wins!", JOptionPane.INFORMATION_MESSAGE);
				player2.setGamesWon(player2.getGamesWon() + 1);
				player2.setGamesWon(player2.getGamesWon() + 1);
				player2.setBalance(p2Bal + pot);
				deal.emptyPot();
				return;
			}
		}
		}
	}
			
		
			

	
		
