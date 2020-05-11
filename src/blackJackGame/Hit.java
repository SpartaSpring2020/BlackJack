package blackJackGame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Hit extends playGame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isPlayerTurnComplete = false;
        GUI gui = playGame.getGUI();
        Dealer dealer = gui.dealer;
        Deck cardsDeck = dealer.getCardsDeck();
        Card topCard = cardsDeck.drawCard();
        ArrayList<Player> players = dealer.players;
        Player player = null;
        int playerNum = -1;
        for( int cnt = 0; cnt < players.size(); ++cnt )
        {
        	if(players.get(cnt).isCurrentPlayer())
        	{
        		player = players.get(cnt);
        		playerNum = cnt+1;
        	}
        }
        gui.addPlayerCard(player, topCard);
        gui.updatePlayerCards(playerNum);
        //Validate for total
        int playerTotal = player.getTotalValue();
        
        
        if (playerTotal > 21) {
        	if( playerNum == 1 )
        	{
        		JOptionPane.showMessageDialog(null, "Next Player turn", "Your Turn Complete", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(playerNum == 2)
        	{
        		JOptionPane.showMessageDialog(null, "Let's check the result", "Your Turn Complete", JOptionPane.INFORMATION_MESSAGE);
        	}
        	isPlayerTurnComplete = true;
        } else if (playerTotal == 21) {

        	if( playerNum == 1 )
        	{
        		JOptionPane.showMessageDialog(null, "Excellent: It's 21, it's next Player turn", "Your Turn Complete", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(playerNum == 2)
        	{
        		JOptionPane.showMessageDialog(null, "Excellent: It's 21, Let's check the result", "Your Turn Complete", JOptionPane.INFORMATION_MESSAGE);
        	}
        	isPlayerTurnComplete = true;
        }
        

        if (isPlayerTurnComplete) {
        	updatePlayerActivity(players,gui);
        }
    }
    
    private void updatePlayerActivity(ArrayList<Player> players, GUI gui)
    {
		for( int cnt = 0; cnt < players.size(); ++cnt )
		{
			if(players.get(cnt).isCurrentPlayer())
			{
				if( cnt != ( players.size() - 1 ) )
				{
					players.get(cnt).setToPlayerActivity(false);
					players.get(cnt+1).setToPlayerActivity(true);
				}
				else
				{
					players.get(cnt).setToPlayerActivity(false);
					gui.pressStandButton();
				}
				break;
			}
		}
    }
}