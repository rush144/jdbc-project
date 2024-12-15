package lk.rush.javafxx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.rush.javafxx.dto.Studentdto;
import lk.rush.javafxx.model.StudentModel;

import java.io.IOException;
import java.sql.*;

public class UpdateFormController {
    public TextField txtId;
    public TextField txtFirstName;
    public TextField TxtLastName;
    public TextField txtAge;
    public AnchorPane updatePane;

    public void search(ActionEvent actionEvent) {

        int id = Integer.parseInt(txtId.getText());

        Studentdto studentdto=StudentModel.Search(id);

        if (id != 0) {
            txtFirstName.setText(studentdto.getFirstName());
            TxtLastName.setText(String.valueOf(studentdto.getLastName()));
            txtAge.setText(String.valueOf(studentdto.getAge()));
        }

    }

    public void cancel(ActionEvent actionEvent) {
        txtId.clear();
        txtFirstName.clear();
        TxtLastName.clear();
        txtAge.clear();
    }

    public void update(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtId.getText());
        String firstName = txtFirstName.getText();
        String lastName = TxtLastName.getText();
        int age = Integer.parseInt(txtAge.getText());

        StudentModel.UpdateForm(new Studentdto(firstName,lastName,age,id));

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.updatePane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/SelectOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}

