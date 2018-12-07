package image;

import javafx.scene.paint.Color;
import util.Matrices;
import java.util.HashMap;
import java.util.Map;


public class SparseRasterImage extends RasterImage implements Image {

    Map<Point, Color> hm = new HashMap<>();

    public SparseRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] pixels){
        super(pixels);
    }


    public Color getPixelColor(int x, int y) {
        return hm.get(new Point(x,y));
    }

    public void setPixelColor(Color color, int x, int y){
        hm.put(new Point(x,y), color);
    }
    
    public void createRepresentation(){
        Map<Point, Color> hm = new HashMap<>();
    }

}
