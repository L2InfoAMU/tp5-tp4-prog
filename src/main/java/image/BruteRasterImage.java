package image;
import util.Matrices;
import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage implements Image{

    Color color;
    Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] colors){
        super(colors);
    }


    public Color getPixelColor(int x, int y){ return colors[x][y]; }

    public void setPixelColor(Color color, int x, int y){ colors[x][y] = color; }

    public void createRepresentation(){
       colors = new Color[getWidth()][getHeight()];
    }

}
