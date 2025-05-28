package App.SelectionPage;

// Imports
import java.awt.*;
import javax.swing.*;

import App.Constants.SelectionConstants;
import App.Snake.SnakeGame;

public class SelectionPage extends JPanel {
    // Board
    private int boardWidth;
    private int boardHeight;
    private int blankSpaceW;
    private int blankSpaceH;
    private int gameWidth;
    private int gameHeight;
    private JFrame frame;

    // Constructor
    public SelectionPage(int boardWidth, int boardHeight, JFrame frame){
        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.frame = frame;

        blankSpaceW = boardWidth/30;
        blankSpaceH = boardHeight/30;

        gameWidth = (boardWidth-blankSpaceW*4)/3;
        gameHeight = (boardHeight-blankSpaceH*3)/2;
        
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(SelectionConstants.BACKGROUND_COLOR);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        /* Image Icons */
        ImageIcon snakeIcon = new ImageIcon(SelectionPage.class.getResource("Icons/SnakeIcon.png"));
        ImageIcon pacmanIcon = new ImageIcon(SelectionPage.class.getResource("Icons/PacmanIcon.png"));
        ImageIcon calculatorIcon = new ImageIcon(SelectionPage.class.getResource("Icons/CalculatorIcon.png"));
        ImageIcon game4Icon = new ImageIcon(SelectionPage.class.getResource("Icons/DefaultIcon.png"));
        ImageIcon game5Icon = new ImageIcon(SelectionPage.class.getResource("Icons/DefaultIcon.png"));
        ImageIcon game6Icon = new ImageIcon(SelectionPage.class.getResource("Icons/DefaultIcon.png"));

        /* Game Boxes */
        // Row 1
        GameBox snake = new GameBox(blankSpaceW, blankSpaceH, SnakeGame.name, snakeIcon);
        GameBox pacman = new GameBox(blankSpaceW*2+gameWidth, blankSpaceH, "PacMan", pacmanIcon);
        GameBox calculator = new GameBox(blankSpaceW*3+gameWidth*2, blankSpaceH, "Calculator", calculatorIcon);
        // Row 2
        GameBox game4 = new GameBox(blankSpaceW, blankSpaceH*2 + gameHeight, "Game4", game4Icon);
        GameBox game5 = new GameBox(blankSpaceW*2+gameWidth, blankSpaceH*2 + gameHeight, "Game5", game5Icon);
        GameBox game6 = new GameBox(blankSpaceW*3+gameWidth*2, blankSpaceH*2 + gameHeight, "Game6", game6Icon);

        /* Add Boxes */
        // Row 1
        frame.add(snake);
        frame.add(pacman);
        frame.add(calculator);
        // Row 2
        frame.add(game4);
        frame.add(game5);
        frame.add(game6);

        /*  Draw Boxes */ 
        // Row 1
        snake.setBounds(snake.getXPixel(), snake.getYPixel(), gameWidth, gameHeight);
        pacman.setBounds(pacman.getXPixel(), pacman.getYPixel(), gameWidth, gameHeight);
        calculator.setBounds(calculator.getXPixel(), calculator.getYPixel(), gameWidth, gameHeight);
        // Row 2
        game4.setBounds(game4.getXPixel(), game4.getYPixel(), gameWidth, gameHeight);
        game5.setBounds(game5.getXPixel(), game5.getYPixel(), gameWidth, gameHeight);
        game6.setBounds(game6.getXPixel(), game6.getYPixel(), gameWidth, gameHeight);

        /* Add Image to Boxes */
        // Row 1
        // snake.setIcon(new ImageIcon("icons/SnakeIcon.png"));
    }
}
