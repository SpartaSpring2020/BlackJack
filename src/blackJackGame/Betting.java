package blackJackGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Betting implements ActionListener { {

	
}
public void actionPerformed(ActionEvent e) {
	GUI gui = playGame.getGUI();
	Dealer dealer = gui.dealer;
	ArrayList <Player> players = new ArrayList<Player>();
	
	players = dealer.getPlayers();
	new Caller(players, dealer);

}
}
