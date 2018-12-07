package image;

import image.Shape;
import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    int x, y , width, height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    @Override
    public boolean contains(Point point) {
        return (point.x <= x + width && point.x >= x
            && point.y >= y - height && point.y >= y);
    }

    @Override
    public Color getColor() {
        return color;
    }
}

