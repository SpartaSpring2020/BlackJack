package blackJackGame;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewGame extends playGame implements ActionListener {

	    @Override
	    public void actionPerformed(ActionEvent e) {

	    	int reply = JOptionPane.showConfirmDialog(null, "Start a New Game?", "New Game", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    	    JOptionPane.showMessageDialog(null, "GoodBye");
		        	playGame.newGame();
		        }
	    	 else {
	    	    return;
	    	}
	 
	    }
}
