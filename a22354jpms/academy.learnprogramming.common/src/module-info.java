module academy.learnprogramming.common {
    //requires javafx.fxml;
    //requires javafx.controls;
    requires javafx.base;
    //requires java.sql;

    opens academy.learnprogramming.common to javafx.base;
    exports academy.learnprogramming.common;
}