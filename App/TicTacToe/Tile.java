package App.TicTacToe;

import javax.swing.JButton;

public class Tile extends JButton {
    // Variables
    private int row, col;

    // Constructor
    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getters and setters
    public int getRow() { return row; }
    public int getCol() { return col; }

    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
}
