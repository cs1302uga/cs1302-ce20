package cs1302.ce20;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

public class ImageApp extends Application {

    public void start(Stage stage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        HBox urlLayer = new HBox(10);
        TextField urlField = new TextField("https://");
        Button loadImage = new Button("Load");
        HBox buttonLayer = new HBox(10);
        Button increase = new Button("+");
        Button decrease = new Button("-");
        buttonLayer.getChildren().addAll(increase, decrease);
        urlLayer.getChildren().addAll(urlField, loadImage);
        HBox.setHgrow(urlField, Priority.ALWAYS);
        HBox.setHgrow(increase, Priority.ALWAYS);
        HBox.setHgrow(decrease, Priority.ALWAYS);
        Image img = new Image("http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png");
        ImageView imgView = new ImageView(img);
        imgView.setPreserveRatio(true);
//        imgView.setFitHeight(img.getHeight());
        EventHandler<ActionEvent> loadImgHandler = e -> {
            Image newImg = new Image(urlField.getText());
            imgView.setImage(newImg);
            stage.sizeToScene();
        };             
        
        loadImage.setOnAction(loadImgHandler);
        vbox.getChildren().addAll(urlLayer, imgView, buttonLayer);
        VBox.setVgrow(imgView, Priority.ALWAYS);
        
        increase.setOnAction(e -> {
                imgView.setFitHeight(imgView.getFitHeight()+25);
                stage.sizeToScene();
            });
        decrease.setOnAction(e -> {
                imgView.setFitHeight(imgView.getFitHeight()-25);
                stage.sizeToScene();
            });
               
        
        stage.setScene(scene);
	
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();

        stage.show();
//        increase.setMinWidth(vbox.getWidth() / 2);
//        decrease.setMinWidth(vbox.getWidth() / 2);
        
    } // main

} // ImageViewerApp

