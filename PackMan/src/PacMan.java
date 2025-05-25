import java.awt.*;

import javax.swing.*;

public class PacMan extends JPanel{
    private int rowCount = 21;
    private int columCount = 19;
    private int tileSize = 32;
    private int boardWidth = columCount * tileSize;
    private int boardHeight = rowCount * tileSize;

    //Image declarations
    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeGhostImage;
    private Image pinkGhostImage;
    private Image redGhostImage;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;

    // Constructor 
    PacMan(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

        // Loads Images
        wallImage = new ImageIcon(getClass().getResource("./Images/wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("./Images/blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./Images/orangeGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./Images/pinkGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./Images/redGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("./Images/pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("./Images/pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./Images/pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("./Images/pacmanRight.png")).getImage();


    }

}
