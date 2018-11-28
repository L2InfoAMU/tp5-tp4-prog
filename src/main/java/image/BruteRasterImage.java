package image;
import util.Matrices;
import javafx.scene.paint.Color;

public class BruteRasterImage implements Image{

    Color color;
    int width, height;
    Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        this.colors = colors; }

    public int getWidth(){ return width; }

    public int getHeight(){ return height; }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height; }

    public Color getPixelColor(int x, int y){ return colors[y][x]; }

    public void setPixelColor(Color color, int x, int y){ colors[y][x] = color; }

    private void setPixelsColor(Color color){
        for(int y = 0; y<getHeight(); y++ )
            for(int x = 0; x<getWidth(); x++)
                setPixelColor(color, y, x);
    }

    public void createRepresentation(){
       colors = new Color[getHeight()][getWidth()];
       setPixelsColor(color);
    }

}
