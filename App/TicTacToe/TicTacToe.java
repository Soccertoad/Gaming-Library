package App.TicTacToe;

import java.awt.Dimension;
import java.awt.Graphics;

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
    
    public TicTacToe(int boardWidth, int boardHeight, JFrame frame){
        // Frame
        this.frame = frame;

        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(TicTacToeConstants.BACKGROUND_COLOR);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    }
}
