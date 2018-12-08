package viewer;

import image.Circle;
import image.Point;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application
{

    public static void main(String[] args) {
        Point p = new Point(10,10);
        System.out.println(p.distance(new Point(13,14)));
        Circle circle = new Circle(p,2, Color.WHITE);
        System.out.println(circle.contains(new Point(11,11)));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("/fxml/Display.fxml"));
        primaryStage.setTitle("Image display");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
