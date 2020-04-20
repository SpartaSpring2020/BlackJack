package blackJackGame;


public class playGame implements Runnable {
    GUI gui = new GUI();

    public static void main(String[] args) {
        new Thread(new playGame()).start();
    }

    public void run() {
        while (true) {
            gui.repaint();
        }
    }
}