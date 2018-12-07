package image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image {

    List<Color> palette;
    int[][] indexesOfColor;

    public PaletteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public PaletteRasterImage(Color [][] pixels){
        super(pixels);
    }

    public void createRepresentation(){
        palette = new ArrayList<Color>();
        indexesOfColor = new int[getWidth()][getHeight()];
    }


    public Color getPixelColor(int x, int y){ return palette.get(indexesOfColor[x][y]); }

    public void setPixelColor(Color color, int x, int y){
        if (!palette.contains(color))
            palette.add(color);
        indexesOfColor[x][y] = palette.indexOf(color);
    }

}
