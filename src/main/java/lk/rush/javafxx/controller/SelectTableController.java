package lk.rush.javafxx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectTableController {

    public AnchorPane selectTable;

    public void selectVehicle(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) this.selectTable.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/SelectOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }
}
