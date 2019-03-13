package cs1302.ce20;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
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
    Image zoomIn;
    Image zoomOut;
    Image zoomActual;
    Button increase;
    Button decrease;
    VBox vbox;
    Scene scene;
    HBox urlLayer;
    TextField urlField;
    Button zoomOrig;
    
    public void start(Stage stage) {

        vbox = new VBox();
        scene = new Scene(vbox);

        urlLayer = new HBox(10);
        urlField = new TextField("https://");
        Button loadImage = new Button("Load");
        HBox buttonLayer = new HBox(10);
        try{
            FileInputStream fis = new FileInputStream(
                new File("./resources/zoom-in-50.png"));
            zoomIn = new Image(fis);
            fis = new FileInputStream(
                new File("./resources/zoom-out-50.png"));
            zoomOut = new Image(fis);
            fis = new FileInputStream(
                new File("./resources/actual-size-50.png"));
            zoomActual = new Image(fis);
            increase = new Button("", new ImageView(zoomIn));
            decrease = new Button("", new ImageView(zoomOut));
            zoomOrig = new Button("", new ImageView(zoomActual));
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
        }
        buttonLayer.getChildren().addAll(increase, decrease, zoomOrig);
        urlLayer.getChildren().addAll(urlField, loadImage);
        HBox.setHgrow(urlField, Priority.ALWAYS);
        Image img = new Image("http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png");
        ImageView imgView = new ImageView(img);
        imgView.setPreserveRatio(true);
        HBox.setHgrow(increase, Priority.ALWAYS);
        HBox.setHgrow(decrease, Priority.ALWAYS);
        HBox.setHgrow(zoomOrig, Priority.ALWAYS);
        
        increase.setMaxWidth(Double.MAX_VALUE);
        decrease.setMaxWidth(Double.MAX_VALUE);
        zoomOrig.setMaxWidth(Double.MAX_VALUE);

//        buttonLayer.setStyle("-fx-background-color:blue;");
        EventHandler<ActionEvent> loadImgHandler = e -> {
            Image newImg = new Image(urlField.getText());
            imgView.setImage(newImg);
            stage.sizeToScene();
        };             

        zoomOrig.setOnAction(e -> {
                imgView.setFitHeight(img.getHeight());
                stage.sizeToScene();
            });
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
        imgView.setFitHeight(img.getHeight());
//        increase.setMinWidth(vbox.getWidth() / 2);
//        decrease.setMinWidth(vbox.getWidth() / 2);
        
    } // main

} // ImageViewerApp

