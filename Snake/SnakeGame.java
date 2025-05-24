package Snake;

// Imports
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener{
    // Board
    int boardWidth;
    int boardHeight;
    int tileSize = Tile.tileSize;

    // Tiles
    Tile snakeHead;
    Tile food;

    // Game Logic
    Timer gameLoop;

    // Constructor
    public SnakeGame(int boardWidth, int boardHeight){
        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.getHSBColor(0.8f, 0.05f, 0.9f));
        
        // Tiles
        snakeHead = new Tile(5, 5);
        food = new Tile(0, 0);
        placeFood();

        // Game Logic
        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        // Checkerboard grid
        int offset = 0;
        for (int i=0; i < boardWidth; i+= tileSize*2){
            for (int j=0; j < boardHeight; j+= tileSize){
                g.setColor(Color.getHSBColor(0.8f, 0.05f, 0.8f));
                g.fillRect(i+offset, j, tileSize, tileSize);
                
                if (offset == 25) {offset = 0;}
                else {offset = 25;}
            }
        }

        // Food 
        g.setColor(Color.getHSBColor(0f, 0.8f, 0.7f));
        g.fillOval(food.getX(), food.getY(), tileSize, tileSize);

        // Snake
        g.setColor(Color.getHSBColor(0.3f, 0.5f, 0.3f));
        g.fillOval(snakeHead.getX(), snakeHead.getY(), tileSize, tileSize);
    }

    public void placeFood() {
        food.setX((int) ((Math.random() * boardWidth/tileSize) + 1));
        food.setY((int) ((Math.random() * boardHeight/tileSize) + 1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
