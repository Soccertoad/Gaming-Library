package App.SelectionPage;

public class GameBox {
    // Variables
    int x;
    int y;

    // Constructor
    public GameBox(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getXPixel() {return x;}
    public int getYPixel() {return y;}

    // Setters
    public void setXPixel(int x) {this.x = x;}
    public void setYPixel(int y) {this.y = y;}
}
