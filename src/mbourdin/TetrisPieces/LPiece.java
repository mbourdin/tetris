package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class LPiece extends Piece {
    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.black;
        colors[1] = Color.PINK;
    }

    @Override
    public Color[] getStaticColors() {
        return LPiece.colors;
    }

    public LPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[3][2];

        squares[2][0] = new Square(this);
        squares[1][0] = new Square(this);
        squares[0][1] = new Square(this);
        squares[0][0] = new Square(this);
    }
}
