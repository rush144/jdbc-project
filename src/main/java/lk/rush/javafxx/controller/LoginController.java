package lk.rush.javafxx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField username;
    public TextField password;
    public AnchorPane root;

    public void login(ActionEvent actionEvent) throws IOException {
        String dbUsername = this.username.getText();
        String dbPassword = this.password.getText();

        if(dbUsername.equals("admin") && dbPassword.equals("1234")) {

            Stage stage = (Stage) this.root.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/SelectTable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene); 

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText("The username or password you entered is incorrect.");
            alert.showAndWait();
        }

    }
}
