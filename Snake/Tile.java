package Snake;

public class Tile {
    // Variables
    public static final int tileSize = SnakeConstants.TILE_SIZE;
    private int x, y; 

    // Constructor
    Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Setters
    public void setX(int x) { this.x = x; };
    public void setY(int y) { this.y = y; };
    // Getters
    public int getXTile() { return x; };
    public int getYTile() { return y; };
    
    public int getXPixel() { return x*tileSize; };
    public int getYPixel() { return y*tileSize; };
}
