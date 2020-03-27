package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class ZPiece extends Piece {
    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.ORANGE;
        colors[1] = Color.red;
    }

    @Override
    public Color[] getStaticColors() {
        return ZPiece.colors;
    }

    public ZPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[3][2];
        squares[0][0] = new Square(this);
        squares[1][0] = new Square(this);
        squares[1][1] = new Square(this);
        squares[2][1] = new Square(this);
    }
}
