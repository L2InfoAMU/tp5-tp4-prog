package image;

import javafx.scene.paint.Color;

public class Circle implements Shape {

    public Point center;
    public double radius;
    public Color color;

    public Circle(Point center, double radius, Color color){
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        return (center.distance(point) <= (radius));
    }

    @Override
    public Color getColor() {
        return color;
    }
}