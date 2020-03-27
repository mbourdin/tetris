package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class SQPiece extends Piece {
    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.darkGray;
        colors[1] = Color.red;
    }

    @Override
    public Color[] getStaticColors() {
        return SQPiece.colors;
    }

    @Override
    public void rotateAntiClockwise() {

    }

    @Override
    public void rotateClockwise() {

    }

    public SQPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[2][2];
        squares[0][0] = new Square(this);
        squares[1][0] = new Square(this);
        squares[0][1] = new Square(this);
        squares[1][1] = new Square(this);
    }

}
