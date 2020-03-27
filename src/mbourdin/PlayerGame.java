package mbourdin;

import mbourdin.TetrisPieces.Piece;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;

public class PlayerGame implements Drawable, TetrisMoves {
    private Square[][] grid;
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGTH = 20;
    private Piece currentPiece;
    private Piece nextPiece;
    private int currentLevel;
    private int score;
    private int lignes;

    public int getLignes() {
        return lignes;
    }

    public Square[][] getGrid() {
        return grid;
    }

    public void addScore(int score) {
        this.score += score * score;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void moveLeft() {
        currentPiece.moveLeft();
    }

    @Override
    public void moveRight() {
        currentPiece.moveRight();
    }

    @Override
    public boolean moveDown() {
        if (currentPiece.moveDown()) {
            lock();
            return true;
        }
        return false;
    }

    @Override
    public void rotateClockwise() {
        currentPiece.rotateClockwise();
    }

    @Override
    public void rotateAntiClockwise() {
        currentPiece.rotateAntiClockwise();
    }

    public PlayerGame() {
        grid = new Square[BOARD_HEIGTH][BOARD_HEIGTH];
        int i;
        for (i = 0; i < BOARD_HEIGTH; i++) {
            grid[i] = new Square[BOARD_WIDTH];
        }
        currentPiece = Piece.random(this);
        nextPiece = Piece.random(this);
        currentLevel = 0;
        score = 0;

    }

    @Override
    public String toString() {
        int i;
        int j;
        StringBuilder sb = new StringBuilder();
        for (i = BOARD_HEIGTH - 1; i >= 0; i--) {
            for (j = 0; j < BOARD_WIDTH; j++) {
                if (grid[i][j] == null) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }

            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private void deleteRow(int r) {
        grid[r] = null;
        int i;
        for (i = r; i > 0; i--) {
            grid[i] = grid[i - 1];
        }
        grid[0] = new Square[BOARD_WIDTH];
    }

    public Color getColor(int x, int y) {
        if (grid[x][y] == null) {
            return Color.BLACK;
        }
        return grid[x][y].getColor(currentLevel);
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public Piece getNextPiece() {
        return nextPiece;
    }

    public void changePiece() {
        currentPiece = nextPiece;
        nextPiece = Piece.random(this);
    }

    public void end(boolean force) {

    }

    public void draw(@NotNull Graphics g) {
        int i;
        int j;
        for (i = 0; i < BOARD_HEIGTH; i++) {
            for (j = 0; j < BOARD_WIDTH; j++) {
                getColor(i, j);
                if (grid[i][j] != null) {
                    grid[i][j].draw(g, j, i);
                }
            }
        }
        currentPiece.draw(g);
    }

    public void lock() {
        int i;
        int j;

        for (i = 0; i < currentPiece.getSquares().length; i++) {
            for (j = 0; j < currentPiece.getSquares()[0].length; j++) {
                if (currentPiece.getSquares()[i][j] != null) {   //System.out.println("i="+i+",j="+j+",x="+currentPiece.getX()+",y="+currentPiece.getY());
                    grid[currentPiece.getY() + i][currentPiece.getX() + j] = new Square(currentPiece);

                }
            }
        }
        nextPiece.initPosition();
        changePiece();
        removeLines();
        if(score>20)
        {
            currentLevel=1;
        }
    }

    private void removeLines() {
        int row;
        int column;
        ArrayList<Integer> indexes = new ArrayList<>();
        // IDENTIFIER LES LIGNES A SUPPRIMER

        for (row = 0; row < BOARD_HEIGTH; row++) {
            for (column = 0; column < BOARD_WIDTH; column++) {
                if (grid[row][column] == null) break;
            }
            if (column == BOARD_WIDTH) {
                indexes.add(row);
            }
        }
        //System.out.println(indexes);
        addScore(indexes.size());
        // ICI L'ORDRE EST PRIMORDIAL , SUPPRIMER LES LIGNES PAR ORDRE DECROISSANT
        // MODIFIERAIT L'INDEX DES AUTRES LIGNES APRES  LES AVOIR RECHERCHES!
        for (Integer index : indexes) {
            deleteRow(index);
            lignes++;
        }

    }

}
