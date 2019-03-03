package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class Controller {

    @FXML
    private Button button4;
    @FXML
    private Label label;
    @FXML
    private GridPane gridPane;

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
        chooser.showOpenDialog(gridPane.getScene().getWindow());

    }
}

