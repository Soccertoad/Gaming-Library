package Snake;

// Imports
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    // Board
    int boardWidth;
    int boardHeight;
    int tileSize = Tile.tileSize;

    // Snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;

    // Food
    Tile food;

    // Game Logic
    Timer gameLoop;
    int velocityX;
    int velocityY;

    // Constructor
    public SnakeGame(int boardWidth, int boardHeight){
        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.getHSBColor(0.8f, 0.05f, 0.9f));
        
        // Snake
        snakeHead = new Tile(5, 5);
        snakeBody = new ArrayList<Tile>();

        // Food
        food = new Tile(0, 0);
        placeFood();

        // Game Logic
        addKeyListener(this);
        setFocusable(true);
        gameLoop = new Timer(100, this);
        gameLoop.start();
        velocityX = 0;
        velocityY = 0;
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

        // Snake Head
        g.setColor(Color.getHSBColor(0.3f, 0.5f, 0.3f));
        g.fillOval(snakeHead.getX(), snakeHead.getY(), tileSize, tileSize);

        // Snake Body
        for (int i = 0; i<snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            g.fillOval(snakePart.getX(), snakePart.getY(), tileSize, tileSize);
        }
    }

    public void placeFood() {
        food.setX((int) ((Math.random() * boardWidth/tileSize) + 1));
        food.setY((int) ((Math.random() * boardHeight/tileSize) + 1));
    }

    public boolean isColliding(Tile t1, Tile t2){
        return (t1.getX() == t2.getX()) && (t1.getY() == t2.getY());
    }

    public void moveSnake(){
        // Eat food
        if (isColliding(snakeHead, food)){
            snakeBody.add(new Tile(food.getX()/tileSize, food.getY()/tileSize));
            placeFood();
        }

        // Snake Body
        for (int i = snakeBody.size()-1; i>=0; i--){
            Tile snakePart = snakeBody.get(i);
            if (i == 0){
                snakePart.setX(snakeHead.getX()/tileSize);
                snakePart.setY(snakeHead.getY()/tileSize);
            }
            else {
                Tile prevSnakePart = snakeBody.get(i-1);
                snakePart.setX(prevSnakePart.getX()/tileSize);
                snakePart.setY(prevSnakePart.getY()/tileSize);
            }
        }

        // Snake Head
        snakeHead.setX(snakeHead.getX()/tileSize + velocityX);
        snakeHead.setY(snakeHead.getY()/tileSize + velocityY);
    }

    
    /* Implement Methods */

    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Up
        if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) && velocityY != 1) {
            velocityY = -1;
            velocityX = 0;
        }
        // Down
        else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) && velocityY != -1) {
            velocityY = 1;
            velocityX = 0;
        }
        // Left
        else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) && velocityX != 1) {
            velocityY = 0;
            velocityX = -1;
        }
        // Right
        else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) && velocityX != -1) {
            velocityY = 0;
            velocityX = 1;
        }
    }

    // Don't need these
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
