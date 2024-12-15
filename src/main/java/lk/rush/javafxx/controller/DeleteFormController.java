package lk.rush.javafxx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.rush.javafxx.dto.Studentdto;
import lk.rush.javafxx.model.StudentModel;
import lk.rush.javafxx.tm.StudentsTM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFormController {
    public TextField txtdelete;
    public AnchorPane deltePane;

    public void delete(ActionEvent actionEvent) {

        int id = Integer.parseInt(txtdelete.getText());

        boolean delete=StudentModel.DeleteForm(new Studentdto(id));

        if (delete){
            System.out.println("Student deleted successfully");
        }

    }

    public void cancel(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.deltePane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/SelectOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
