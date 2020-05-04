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
		boolean isNextPlayersTurn = false;
		for( int cnt = 0; cnt < players.size(); ++cnt )
		{
			if(players.get(cnt).isCurrentPlayer())
			{
				if( cnt != ( players.size() - 1 ) )
				{
					isNextPlayersTurn = true;
					players.get(cnt).setToPlayerActivity(false);
					players.get(cnt+1).setToPlayerActivity(true);
				}
				else
				{
					players.get(cnt).setToPlayerActivity(false);
				}
				break;
			}
		}
		if(!isNextPlayersTurn)
		{		
			checkForWin( gui, dealer, players, cardsDeck );
			playGame.newRound();
		}
	}

	private void checkForWin(GUI gui, Dealer dealer, ArrayList<Player> players, Deck cardsDeck)
	{
		for( int cnt = 0; cnt < players.size(); ++cnt )
		{
			int playerTotal = players.get(cnt).getTotalValue();
			int dealerTotal = dealer.getDealerValue();
			if (playerTotal >= dealerTotal) {
				for (; dealer.getDealerValue() <= 20;) {
					Card topCard = cardsDeck.drawCard();
					gui.addDealerCard(topCard);
					gui.updateDealerCards();
					//Validate for total
					if (dealer.getDealerValue() > 21) {
						//Total with new card is more than 21
						JOptionPane.showMessageDialog(null, "Dealer's Total exeeded 21", "Won the round", JOptionPane.INFORMATION_MESSAGE);
						players.get(cnt).hasWon();
						break;
					} else if (dealer.getDealerValue() == 21) {
						if (playerTotal == 21) {
							//tie
							JOptionPane.showMessageDialog(null, "It's a tie, will start a new round", "Tie", JOptionPane.INFORMATION_MESSAGE);
						} else {
							//Dealer won
							JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					} else if (dealer.getDealerValue() > playerTotal) {

						JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
						break;

					}
				}
			} else if (playerTotal < dealerTotal) {
				JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}