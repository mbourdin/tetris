package mbourdin.TetrisPieces;

import mbourdin.PlayerGame;
import mbourdin.Square;

import java.awt.*;

public class JPiece extends Piece {
    private static Color[] colors;

    static {
        colors = new Color[2];
        colors[0] = Color.green;
        colors[1] = Color.gray;
    }

    @Override
    public Color[] getStaticColors() {
        return JPiece.colors;
    }

    public JPiece(PlayerGame playerGame) {
        super(playerGame);
        squares = new Square[3][2];

        squares[2][0] = new Square(this);
        squares[1][0] = new Square(this);
        squares[2][1] = new Square(this);
        squares[0][0] = new Square(this);
    }
}
