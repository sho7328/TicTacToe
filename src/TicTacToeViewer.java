import javax.swing.*;
import java.awt.*;

// Sophie Ho
// 2/4/23
// Front-end of the TicTacToe program
// Runs the pop-up window's visuals and programming.
// Extends JFrame superclass
public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    // Instance variables
    // TicTacToe object t is used to access methods and public instance variables from TicTacToe class
    private TicTacToe t;
    // Image visuals for the X and O symbols
    private Image x;
    private Image o;
    // An array that holds the two images
    private Image[] xando;
    // 2D array for the board/grid
    private Square[][] board;
    // Final variables for the dimensions of the window and board.
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private final int BOARD_HEIGHT = 540;
    private final int BOARD_WIDTH = 540;

    // Constructor for the class
    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        x = new ImageIcon("Resources/X.png").getImage();
        o = new ImageIcon("Resources/O.png").getImage();
        // Add the images to the 2D array
        xando = new Image[2];
        xando[0] = x;
        xando[1] = o;

        // Initialize and set up window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Getter for the X and O images
    public Image[] getImages()
    {
        return xando;
    }

    // This method sets up all the visuals in the window
    public void paint(Graphics g)
    {
        // Paints the screen
        super.paint(g);

        // Draw the labeled axis
        // Set the color to red and set the font
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 30));
        // set the points for the axis numbers
        int wx = ((WINDOW_WIDTH - BOARD_WIDTH) / 2) + ((BOARD_WIDTH / 3) / 2);
        int wy = ((WINDOW_HEIGHT - BOARD_HEIGHT) / 2) - (((BOARD_HEIGHT / 3) / 2) / 3);
        g.drawString("0", wx, wy);
        g.drawString("1", wx += (BOARD_WIDTH / 3), wy);
        g.drawString("2", wx += (BOARD_WIDTH / 3), wy);
        int hx = ((WINDOW_WIDTH - BOARD_WIDTH) / 2) - (((BOARD_WIDTH / 3) / 2) / 2);
        int hy = ((WINDOW_HEIGHT - BOARD_HEIGHT) / 2) + ((BOARD_HEIGHT / 3) / 2);
        g.drawString("0", hx, hy);
        g.drawString("1", hx, hy += (BOARD_HEIGHT / 3));
        g.drawString("2", hx, hy += (BOARD_HEIGHT / 3));

        // Draw the grid
        int x1 = (WINDOW_WIDTH - BOARD_WIDTH) / 2;
        int y1 = (WINDOW_HEIGHT - BOARD_HEIGHT) / 2;
        int dimension = BOARD_HEIGHT / 3;
        board = t.getBoard();
        x1 = (WINDOW_WIDTH - BOARD_WIDTH) / 2;
        y1 = (WINDOW_HEIGHT - BOARD_HEIGHT) / 2;
        g.setColor(Color.BLACK);
        for(int i = 0; i < board.length; i++)
        {
            x1 = (WINDOW_WIDTH - BOARD_WIDTH) / 2;
            for(int j = 0; j < board[0].length; j++)
            {
                board[i][j].draw(g, x1, y1, dimension, this);
                x1 += dimension;
            }
            y1 += dimension;
        }

        int x = WINDOW_WIDTH / 3;
        int y = WINDOW_HEIGHT - ((WINDOW_HEIGHT - BOARD_HEIGHT) / 5);
        // Set the color to black and set the font
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 80));
        // If the game is over:
        if (t.getGameOver())
        {
            // The winner should be displayed at the bottom of the window
            // Display the X message
            if (t.getWinner().equals(t.X_MARKER))
            {
                g.drawString("X WINS!", x, y);
            }
            // Display the O message
            else if (t.getWinner().equals(t.O_MARKER))
            {
                g.drawString("O WINS!", x, y);
            }
            // Display the tie message
            else if (t.getWinner().equals(t.BLANK))
            {
                g.drawString("ITS A TIE!", x - (BOARD_WIDTH / 6), y);
            }
        }
    }
}
