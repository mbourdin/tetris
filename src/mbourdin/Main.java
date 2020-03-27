package mbourdin;

import mbourdin.TetrisGraphics.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            Timer moveTimer = new Timer(25, mainWindow);
            moveTimer.setActionCommand("moveTimer");
            moveTimer.start();
            Timer fallTimer = new Timer(500, mainWindow);
            fallTimer.setActionCommand("fallTimer");
            fallTimer.start();
        });

    }
}
