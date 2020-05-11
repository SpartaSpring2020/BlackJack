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
					//Validate for total
					if (dealer.getDealerValue() > 21) {
						//Total with new card is more than 21
						//JOptionPane.showMessageDialog(null, "Dealer's Total exeeded 21", "Won the round", JOptionPane.INFORMATION_MESSAGE);
						//players.get(cnt).hasWon();
						break;
					} else if (dealer.getDealerValue() == 21) {
						if (playerTotal == 21) {
							//tie
							//JOptionPane.showMessageDialog(null, "It's a tie, will start a new round", "Tie", JOptionPane.INFORMATION_MESSAGE);
						} else {
							//Dealer won
							//JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					} else if (dealer.getDealerValue() > playerTotal) {

						//JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
						break;

					}
				}
			} else if (playerTotal < dealerTotal) {
				//JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		dealerCount = dealer.getDealerValue();
		gui.refreshDealerCards();
		displayResult(dealerCount, p1Count, players.get(0), 1, dealer);
		displayResult(dealerCount, p2Count, players.get(1), 2, dealer);
		
	}
	
	private void displayResult(int dealerCount, int playerCount, Player player, int playerNum, Dealer deal)
	{
		if( playerCount > 21 )
		{
			JOptionPane.showMessageDialog(null, "Player"+playerNum+"'s total exceeded 21", "Player"+playerNum+" Lost", JOptionPane.INFORMATION_MESSAGE);
			deal.emptyPot();
			return;
		}
		if(dealerCount > 21 )
		{
			JOptionPane.showMessageDialog(null, "Dealer's total exceeded 21", "Player"+playerNum+" Won", JOptionPane.INFORMATION_MESSAGE);
			player.setGamesWon(player.getGamesWon()+1);
			int pot = deal.getPot();
			int prevBal = player.getBalance();
			player.setBalance(prevBal + pot);
			deal.emptyPot();
			return;
		}
		
		if( playerCount > dealerCount )
		{
			//Player won
			JOptionPane.showMessageDialog(null, "Player"+playerNum+"'s total is more than Dealer's", "Player"+playerNum+" Won", JOptionPane.INFORMATION_MESSAGE);
			player.setGamesWon(player.getGamesWon()+1);
			int pot = deal.getPot();
			int prevBal = player.getBalance();
			player.setBalance(prevBal + pot);
			deal.emptyPot();
		}
		else if( playerCount < dealerCount )
		{
			//Player lost
			JOptionPane.showMessageDialog(null, "Player"+playerNum+"'s total is less than Dealer's", "Player"+playerNum+" Lost", JOptionPane.INFORMATION_MESSAGE);
			deal.emptyPot();
		}
		if( playerCount == dealerCount )
		{
			//Tie
			JOptionPane.showMessageDialog(null, "Player"+playerNum+" and Dealer got same total", "It's a Tie", JOptionPane.INFORMATION_MESSAGE);
			deal.emptyPot();
		}
	}
}