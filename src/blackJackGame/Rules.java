package blackJackGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Rules implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        String rules = "1. The goal of the Black Jack game is to beat the dealer's hand without going over 21\n" +
            "2. Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.\n" +
            "3. Player starts with two cards, one of the dealer's cards is hidden until the end.\n" +
            "4. To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n" +
            "5. If the player goes over 21, and the dealer wins regardless of the dealer's hand.\n" +
            "6. If the player is dealt 21 from the start (Ace & 10), he wins the game.\n" +
            "7. The dealer will hit until his/her cards total 17 or higher.\n";
        JOptionPane.showMessageDialog(null, rules + e.getActionCommand());
    }

}