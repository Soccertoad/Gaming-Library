import java.awt.*;

import javax.swing.*;

public class PacMan extends JPanel{
    private int rowCount = 21;
    private int columCount = 19;
    private int tileSize = 32;
    private int boardWidth = columCount * tileSize;
    private int boardHeight = rowCount * tileSize;

    PacMan(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
    }
}
