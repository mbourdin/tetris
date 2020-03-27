package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class IPiece extends Piece {
    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.yellow;
        colors[1] = Color.darkGray;
    }

    @Override
    public Color[] getStaticColors() {
        return IPiece.colors;
    }

    public IPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[4][3];


        squares[0][1] = new Square(this);
        squares[1][1] = new Square(this);
        squares[2][1] = new Square(this);
        squares[3][1] = new Square(this);
    }
}
