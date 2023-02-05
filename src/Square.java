import javax.swing.*;
import java.awt.*;
/**
 * SOPHIE HO
 * 2/4/23
 *
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToe t;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    // This method works in cooperation with the TicTacToeViewer paint method
    public void draw(Graphics g, int x, int y, int sideLength, TicTacToeViewer t)
    {
        // Set the square color
        g.setColor(Color.BLACK);
        // Draw a single square at (x,y)
        g.drawRect(x, y, sideLength, sideLength);
        // If the square is part of a winning sequence, fill it green.
        if(this.isWinningSquare)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, sideLength, sideLength);
        }
        // If it's X's turn, draw the X at the user's inputted place on the board.
        if(marker.equals(TicTacToe.X_MARKER))
        {
            g.drawImage(t.getImages()[0], x, y, sideLength, sideLength, t);
        }
        // If it's O's turn, draw the O at the user's inputted place on the board.
        if(marker.equals(TicTacToe.O_MARKER))
        {
            g.drawImage(t.getImages()[1], x, y, sideLength, sideLength, t);
        }
    }
}
