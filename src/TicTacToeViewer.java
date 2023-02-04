import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private TicTacToe t;
    private Image x;
    private Image o;
    private Image[] xando;
    private Square[][] board;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private final int BOARD_HEIGHT = 540;
    private final int BOARD_WIDTH = 540;

    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        x = new ImageIcon("Resources/X.png").getImage();
        o = new ImageIcon("Resources/O.png").getImage();
        xando = new Image[2];
        xando[0] = x;
        xando[1] = o;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages()
    {
        return xando;
    }

    public void paint(Graphics g)
    {
        // Draw the labeled axes
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 30));
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

        int x1 = (WINDOW_WIDTH - BOARD_WIDTH) / 2;
        int y1 = (WINDOW_HEIGHT - BOARD_HEIGHT) / 2;
        int dimension = BOARD_HEIGHT / 3;
        if (t.getGameOver())
        {
            // The winner should be displayed at the bottom of the window
            int x = WINDOW_WIDTH / 3;
            int y = WINDOW_HEIGHT - ((WINDOW_HEIGHT - BOARD_HEIGHT) / 5);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.BOLD, 80));
            if (t.getWinner().equals(t.X_MARKER))
            {
                g.drawString("X WINS!", x, y);
            }
            else if(t.getWinner().equals(t.O_MARKER))
            {
                g.drawString("O WINS!", x, y);
            }
            else if (t.getWinner().equals(t.BLANK))
            {
                g.drawString("ITS A TIE!", x - (BOARD_WIDTH / 6), y);
            }

//            // The winning squares should be filled in green
//            g.setColor(Color.GREEN);
//            if(t.DIAGONAL_RIGHT_WIN == -1)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1 + (dimension * i), y1 + (dimension * i), dimension, dimension);
//                }
//            }
//            else if(t.DIAGONAL_LEFT_WIN == -1)
//            {
//                g.fillRect(x1 += (dimension * 2), y1, dimension, dimension);
//                g.fillRect(x1 -= dimension, y1 += dimension, dimension, dimension);
//                g.fillRect(x1 -= dimension, y1 += dimension, dimension, dimension);
//            }
//            else if(t.ROW_WIN == 0)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1 + (dimension * i), y1, dimension, dimension);
//                }
//            }
//            else if(t.ROW_WIN == 1)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1 + (dimension * i), y1 + dimension, dimension, dimension);
//                }
//            }
//            else if (t.ROW_WIN == 2)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1 + (dimension * i), y1 + (dimension * 2), dimension, dimension);
//                }
//            }
//            // Do the same for the columns
//            else if (t.COL_WIN == 0)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1, y1 + (dimension * i), dimension, dimension);
//                }
//            }
//            else if (t.COL_WIN == 1)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1 + dimension, y1 + (dimension * i), dimension, dimension);
//                }
//            }
//            else if (t.COL_WIN == 2)
//            {
//                for(int i = 0; i < 3; i++)
//                {
//                    g.fillRect(x1 + (dimension * 2), y1 + (dimension * i), dimension, dimension);
//                }
//            }
        }

        // Draw the grid
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
    }

}
