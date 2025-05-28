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
    private int blankSpaceW;
    private int blankSpaceH;

    // Constructor
    public SelectionPage(int boardWidth, int boardHeight){
        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        blankSpaceW = boardWidth/30;
        blankSpaceH = boardHeight/30;
        
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(SelectionConstants.BACKGROUND_COLOR);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        // Width+height
        int gameWidth = (boardWidth-blankSpaceW*4)/3;
        int gameHeight = (boardHeight-blankSpaceH*3)/2;

        /* Game Boxes */
        // Row 1
        GameBox snake = new GameBox(blankSpaceW, blankSpaceH);
        GameBox pacman = new GameBox(blankSpaceW*2+gameWidth, blankSpaceH);
        GameBox calculator = new GameBox(blankSpaceW*3+gameWidth*2, blankSpaceH);
        // Row 2
        GameBox game4 = new GameBox(blankSpaceW, blankSpaceH*2 + gameHeight);
        GameBox game5 = new GameBox(blankSpaceW*2+gameWidth, blankSpaceH*2 + gameHeight);
        GameBox game6 = new GameBox(blankSpaceW*3+gameWidth*2, blankSpaceH*2 + gameHeight);

        /*  Draw Boxes */ 
        g.setColor(SelectionConstants.GAME_BOX_COLOR);
        // Row 1
        g.fillRect(snake.getXPixel(), snake.getYPixel(), gameWidth, gameHeight);
        g.fillRect(pacman.getXPixel(), pacman.getYPixel(), gameWidth, gameHeight);
        g.fillRect(calculator.getXPixel(), calculator.getYPixel(), gameWidth, gameHeight);
        // Row 2
        g.fillRect(game4.getXPixel(), game4.getYPixel(), gameWidth, gameHeight);
        g.fillRect(game5.getXPixel(), game5.getYPixel(), gameWidth, gameHeight);
        g.fillRect(game6.getXPixel(), game6.getYPixel(), gameWidth, gameHeight);
    }
}
