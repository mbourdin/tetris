package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class SPiece extends Piece {


    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.cyan;
        colors[1] = Color.red;
    }

    @Override
    public Color[] getStaticColors() {
        return SPiece.colors;
    }

    public SPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[3][2];

        squares[2][0] = new Square(this);
        squares[1][0] = new Square(this);
        squares[1][1] = new Square(this);
        squares[0][1] = new Square(this);
    }
}
