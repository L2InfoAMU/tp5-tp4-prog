package image;
import javafx.scene.paint.Color;
import static util.Matrices.*;


public abstract class RasterImage implements Image {

    public int width;
    public int height;

    public RasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public RasterImage(Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        this.width = colors.length;
        this.height = colors[0].length;
        createRepresentation();
        setPixelsColor(colors);
    }

    public int getWidth() { return width; }


    public int getHeight() { return height; }


    protected void setWidth(int width){ this.width = width; }


    protected void setHeight(int height){ this.height = height; }


    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color, int x, int y);

    protected void setPixelsColor(Color color) {
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                setPixelColor(color, x, y);
    }

    protected void setPixelsColor(Color[][] pixels){
        for(int x = 0; x<getWidth(); x++ )
            for(int y = 0; y<getHeight(); y++)
                setPixelColor(pixels[x][y], x, y);
    }

        public abstract Color getPixelColor(int x, int y);

}