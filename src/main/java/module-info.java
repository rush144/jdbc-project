module lk.rush.javafxx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires mysql.connector.j;
    requires java.sql;


    exports lk.rush.javafxx.controller;
    opens lk.rush.javafxx.controller to javafx.fxml;
    exports lk.rush.javafxx.dto;
    opens lk.rush.javafxx.dto to javafx.fxml;
    exports lk.rush.javafxx.tm;
    opens lk.rush.javafxx.tm to javafx.fxml;
    exports lk.rush.javafxx;
    opens lk.rush.javafxx to javafx.fxml;
}