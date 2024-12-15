package lk.rush.javafxx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.rush.javafxx.dto.Studentdto;
import lk.rush.javafxx.model.StudentModel;

import java.io.IOException;

public class SaveFormController {

    public AnchorPane SavePane;
    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtAge;

    @FXML
    void clear(ActionEvent event) {
        txtFirstName.clear();
        txtLastName.clear();
        txtAge.clear();
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void save(ActionEvent event) {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        int age = Integer.parseInt(txtAge.getText());

        boolean b= StudentModel.SaveForm(new Studentdto(firstName,lastName,age));
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.SavePane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/SelectOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
