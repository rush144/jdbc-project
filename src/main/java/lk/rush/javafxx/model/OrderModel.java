package lk.rush.javafxx.model;

import lk.rush.javafxx.dto.OrderDetaildto;
import lk.rush.javafxx.dto.Orderdto;
import lk.rush.javafxx.dto.Vehicledto;

import java.sql.*;

public class OrderModel {

    public static boolean placeOrder(Orderdto orderdto) throws SQLException, ClassNotFoundException {

        boolean flag = false;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection vehicleconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "rush1234go");

        //disable auto commit
        vehicleconnection.setAutoCommit(false);

        //insert data to the order table
        PreparedStatement statement1 = vehicleconnection.prepareStatement("insert into orders(date,amount) values(?,?)", Statement.RETURN_GENERATED_KEYS);
        statement1.setObject(1,orderdto.getOrderDate());
        statement1.setObject(2,orderdto.getSubTotal());

        int orderSave = statement1.executeUpdate();
        if(orderSave>0){

            ResultSet resaultSet = statement1.getGeneratedKeys();

            if(resaultSet.next()){
                int orderId = resaultSet.getInt(1);

                for(OrderDetaildto dto : orderdto.getOrderDetailsDto()){

                    PreparedStatement statement2=vehicleconnection.prepareStatement("insert into order_details(oid,vid,qty,price) values(?,?,?,?)");
                    statement2.setObject(1,orderId);
                    statement2.setObject(2,dto.getVehicleId());
                    statement2.setObject(3,dto.getQuantity());
                    statement2.setObject(4,dto.getPrice());

                    int vehicleTable = statement2.executeUpdate();

                    if(vehicleTable>0){

                        PreparedStatement statement3=vehicleconnection.prepareStatement("update vehicles set quantity=quantity-? where id=? ");
                        statement3.setObject(1,dto.getQuantity());
                        statement3.setObject(2,dto.getVehicleId());

                        int updateVehicle = statement3.executeUpdate();

                        if(updateVehicle<=0){
                            vehicleconnection.rollback();
                            vehicleconnection.setAutoCommit(true);
                        }

                    }else{
                        vehicleconnection.rollback();
                        vehicleconnection.setAutoCommit(true);
                    }

                }
                vehicleconnection.commit();
                vehicleconnection.setAutoCommit(true);

            }
        }
        else{
            vehicleconnection.rollback();
            vehicleconnection.setAutoCommit(true);
        }
        return  flag;
    }
}
