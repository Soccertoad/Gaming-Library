package App.SelectionPage;

import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import App.Snake.SnakeGame;

public class GameBox extends JButton {
    // Variables
    int x;
    int y;

    // Constructor
    public GameBox(int x, int y, String gameName){
        this.x = x;
        this.y = y;
        setText(gameName);

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
        System.out.println("Pacman!");
    }

    private void createCalculator(){
        System.out.println("Calculator!");
    }
}
