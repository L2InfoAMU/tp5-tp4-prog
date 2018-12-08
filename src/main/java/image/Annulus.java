package image;

import javafx.scene.paint.Color;

public class Annulus implements Shape {

    Circle innerCircle, outerCircle;

    public Annulus(Circle outerCircle, Circle innerCircle){
        this.innerCircle = innerCircle;
        this.outerCircle = outerCircle;
    }

    @Override
    public boolean contains(Point point) {
        return (!innerCircle.contains(point) &&
                outerCircle.contains(point));
    }

    @Override
    public Color getColor() {
        return outerCircle.getColor();
    }
}
