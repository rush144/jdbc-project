package lk.rush.javafxx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectOptionController {
    public AnchorPane selectOption;

    public void addPage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.selectOption.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/save-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    public void viewPage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.selectOption.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/LoadAllForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    public void updatePage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.selectOption.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/UpdateForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    public void deletePage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.selectOption.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/DeleteForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }
}
