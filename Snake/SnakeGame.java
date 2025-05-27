package Snake;

// Imports
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import Snake.SnakeConstants.ColorConstants;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    // Board
    private int boardWidth;
    private int boardHeight;
    private int tileSize = Tile.tileSize;

    // Snake
    private Tile snakeHead;
    private ArrayList<Tile> snakeBody;

    // Food
    private Tile food;

    // Game Logic
    private Timer gameLoop;
    private int loopDelay = 110;
    private int velocityX;
    private int velocityY;
    private boolean canIncreaseDifficuly = true;
    private boolean gameOver = false;

    // Constructor
    public SnakeGame(int boardWidth, int boardHeight){
        // Board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(ColorConstants.BACKGROUND_COLOR);
        
        // Snake
        snakeHead = new Tile(boardWidth/tileSize/2, boardHeight/tileSize/2);
        snakeBody = new ArrayList<Tile>();
        snakeBody.add(new Tile(snakeHead.getX()/tileSize-tileSize, snakeHead.getY()/tileSize));

        // Food
        food = new Tile(0, 0);
        placeFood();

        // Game Logic
        addKeyListener(this);
        setFocusable(true);
        gameLoop = new Timer(loopDelay, this);
        gameLoop.start();
        velocityX = 0;
        velocityY = 0;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        /*  Checkerboard grid */
        int offset = 0;
        for (int i=0; i < boardWidth; i+= tileSize*2){
            for (int j=0; j < boardHeight; j+= tileSize){
                g.setColor(ColorConstants.BACKGROUND_CHECKER_COLOR);
                g.fillRect(i+offset, j, tileSize, tileSize);
                
                if (offset == 25) {offset = 0;}
                else {offset = 25;}
            }
        }

        /*  Snake Body */
        g.setColor(ColorConstants.SNAKE_BODY_COLOR);
        for (int i = 0; i<snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            // Draws rounded tail
            if (i == snakeBody.size()-1){
                // If there is more than one body part, it compares to the prev body part. Else the head 
                Tile comparePart = snakeHead;
                if (i != 0){
                    comparePart = snakeBody.get(i-1);
                }
                // up
                if (isColliding(new Tile(snakePart.getX()/tileSize, snakePart.getY()/tileSize-1), comparePart)) {
                    g.fillRect(snakePart.getX(), snakePart.getY(), tileSize, tileSize/2);
                }
                // down
                else if (isColliding(new Tile(snakePart.getX()/tileSize, snakePart.getY()/tileSize+1), comparePart)) {
                    g.fillRect(snakePart.getX(), snakePart.getY()+tileSize/2+1, tileSize, tileSize/2);
                } 
                // left
                else if (isColliding(new Tile(snakePart.getX()/tileSize-1, snakePart.getY()/tileSize), comparePart)) {
                    g.fillRect(snakePart.getX(), snakePart.getY(), tileSize/2, tileSize);
                }
                // right
                else if (isColliding(new Tile(snakePart.getX()/tileSize+1, snakePart.getY()/tileSize), comparePart)) {
                    g.fillRect(snakePart.getX()+tileSize/2+1, snakePart.getY(), tileSize/2, tileSize);
                }
                g.fillOval(snakePart.getX(), snakePart.getY(), tileSize, tileSize);                
            }
            // Draws cube body
            else {            
                g.fillRect(snakePart.getX(), snakePart.getY(), tileSize, tileSize);
            }
        }
        
        /* Food */
        g.setColor(ColorConstants.FOOD_BASE_COLOR);
        g.fillOval(food.getX()+2, food.getY()+5, tileSize-5, tileSize-6);
        g.setColor(ColorConstants.FOOD_STEM_COLOR);
        g.fillRoundRect(food.getX()+tileSize/2-1, food.getY()+1, 4, 6, 50, 50);
        g.setColor(ColorConstants.FOOD_LEAF_COLOR);
        g.fillArc(food.getX()+tileSize/2, food.getY()+1, 8, 7, 240, 180);

        /*  Snake Head */
        g.setColor(ColorConstants.SNAKE_BODY_COLOR);
        // Draws rounded head + eyes
        boolean eyesVertical = false;
        g.fillOval(snakeHead.getX(), snakeHead.getY(), tileSize, tileSize);                
        // down
        if (isColliding(new Tile(snakeHead.getX()/tileSize, snakeHead.getY()/tileSize-1), snakeBody.get(0))) {
            g.fillRect(snakeHead.getX(), snakeHead.getY(), tileSize, tileSize/2);
            eyesVertical = true;
            // Mouth
            g.setColor(ColorConstants.SNAKE_MOUTH_COLOR);
            g.fillArc(snakeHead.getX()+tileSize/2-3, snakeHead.getY()+tileSize-7-3, 7, 7, 180, 180);
        }
        // up
        else if (isColliding(new Tile(snakeHead.getX()/tileSize, snakeHead.getY()/tileSize+1), snakeBody.get(0))) {
            g.fillRect(snakeHead.getX(), snakeHead.getY()+tileSize/2+1, tileSize, tileSize/2);
            eyesVertical = true;
            // Mouth
            g.setColor(ColorConstants.SNAKE_MOUTH_COLOR);
            g.fillArc(snakeHead.getX()+tileSize/2-3, snakeHead.getY()+3, 7, 7, 0, 180);
        } 
        // right
        else if (isColliding(new Tile(snakeHead.getX()/tileSize-1, snakeHead.getY()/tileSize), snakeBody.get(0))) {
            g.fillRect(snakeHead.getX(), snakeHead.getY(), tileSize/2, tileSize);
            eyesVertical = false;
            // Mouth
            g.setColor(ColorConstants.SNAKE_MOUTH_COLOR);
            g.fillArc(snakeHead.getX()+tileSize-7-3, snakeHead.getY()+tileSize/2-3, 7, 7, 270, 180);
        }
        // left
        else if (isColliding(new Tile(snakeHead.getX()/tileSize+1, snakeHead.getY()/tileSize), snakeBody.get(0))) {
            g.fillRect(snakeHead.getX()+tileSize/2+1, snakeHead.getY(), tileSize/2, tileSize);
            eyesVertical = false;
            // Mouth
            g.setColor(ColorConstants.SNAKE_MOUTH_COLOR);
            g.fillArc(snakeHead.getX()+3, snakeHead.getY()+tileSize/2-3, 7, 7, 90, 180);
        }
        // Draw eyes
        g.setColor(ColorConstants.SNAKE_EYES_COLOR);
        if (eyesVertical){
            g.fillOval(snakeHead.getX()+1, snakeHead.getY()+10, 7, 7);
            g.fillOval(snakeHead.getX()+tileSize-10, snakeHead.getY()+10, 7, 7);
        }
        else {
            g.fillOval(snakeHead.getX()+10, snakeHead.getY()+1, 7, 7);
            g.fillOval(snakeHead.getX()+10, snakeHead.getY()+tileSize-10, 7, 7);
        }

        /*  Text  */
        // Score
        Font scoreFont = new Font("Arial", Font.PLAIN, 15);
        g.setFont(scoreFont);
        g.setColor(ColorConstants.TEXT_SCORE_COLOR);
        String scoreText = "Score: "+(snakeBody.size()-1);
        g.drawString(scoreText, tileSize, tileSize);

        // Game Over
        if (gameOver) {
            Font overFont = new Font("Arial", Font.BOLD, 30);
            g.setFont(overFont);
            g.setColor(ColorConstants.TEXT_GAME_OVER_COLOR);
            FontMetrics metrics = g.getFontMetrics(overFont);
            String gameOverText = "GAME OVER";
            String endScoreText = "Score: "+(snakeBody.size()-1);
            String restartText = "Press Space to restart";
            g.drawString(gameOverText, (boardWidth-metrics.stringWidth(gameOverText))/2, boardHeight/2 - metrics.getHeight());
            g.drawString(endScoreText, (boardWidth-metrics.stringWidth(endScoreText))/2, boardHeight/2);
            g.drawString(restartText, (boardWidth-metrics.stringWidth(restartText))/2, boardHeight/2 + metrics.getHeight());

        }

        // Speed increased
        if (canIncreaseDifficuly == false){
            Font difficultyFont = new Font("Arial", Font.BOLD, 20);
            g.setFont(difficultyFont);
            g.setColor(ColorConstants.TEXT_SPEED_COLOR);
            FontMetrics metrics = g.getFontMetrics(difficultyFont);
            String overText = "Speed Increased";
            g.drawString(overText, (boardWidth-metrics.stringWidth(overText))/2, tileSize);
        }
    }

    private void placeFood() {
        food.setX((int) (Math.random() * boardWidth/tileSize));
        food.setY((int) (Math.random() * boardHeight/tileSize));
    }

    private boolean isColliding(Tile t1, Tile t2){
        return (t1.getX() == t2.getX()) && (t1.getY() == t2.getY());
    }

    private void moveSnake(){
        // Eat food
        if (isColliding(snakeHead, food)){
            snakeBody.add(new Tile(food.getX()/tileSize, food.getY()/tileSize));
            placeFood();
        }

        // Snake Body
        for (int i = snakeBody.size()-1; i>=0; i--){
            if (velocityX != 0 || velocityY != 0){
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
        }

        // Snake Head
        snakeHead.setX(snakeHead.getX()/tileSize + velocityX);
        snakeHead.setY(snakeHead.getY()/tileSize + velocityY);

        /* Game Over Conditions X_X */
        // Snake head touches body part
        for (int i=0; i < snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            if (isColliding(snakePart, snakeHead)){
                gameOver = true;
            }
        }

        // Snake head touches walls
        if (snakeHead.getX() < 0 || snakeHead.getX() > boardWidth ||
        snakeHead.getY() < 0 || snakeHead.getY() > boardHeight) {
            gameOver = true;
        }

    }

    private void restartGame(){
        // Resets conditions to default values
        gameOver = false;
        loopDelay = 110;
        snakeHead.setX(boardWidth/tileSize/2);
        snakeHead.setY(boardHeight/tileSize/2);
        snakeBody.clear();
        snakeBody.add(new Tile(snakeHead.getX()/tileSize-tileSize, snakeHead.getY()/tileSize));
        placeFood();
        velocityX = 0;
        velocityY = 0;

        // Starts game loop
        gameLoop = new Timer(loopDelay, this);
        gameLoop.start();
    }

    /* Implement Methods */
    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        repaint();
        // If game is over then stop the loop
        if (gameOver) {
            gameLoop.stop(); 
            return;
        }
        // Every 10 points make speed go faster by having less delay
        if ((snakeBody.size()-1) % 10 == 0 && (snakeBody.size()-1) != 0 && canIncreaseDifficuly && loopDelay > 20){
            // Subtract 10 from delay and restart loop
            loopDelay -= 10;
            gameLoop.stop();
            gameLoop = new Timer(loopDelay, this);
            gameLoop.start();
            // Difficulty is not able to increase until size increases
            canIncreaseDifficuly = false;
        }
        // When the next food has been eaten, difficulty is able to increase again
        else if ((snakeBody.size()-2) %10 == 0){
            canIncreaseDifficuly = true;
        }
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

        // To restart game
        if (e.getKeyCode() == KeyEvent.VK_SPACE && gameOver){
            restartGame();
        }
    }

    // Don't need these
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
