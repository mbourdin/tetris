package mbourdin.TetrisPieces;


import mbourdin.Drawable;
import mbourdin.PlayerGame;
import mbourdin.Square;
import mbourdin.TetrisMoves;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


import java.awt.*;
import java.util.Random;

public abstract class Piece implements Drawable, TetrisMoves {
    protected int x;
    protected int y;
    protected Square[][] squares;
    protected Square[][] tmpSquares;
    protected PlayerGame playerGame;

    public Square[][] getSquares() {
        return squares;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PlayerGame getPlayerGame() {
        return playerGame;
    }

    public void initPosition() {
        x = 4;
        y = 0;
    }

    public void draw(@NotNull Graphics g) {
        int i;
        int j;
        g.setColor(getColor(0));

        for (i = 0; i < squares.length; i++) {
            for (j = 0; j < squares[0].length; j++) {
                if (squares[i][j] != null) {
                    squares[i][j].draw(g, x + j, y + i);
                }
            }
        }
    }

    private boolean intersects(PlayerGame playerGame) {
        if (playerGame == null) {
            return false;
        }
        int i;
        int j;
        for (i = 0; i < squares.length; i++) {
            for (j = 0; j < squares[0].length; j++) {
                boolean condition;
                try {
                    condition = (squares[i][j] != null && playerGame.getGrid()[y + i][x + j] != null);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //System.out.println("out of bounds :" +(x+i)+" , "+(y+j));
                    return true;
                }

                if (condition) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moveLeft() {
        x--;
        if (intersects(playerGame)) {
            x++;
        }

    }

    public void moveRight() {
        x++;
        if (intersects(playerGame)) {
            x--;
        }

    }

    public boolean moveDown() {
        y++;
        if (intersects(playerGame)) {
            y--;
            return true;
        }
        return false;
    }

    private static Random random = new Random();

    @Contract(pure = true)
    public Piece(PlayerGame playerGame) {
        this.playerGame = playerGame;
        x = 0;
        y = 0;
    }

    public static Piece random(PlayerGame playerGame) {
        int choice = random.nextInt(7);
        switch (choice) {
            case 0:
                return new BPiece(playerGame);
//                break;
            case 1:
                return new IPiece(playerGame);
//                break;
            case 2:
                return new JPiece(playerGame);
//                break;
            case 3:
                return new LPiece(playerGame);
//                break;
            case 4:
                return new SQPiece(playerGame);
//                break;
            case 5:
                return new SPiece(playerGame);
//                break;
            case 6:
                return new ZPiece(playerGame);
//                break;
            default:
                return null;
        }
    }

    public abstract Color[] getStaticColors();

    public void rotateClockwise() {
        int i;
        int j;
        tmpSquares = new Square[squares[0].length][squares.length];
        for (i = 0; i < squares[0].length; i++) {
            for (j = 0; j < squares.length; j++) {
                //System.out.println(i+","+j);
                tmpSquares[squares[0].length - i - 1][j] = squares[j][i];
            }
        }
        squares = tmpSquares;
        if (intersects(playerGame)) {
            rotateAntiClockwise();
        }
    }

    public void rotateAntiClockwise() {
        int i;
        int j;
        tmpSquares = new Square[squares[0].length][squares.length];
        for (i = 0; i < squares[0].length; i++) {
            for (j = 0; j < squares.length; j++) {
                //System.out.println(i+","+j);
                tmpSquares[i][squares.length - j - 1] = squares[j][i];
            }
        }
        squares = tmpSquares;
        if (intersects(playerGame)) {
            rotateClockwise();
        }

    }

    public Color getColor(int currentLevel) {   //System.out.println("level="+currentLevel);
        return this.getStaticColors()[currentLevel % this.getStaticColors().length];
    }

    public String toString() {
        int i;
        int j;
        StringBuilder sb = new StringBuilder();
        for (i = squares.length - 1; i >= 0; i--) {
            for (j = 0; j < squares[0].length; j++) {   //System.out.println("i="+i+",j="+j);
                if (squares[i][j] == null) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
