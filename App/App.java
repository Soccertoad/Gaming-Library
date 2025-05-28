package App;

import java.awt.FlowLayout;
import javax.swing.*;

import App.SelectionPage.SelectionPage;

public class App {
    public static void main(String[] args){
        int boardWidth = 1200;
        int boardHeight = 600;
        JFrame frame = new JFrame("Game Library");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        frame.setLayout(flowLayout);

        SelectionPage selectionPage = new SelectionPage(boardWidth, boardHeight, frame);
        frame.add(selectionPage);
        frame.pack();
        selectionPage.requestFocus();
    }
}