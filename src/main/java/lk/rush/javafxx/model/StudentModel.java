package lk.rush.javafxx.model;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.rush.javafxx.db.DBConnection;
import lk.rush.javafxx.dto.Studentdto;
import lk.rush.javafxx.tm.StudentsTM;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {

    public static boolean SaveForm(Studentdto studentdto){

        boolean flag = false;

        try {
            Connection connection=DBConnection.getDBConnection().getConnection();
            //write sql query
            PreparedStatement preparedStatement=connection.prepareStatement("insert into students(FirstName, LastName, Age) values(?,?,?)");
            preparedStatement.setObject(1,studentdto.getFirstName());
            preparedStatement.setObject(2,studentdto.getLastName());
            preparedStatement.setObject(3,studentdto.getAge());


            //execute query
            int i=preparedStatement.executeUpdate();

            if (i>0){
                flag= true;
            }


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return flag;
    }

    public static Studentdto Search(int id){
        Studentdto studentdto =null;
        try {

            Connection connection=DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select FirstName,LastName,Age from students where id = ?");
            preparedStatement.setObject(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();  //(execute query)for get data from database to the application

            if (resultSet.next()){
                System.out.println(id);
                studentdto = new Studentdto(

                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Enter Valid Id");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException | SQLException |NumberFormatException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Enter Valid Id");
            alert.showAndWait();
        }
        return studentdto;
    }

    public static void UpdateForm(Studentdto studentdto){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establish connection with db
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","rush1234go");

            //write sql query
            PreparedStatement preparedStatement=connection.prepareStatement("update students set FirstName=?,LastName=?,Age=? where id=?");
            preparedStatement.setObject(1,studentdto.getFirstName());
            preparedStatement.setObject(2,studentdto.getLastName());
            preparedStatement.setObject(3,studentdto.getAge());
            preparedStatement.setObject(4,studentdto.getId());

            //execute query
            int i=preparedStatement.executeUpdate();

            if (i>0){
                System.out.println("Record saved");
            }else {
                System.out.println("Record not saved");
            }


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }

    public static boolean DeleteForm(Studentdto studentdto){
        boolean deleted = false;
        try {
            // Load the driver class
            Connection connection=DBConnection.getDBConnection().getConnection();

            // Establish connection with the database

                // Write the SQL query
                PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id = ?");
                preparedStatement.setInt(1,studentdto.getId());

                // Execute the delete query
                int rowsDeleted = preparedStatement.executeUpdate();

                // Feedback to the user
                if (rowsDeleted > 0) {
                    System.out.println(rowsDeleted + " row(s) deleted.");
                    deleted = true;

                } else {
                    System.out.println("No matching record found to delete.");
                }
        } catch (NumberFormatException | ClassNotFoundException |SQLException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        return deleted;
    }

    public static ArrayList<StudentsTM> ViewForm(){

        ArrayList<StudentsTM> students= new ArrayList<>();

        try {

            Connection connection=DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from students");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                students.add(new StudentsTM(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                ));
            }

        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Enter Valid Id");
            alert.showAndWait();
        }

        return students;
    }

}
