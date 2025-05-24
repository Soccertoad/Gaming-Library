package Snake;

// Imports
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
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
    }

    // Variables
    int boardWidth;
    int boardHeight;
    int tileSize = Tile.tileSize;

    Tile snakeHead = new Tile(5, 5);

    // Constructor
    public SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.getHSBColor(0.8f, 0.05f, 0.9f));
        
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

        // Snake
        g.setColor(Color.getHSBColor(0.3f, 0.5f, 0.3f));
        g.fillOval(snakeHead.x, snakeHead.y, tileSize, tileSize);
    }
}
