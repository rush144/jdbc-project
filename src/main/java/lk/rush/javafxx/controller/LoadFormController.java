package lk.rush.javafxx.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.rush.javafxx.model.StudentModel;
import lk.rush.javafxx.tm.StudentsTM;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadFormController {
    public TableView<StudentsTM> tblStudents;
    public AnchorPane viewPane;
    
    public void initialize() {
        ArrayList<StudentsTM> students =StudentModel.ViewForm();
        //configure fx table
        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tblStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Age"));

        tblStudents.setItems(FXCollections.observableList(students));
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.viewPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/rush/javafxx/SelectOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}