package blackJackGame;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewGame extends playGame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    	String[] options = new String[2];
    	options[0] = new String("Yes, End Game");
    	options[1] = new String("No, Continue Game");
    	
        int reply = JOptionPane.showOptionDialog(null, "Start a New Game?", "New Game?",
        	    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
        	    options, options[0]);
        if (reply == JOptionPane.YES_OPTION) {
            playGame.newGame();
        } else {
            return;
        }

    }
}