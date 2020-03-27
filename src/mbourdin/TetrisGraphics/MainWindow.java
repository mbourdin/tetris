package mbourdin.TetrisGraphics;

import mbourdin.PlayerGame;
import mbourdin.Square;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame implements KeyListener, ActionListener {
    JGraphicsPanel playPanel;
    JPanel mainPanel;
    JPanel infoPanel;
    JLabel scoreLabel;
    JLabel lignesLabel;
    JGraphicsPanel nextPiecePanel;
    boolean left;
    boolean right;
    boolean down;
    boolean turnleft;
    boolean turnright;
    public static final int X_SIZE = Square.SIZE * PlayerGame.BOARD_WIDTH;
    public static final int Y_SIZE = Square.SIZE * PlayerGame.BOARD_HEIGTH;

    PlayerGame playerGame;

    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "moveTimer":
                moveAction();
                break;
            case "fallTimer":
                fallAction();
                break;
            default:
                System.out.println("unknown action");
                break;
        }
    }

    private void fallAction() {
        playPanel.repaint();
        if (playerGame.moveDown()) {
            lock();
        }
    }

    public void lock() {
        nextPiecePanel.setDrawable(playerGame.getNextPiece());
        nextPiecePanel.repaint();
        scoreLabel.setText("score:" + playerGame.getScore());
        lignesLabel.setText("lignes:" + playerGame.getLignes());
    }


    private void moveAction() {
        playPanel.repaint();
    }

    public MainWindow() {
        super();
        playerGame = new PlayerGame();
        playerGame.getCurrentPiece().initPosition();
        left = false;
        right = false;
        down = false;
        turnleft = false;
        turnright=false;
        Dimension panelSize = new Dimension(100, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setFocusable(true);
        mainPanel = new JPanel(new FlowLayout());
        mainPanel.setBackground(Color.PINK);
        playPanel = new JGraphicsPanel(X_SIZE, Y_SIZE);
        mainPanel.add(playPanel);
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        nextPiecePanel = new JGraphicsPanel(4 * Square.SIZE, 4 * Square.SIZE);

        nextPiecePanel.setDrawable(playerGame.getNextPiece());
        scoreLabel = new JLabel();

        scoreLabel.setMinimumSize(panelSize);
        scoreLabel.setPreferredSize(panelSize);
        scoreLabel.setText("score:0");

        lignesLabel = new JLabel();
        lignesLabel.setMinimumSize(panelSize);
        lignesLabel.setPreferredSize(panelSize);
        lignesLabel.setText("lignes:0");
        infoPanel.add(nextPiecePanel);
        infoPanel.add(scoreLabel);
        infoPanel.add(lignesLabel);
        mainPanel.add(infoPanel);
        setContentPane(mainPanel);
        playPanel.setDrawable(playerGame);

        pack();
        setResizable(false);
        setVisible(true);
        addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        //        System.out.println("key pressed: "+ key);
        switch (key) {
            case KeyEvent.VK_NUMPAD5:
                if (!down) {
                    if (playerGame.moveDown()) {
                        lock();
                    }
                    down = true;
                }


                break;

            case KeyEvent.VK_NUMPAD4:
                if (!left) {
                    playerGame.moveLeft();

                    left = true;
                }
                break;
            case KeyEvent.VK_NUMPAD6:
                if (!right) {
                    playerGame.moveRight();

                    right = true;
                }
                break;
            case KeyEvent.VK_NUMPAD7:
                if (!turnleft) {
                    playerGame.rotateClockwise();

                    turnleft = true;
                }
                break;
            case KeyEvent.VK_NUMPAD9:
                if (!turnright) {
                    playerGame.rotateAntiClockwise();

                    turnright = true;
                }
                break;
            default:
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        //        System.out.println("key pressed: "+ key);
        switch (key) {
            case KeyEvent.VK_NUMPAD5:
                down = false;
                break;

            case KeyEvent.VK_NUMPAD4:
                left = false;
                break;
            case KeyEvent.VK_NUMPAD6:
                right = false;
                break;
            case KeyEvent.VK_NUMPAD7:
                turnleft = false;
                break;
            case KeyEvent.VK_NUMPAD9:
                turnright = false;
                break;
                default:
                break;

        }
    }
}
