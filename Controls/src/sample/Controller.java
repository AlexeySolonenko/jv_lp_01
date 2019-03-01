package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField tf1;
    @FXML
    private Button b1;
    @FXML
    private Button b2;

    @FXML
    private CheckBox chb1;

    @FXML
    private Label noteLabel;


    @FXML
    public void initialize() {
        b1.setDisable(true);
        b2.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            System.out.println("Hello + " + tf1.getText());
        } else if (e.getSource().equals(b2)) {
            System.out.println("Buy + " + tf1.getText());
        }
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "Ui Thread " : "Background Thread";
                    System.out.println("I'm going to sleep on the " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "Ui Thread " : "Background Thread";
                            System.out.println("I'm updating the label on " + s);
                            noteLabel.setText("Sleep time out elapsed");
                        }
                    });

                } catch (InterruptedException event) {
                }
            }
        };


        new Thread(task).start();

        if (chb1.isSelected()) {
            tf1.clear();
            b1.setDisable(true);
            b2.setDisable(true);
        }
        //System.out.println("The following button was pressed" + e.getSource());
        //System.out.println("Hello, " + tf1.getText());

    }

    @FXML
    public void handleKeyReleased() {
        String text = tf1.getText();
        boolean disableButons = text.isEmpty() | text.trim().isEmpty();
        b1.setDisable(disableButons);
        b2.setDisable(disableButons);
    }

    @FXML
    public void handleChange() {
        System.out.println("The checkbox is " + (chb1.isSelected() ? "checked " : "not checked"));
    }
}


