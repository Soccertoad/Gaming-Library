package App.TicTacToe;

import java.awt.Dimension;
import java.awt.Graphics;

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
    JButton[][] grid;
    int tileCount = TicTacToeConstants.TILE_COUNT;
    
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
                JButton tile = new JButton();
                grid[r][c] = tile;
                this.add(tile);

                // Color and size
                tile.setBounds(boardWidth/tileCount*r, boardHeight/tileCount*c, boardWidth/tileCount, boardHeight/tileCount);
                if (alternate) { tile.setBackground(TicTacToeConstants.BOX_COLOR); }
                else { tile.setBackground(TicTacToeConstants.BACKGROUND_COLOR); }
                alternate = !alternate;
            }
            if (tileCount % 2 == 0) { alternate = !alternate; }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}
