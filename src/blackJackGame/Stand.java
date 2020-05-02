package blackJackGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Stand implements ActionListener {

    private boolean isHitComplete = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isStartNewGame = false;
        if (isHitComplete) return;
        isHitComplete = true;
        GUI gui = playGame.getGUI();
        Dealer dealer = gui.dealer;
        Deck cardsDeck = dealer.getCardsDeck();
        Player player = gui.player;
        int playerTotal = player.getTotalValue();
        int dealerTotal = dealer.getDealerValue();
        if (playerTotal >= dealerTotal) {
            for (; dealer.getDealerValue() <= 20 && !isStartNewGame;) {
                Card topCard = cardsDeck.drawCard();
                gui.addDealerCard(topCard);
                gui.updateDealerCards();
                //Validate for total
                if (dealer.getDealerValue() > 21) {
                    //Total with new card is more than 21
                    JOptionPane.showMessageDialog(null, "Dealer's Total exeeded 21", "Won the round", JOptionPane.INFORMATION_MESSAGE);
                    isStartNewGame = true;
                    player.hasWon();
                    break;
                } else if (dealer.getDealerValue() == 21) {
                    if (playerTotal == 21) {
                        //tie
                        JOptionPane.showMessageDialog(null, "It's a tie, will start a new round", "Tie", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        //Dealer won
                        JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
                    }
                    isStartNewGame = true;
                    break;
                } else if (dealer.getDealerValue() > playerTotal) {
                   
                    JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
                    isStartNewGame = true;
                    break;

                }
            }
        } else if (playerTotal < dealerTotal) {
            JOptionPane.showMessageDialog(null, "Dealer's total is more than your's", "Lost the round", JOptionPane.INFORMATION_MESSAGE);
            isStartNewGame = true;
        }

        if (isStartNewGame) {
            playGame.newRound();
        }
    }
}