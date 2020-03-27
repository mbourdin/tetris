package mbourdin;

import mbourdin.TetrisPieces.Piece;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Square {
    private Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public static final int SIZE = 25;

    public void draw(@NotNull Graphics g, int x, int y) {
        g.setColor(getColor(piece.getPlayerGame().getCurrentLevel()));
        //g.setColor(Color.red);
        //System.out.println(getColor(piece.getPlayerGame().getCurrentLevel()));
        g.fillRect(x * Square.SIZE + 1, y * Square.SIZE + 1, Square.SIZE - 2, Square.SIZE - 2);

    }

    @Contract(pure = true)
    public Square(Piece piece) {
        this.piece = piece;
    }

    public Color getColor(int currentLevel) {
        if (piece != null) {
            //System.out.println(piece.getColor(currentLevel));
            return piece.getColor(currentLevel);
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public String toString() {
        return "1";
    }

}
