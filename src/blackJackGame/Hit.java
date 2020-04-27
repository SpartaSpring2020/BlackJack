package blackJackGame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hit extends playGame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    	boolean isStartNewGame = false;
        GUI gui = playGame.getGUI();
        Dealer dealer = gui.dealer;
        Deck cardsDeck = dealer.getCardsDeck();
        Card topCard = cardsDeck.drawCard();
        Player player = gui.player;
        gui.addPlayerCard(topCard);
        gui.updatePlayerCards();
        //Validate for total
        int playerTotal = player.getTotalValue();
        if( playerTotal > 21 )
        {
        	//Total with new card is more than 21
        	JOptionPane.showMessageDialog(null, "Total exeeded 21", "Lost the game", JOptionPane.INFORMATION_MESSAGE);
        	isStartNewGame = true;
        }
        else if( playerTotal == 21 )
        {
        	JOptionPane.showMessageDialog(null, "Excellent: It's 21, it's dealers turn", "Dealers Turn", JOptionPane.INFORMATION_MESSAGE);
        	gui.pressStandButton();
        	isStartNewGame = true;
        }
        if( isStartNewGame )
        {
        	playGame.newGame();
        }
    }
}
