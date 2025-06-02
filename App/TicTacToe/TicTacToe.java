package App.TicTacToe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
// Imports
import javax.swing.JFrame;
import javax.swing.JPanel;

import App.Constants.TicTacToeConstants;

public class TicTacToe extends JPanel {
    // Frame
    private JFrame frame;
    
    // Board
    private int boardWidth;
    private int boardHeight;

    // Grid
    private JButton[][] grid;
    private int tileCount = TicTacToeConstants.TILE_COUNT;

    // Logic
    private String x = "X";
    private String o = "O";
    private String player = x;
    private final String TIE = "tie";

    public TicTacToe(int boardWidth, int boardHeight, JFrame frame){
        // Frame
        this.frame = frame;

        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(TicTacToeConstants.BACKGROUND_COLOR);
        setLayout(null);

        // Grid
        grid = new JButton[tileCount][tileCount];

        boolean alternate = false;
        for (int r=0; r<tileCount; r++){
            for (int c=0; c<tileCount; c++){
                // Create piece
                Tile tile = new Tile(r, c);
                grid[r][c] = tile;
                this.add(tile);

                // Color and size
                tile.setBounds(boardWidth/tileCount*r, boardHeight/tileCount*c, boardWidth/tileCount, boardHeight/tileCount);
                if (alternate) { tile.setBackground(TicTacToeConstants.BOX_COLOR); }
                else { tile.setBackground(TicTacToeConstants.BACKGROUND_COLOR); }
                alternate = !alternate;
                tile.setForeground(TicTacToeConstants.BORDER_COLOR);
                tile.setFont(new Font("Arial", Font.BOLD, 50));

                // Add function
                tile.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (tile.isEnabled()){ select(tile); }
                    }
                    // Don't need
                    @Override public void mousePressed(MouseEvent e) {}
                    @Override public void mouseReleased(MouseEvent e) {}
                    @Override public void mouseEntered(MouseEvent e) {}
                    @Override public void mouseExited(MouseEvent e) {}
                });
            }
            if (tileCount % 2 == 0) { alternate = !alternate; }
        }
    }

    public void select(Tile tile){
        // If tile is empty
        if ((tile.getText() != x) && (tile.getText() != o)){
            tile.setText(player);

            // Check if there is a winner
            String winner = checkIfWin(tile);

            if (winner == player || winner == TIE){
                for (int r=0; r<tileCount; r++){
                    for (int c=0; c<tileCount; c++){
                        grid[r][c].setEnabled(false);
                    }
                }
                System.out.println("Winner: "+winner);
                return;
            }

            // Change player
            if (player == x) { player = o; }
            else { player = x; }
        }
    }

    public String checkIfWin(Tile tile){
        boolean win;

        // Vertical
        win = true;
        for (int c = 0; c<tileCount; c++){
            if (grid[tile.getRow()][c].getText() != tile.getText()){
                win = false;
                break;
            }
        }
        if (win) { return player; };

        // Horizontal
        win = true;
        for (int r = 0; r<tileCount; r++){
            if (grid[r][tile.getCol()].getText() != tile.getText()){
                win = false;
                break;
            }
        }
        if (win) { return player; };

        // Left Diagonal
        win = true;
        for (int r = 0, c = 0; r<tileCount && c<tileCount; r++, c++){
            if (grid[r][c].getText() != tile.getText()){
                win = false;
                break;
            }
        }
        if (win) { return player; };

        // Right Diagonal
        win = true;
        for (int r = tileCount-1, c = 0; r >= 0 && c < tileCount; r--, c++){
            if (grid[r][c].getText() != tile.getText()){
                win = false;
                break;
            }
        }
        if (win) { return player; };

        // If board is filled and no winner
        String board = "";
        for (int r=0; r<tileCount; r++){
            for (int c=0; c<tileCount; c++){
                board += grid[r][c].getText();
            }
        }
        if (board.length() == tileCount*tileCount){ return TIE; }

        // Game is not over
        return "";
    }
}
