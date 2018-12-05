package image;
import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    List<Color> palette;
    int[][] indexesOfColor;
    Color color;
    int width, height;
    Color[][] pixels;

    public PaletteRasterImage(Color color, int width, int height){
        this.color = color;
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);

    }

    public PaletteRasterImage(Color [][] pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        this.pixels = pixels;
        this.width = pixels.length;
        this.height= pixels[0].length;
        createRepresentation();
        setPixelsColor(pixels);
    }

    public void createRepresentation(){
        palette = new ArrayList<Color>();
        indexesOfColor = new int[getWidth()][getHeight()];
    }

    private void setPixelsColor(Color[][] pixels){
        for(int x = 0; x<getWidth(); x++ )
            for(int y = 0; y<getHeight(); y++)
                setPixelColor(pixels[x][y], x, y);
    }


    private void setPixelsColor(Color color){
        for(int x = 0; x<getWidth(); x++ )
            for(int y = 0; y<getHeight(); y++)
                setPixelColor(color, x, y);
    }


    public Color getPixelColor(int x, int y){ return palette.get(indexesOfColor[x][y]); }

    public void setPixelColor(Color color, int x, int y){
        if (!palette.contains(color))
            palette.add(color);
        indexesOfColor[x][y] = palette.indexOf(color);
    }

    public int getWidth(){ return width; }

    public int getHeight(){ return height; }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height; }

}
