package lk.rush.javafxx.model;

import javafx.scene.control.Alert;
import lk.rush.javafxx.db.DBConnection;
import lk.rush.javafxx.dto.Studentdto;
import lk.rush.javafxx.dto.Vehicledto;
import lk.rush.javafxx.tm.ItemTM;
import lk.rush.javafxx.tm.StudentsTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleModel {

    public static Vehicledto Search(int id){
        Vehicledto vehicledto =null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","rush1234go");

            PreparedStatement preparedStatement = connection.prepareStatement("select model ,brand ,quantity ,price  from vehicles  where id = ?");
            preparedStatement.setObject(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();  //(execute query)for get data from database to the application

            if (resultSet.next()){

                System.out.println(id);

                vehicledto = new Vehicledto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4));
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Enter Valid Id");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Enter Valid Id");
            alert.showAndWait();
        }
        return vehicledto;
    }




}



