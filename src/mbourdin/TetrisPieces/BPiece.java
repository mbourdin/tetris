package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class BPiece extends Piece {
    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.blue;
        colors[1] = Color.lightGray;
    }

    @Override
    public Color[] getStaticColors() {
        return BPiece.colors;
    }

    public BPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[3][2];

        squares[2][0] = new Square(this);
        squares[1][0] = new Square(this);
        squares[1][1] = new Square(this);
        squares[0][0] = new Square(this);
    }
}
