package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {

    @FXML
    private Button button4;
    @FXML
    private Label label;
    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;

    public void initialize(){

        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.02);
        label.setScaleY(2.02);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleX(2.02);
        label.setScaleY(2.02);
    }

    @FXML
    public void handleClick(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF","*.pdf"),
                new FileChooser.ExtensionFilter("All files","*.*"),
                new FileChooser.ExtensionFilter("Image files","*.jpeg","*.jpeg","*.gif")
        );
        //DirectoryChooser chooser = new DirectoryChooser();
        /* filters are convenient for limiting the types of files possible to open */
        //File file =  chooser.showOpenDialog(gridPane.getScene().getWindow());
       // File file =  chooser.showSaveDialog(gridPane.getScene().getWindow());
        List<File> file =  chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        //chooser.showDialog(gridPane.getScene().getWindow());
        if(file != null){
            for(File f: file){
                System.out.println(f);
            }
            file.parallelStream().forEach((f)->{
                System.out.println(f);
            });
           // System.out.println(file.getPath());
        } else {
            System.out.println("Chooser was cancelled");
        }


    }

    @FXML
    public void handleLinkClick(){
        System.out.println("LInk was clicked");
//        try{
//            Desktop.getDesktop().browse(new URI("http::/www.javafx.com"));
//        } catch(IOException e ){
//            e.printStackTrace();
//        } catch(URISyntaxException e){
//            e.printStackTrace();
//        }
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");

    }


}

