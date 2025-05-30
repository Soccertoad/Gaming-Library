package App.TicTacToe;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        createTicTacToe();
    }    
    
    public static void createTicTacToe(){
        int boardWidth = 600;
        int boardHeight = 600;
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        TicTacToe ticTacToe = new TicTacToe(boardWidth, boardHeight, frame);
        frame.add(ticTacToe);
        frame.pack();
        ticTacToe.requestFocus();
    }
}
