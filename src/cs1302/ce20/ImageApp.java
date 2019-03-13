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

/**
 * An extended version of the cs1302 ImageApp. The program takes 
 * a user specified URL to an image and loads it into an {@code ImageView}.
 * This version of the application also contains buttons that allow
 * the user to zoom in, zoom out, and return to the original image size.
 * It is super fancy. Students will love it.
 */
public class ImageApp extends Application {
    
    Scene scene;
    /** The main container for the App */
    VBox vbox;

    /** Button to load the image from the urlField into the ImageView */
    Button loadImage;
    /** Textfield for the user to enter the URL of the image to load */
    TextField urlField;
    /** Container for the url field and the load button */
    HBox urlLayer;
   
    /** Buttons for zooming */
    Button increase, decrease, zoomOrig;
    /** Container for the zoom buttons */
    HBox buttonLayer;

    /** The view containing the loaded image */
    ImageView imgView;
    
    /** The placeholder image that is loaded when the app starts */
    private static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";

    /**
     * The entry point for our ImageApp
     *
     * @param stage A reference to the stage object created by the system
     */
    public void start(Stage stage) {

        vbox = new VBox();
        scene = new Scene(vbox);

        urlLayer = new HBox(10);
        urlField = new TextField("https://");
        loadImage = new Button("Load");

        buildButtonLayer();

        urlLayer.getChildren().addAll(urlField, loadImage);

        //Load the default image into the image view
        Image img = new Image(DEFAULT_IMG);
        imgView = new ImageView(img);
        imgView.setPreserveRatio(true);

        //Set the buttons and textfield to resize with the containing HBox
        HBox.setHgrow(increase, Priority.ALWAYS);
        HBox.setHgrow(decrease, Priority.ALWAYS);
        HBox.setHgrow(zoomOrig, Priority.ALWAYS);
        HBox.setHgrow(urlField, Priority.ALWAYS);
        
        //Set the max width of the buttons so they can change size
        increase.setMaxWidth(Double.MAX_VALUE);
        decrease.setMaxWidth(Double.MAX_VALUE);
        zoomOrig.setMaxWidth(Double.MAX_VALUE);

        //Set up the event handlers on the four buttons
        EventHandler<ActionEvent> loadImgHandler = e -> {
            Image newImg = new Image(urlField.getText());
            imgView.setImage(newImg);
            stage.sizeToScene();
        };             
        loadImage.setOnAction(loadImgHandler);
        
        zoomOrig.setOnAction(e -> {
                imgView.setFitHeight(img.getHeight());
                stage.sizeToScene();
            });
        
        increase.setOnAction(e -> {
                imgView.setFitHeight(imgView.getFitHeight()+25);
                stage.sizeToScene();
            });

        decrease.setOnAction(e -> {
                imgView.setFitHeight(imgView.getFitHeight()-25);
                stage.sizeToScene();
            });

        //Add all of the nodes to the main vbox container
        vbox.getChildren().addAll(urlLayer, imgView, buttonLayer);

        //Wanted the imgView to grow with the window.  Doesn't seem to work.
        //imgView.maxWidth(Double.MAX_VALUE);
        //VBox.setVgrow(imgView, Priority.ALWAYS);

        //Set the scene on the stage
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

        //Set the initial image view height. If we don't do this, the first
        //time we zoom, the image gets really small.  For some reason, the
        //initial height is -1 without this call.
        imgView.setFitHeight(img.getHeight());
        
    } // main

    /**
     * Creates the {@code HBox} container for the zoom buttons. This
     * method initializes the HBox object with spacing of 8 pixels,
     * reads the zoom button icons from the {@code resources} folder,
     * creates the buttons containing the icons, and adds the buttons
     * to the button layer HBox.
     */
    public void buildButtonLayer() {
        buttonLayer = new HBox(8);
        
        try{
            FileInputStream fis = new FileInputStream(
                new File("./resources/zoom-in-50.png"));

            Image zoomIn = new Image(fis);
            fis = new FileInputStream(
                new File("./resources/zoom-out-50.png"));

            Image zoomOut = new Image(fis);
            fis = new FileInputStream(
                new File("./resources/actual-size-50.png"));

            Image zoomActual = new Image(fis);
            increase = new Button("", new ImageView(zoomIn));
            decrease = new Button("", new ImageView(zoomOut));
            zoomOrig = new Button("", new ImageView(zoomActual));
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
        } // try
        
        buttonLayer.getChildren().addAll(increase, decrease, zoomOrig);
    } // buildButtonLayer

} // ImageViewerApp

