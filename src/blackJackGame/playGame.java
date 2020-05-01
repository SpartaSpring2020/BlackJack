package blackJackGame;


public class playGame implements Runnable {
    static GUI gui = new GUI();

    public static void main(String[] args) {
        boolean isGameCompleted = gui.checkForGameCompletion();
        if (!isGameCompleted) {
            new Thread(new playGame()).start();
        }
    }

    public void run() {
        while (true) {
            gui.repaint();
        }
    }

    public static GUI getGUI() {
        return gui;
    }

    public static void newGame() {
        gui.dispose();
        gui = new GUI();
        new Thread(new playGame()).start();
    }
}