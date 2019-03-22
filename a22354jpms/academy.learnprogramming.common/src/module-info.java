module academy.learnprogramming.common {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens academy.learnprogramming.common to javafx.base;
    exports academy.learnprogramming.common;
}