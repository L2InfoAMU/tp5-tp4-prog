package image;

import javafx.scene.paint.Color;
import util.Matrices;
import java.util.HashMap;
import java.util.Map;


public class SparseRasterImage implements Image {

    Color color;
    int width, height;
    Color[][] pixels;
    Map<Point, Color> hm = new HashMap<>();

    public SparseRasterImage(Color color, int width, int height){
        this.color = color;
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public SparseRasterImage(Color[][] pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        this.pixels = pixels;
        this.width = pixels.length;
        this.height= pixels[0].length;
        createRepresentation();
        setPixelsColor(pixels);
    }


    public Color getPixelColor(int x, int y) {
        return hm.get(new Point(x,y));
    }

    public void setPixelColor(Color color, int x, int y){
        hm.put(new Point(x,y), color);
    }

    private void setPixelsColor(Color color){
        for(int x = 0; x<getWidth(); x++ )
            for(int y = 0; y<getHeight(); y++)
                setPixelColor(color, x, y);
    }

    private void setPixelsColor(Color[][] pixels){
        for(int x = 0; x<getWidth(); x++ )
            for(int y = 0; y<getHeight(); y++)
                setPixelColor(pixels[x][y], x, y);
    }


    public void createRepresentation(){
        Map<Point, Color> hm = new HashMap<>();
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height; }
}
