package App.SelectionPage;

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import  App.Constants.SelectionConstants;

public class SelectionPage extends JPanel {
    // Board
    private int boardWidth;
    private int boardHeight;

    // Constructor
    public SelectionPage(int boardWidth, int boardHeight){
        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(SelectionConstants.BACKGROUND_COLOR);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){

    }
}
