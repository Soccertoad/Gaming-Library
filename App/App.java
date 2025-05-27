package App;

import javax.swing.*;

import App.SelectionPage.SelectionPage;
import App.Snake.SnakeGame;

public class App {
    public static void main(String[] args){
        CreateSelectionPage();
        CreateSnake();
    }

    public static void CreateSelectionPage(){
        int boardWidth = 1200;
        int boardHeight = 600;
        JFrame frame = new JFrame("Game Library");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SelectionPage selectionPage = new SelectionPage(boardWidth, boardHeight);
        frame.add(selectionPage);
        frame.pack();
        selectionPage.requestFocus();
    }

    public static void CreateSnake(){
        int boardWidth = 600;
        int boardHeight = boardWidth;
        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
    }
}