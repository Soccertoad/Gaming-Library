package Snake;

public class Tile {
    // Variables
    static int tileSize = 25;
    private int x, y; 

    // Constructor
    Tile(int x, int y) {
        this.x = x * tileSize;
        this.y = y * tileSize;
    }

    // Setters
    public void setX(int x) { this.x = x*tileSize; };
    public void setY(int y) { this.y = y*tileSize; };
    // Getters
    public int getX() { return x; };
    public int getY() { return y; };
}
