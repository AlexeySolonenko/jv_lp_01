module a19336musicUI {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens sample;
    opens sample.model to javafx.base;

}