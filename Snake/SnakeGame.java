package Snake;

// Imports
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel {
    // Tiles to create grid
    private class Tile {
        static int tileSize = 25;
        int x, y; 
        Tile(int x, int y) {
            this.x = x * tileSize;
            this.y = y * tileSize;
        }
        public void setX(int x) {this.x = x*tileSize;};
        public void setY(int y) {this.y = y*tileSize;};
    }

    // Variables
    int boardWidth;
    int boardHeight;
    int tileSize = Tile.tileSize;

    // Tiles
    Tile snakeHead;
    Tile food;

    // Constructor
    public SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.getHSBColor(0.8f, 0.05f, 0.9f));
        
        // Tiles
        snakeHead = new Tile(5, 5);
        food = new Tile(0, 0);
        placeFood();
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
        g.fillOval(food.x, food.y, tileSize, tileSize);

        // Snake
        g.setColor(Color.getHSBColor(0.3f, 0.5f, 0.3f));
        g.fillOval(snakeHead.x, snakeHead.y, tileSize, tileSize);
    }

    public void placeFood() {
        food.setX((int) ((Math.random() * boardWidth/tileSize) + 1));
        food.setY((int) ((Math.random() * boardHeight/tileSize) + 1));
    }
}
