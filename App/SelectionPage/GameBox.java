package App.SelectionPage;

import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import App.Constants.PacmanConstants;
import App.Constants.SelectionConstants;
import App.PackMan.PacMan;
import App.Snake.SnakeGame;

public class GameBox extends JButton {
    // Coordinates
    int x;
    int y;

    // Constructor
    public GameBox(int x, int y, String gameName, ImageIcon gameIcon){
        // Coordinates 
        this.x = x;
        this.y = y;

        // Set icon and color
        setIcon(gameIcon);
        setBackground(SelectionConstants.GAME_BOX_COLOR);
        setBorder(BorderFactory.createLineBorder(SelectionConstants.GAME_BORDER_COLOR, 5));

        // On click, launch the specified game
        addMouseListener(new MouseListener(){
            @Override public void mouseClicked(java.awt.event.MouseEvent e) {
                switch (gameName) {
                    case SnakeGame.name:
                        createSnake();
                        break;
                    case "PacMan":
                        createPacman();
                        break;
                    case "Calculator":
                        createCalculator();
                        break;
                    default:
                        System.out.println("ERROR; invalid game name");
                        break;
                }
            }
            // Don't need
            @Override public void mousePressed(java.awt.event.MouseEvent e) {}
            @Override public void mouseReleased(java.awt.event.MouseEvent e) {}
            @Override public void mouseEntered(java.awt.event.MouseEvent e) {}
            @Override public void mouseExited(java.awt.event.MouseEvent e) {}
        });
    }

    // Getters
    public int getXPixel() {return x;}
    public int getYPixel() {return y;}

    // Setters
    public void setXPixel(int x) {this.x = x;}
    public void setYPixel(int y) {this.y = y;}

    // Create games
    private void createSnake(){
        int boardWidth = 600;
        int boardHeight = 600;
        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocusInWindow();
    }

    private void createPacman(){
        int rowCount = PacmanConstants.ROW_COUNT;
        int columCount = PacmanConstants.COLUMN_COUNT;
        int tileSize = PacmanConstants.TILE_SIZE;
        int boardWidth = columCount * tileSize;
        int boardHeight = rowCount * tileSize;

        JFrame frame = new JFrame("Pac Man");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        PacMan pacmanGame = new PacMan();
        frame.add(pacmanGame);
        frame.pack();
        pacmanGame.requestFocus();
        frame.setVisible(true);
    }

    private void createCalculator(){
        System.out.println("Calculator!");
    }
}
