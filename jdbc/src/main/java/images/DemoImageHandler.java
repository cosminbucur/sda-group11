package images;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;

public class DemoImageHandler extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image handler");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        ImageView imageView = getImageView();

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView getImageView() {
        ImageHandler imageHandler = new ImageHandler();
//        imageHandler.uploadImage();
        InputStream imageStream = imageHandler.downloadImage("save-me.png");
        Image image = new Image(imageStream);
        return new ImageView(image);
    }
}
