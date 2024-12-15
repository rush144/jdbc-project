package lk.rush.javafxx.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.rush.javafxx.dto.OrderDetaildto;
import lk.rush.javafxx.dto.Orderdto;
import lk.rush.javafxx.dto.Studentdto;
import lk.rush.javafxx.dto.Vehicledto;
import lk.rush.javafxx.model.OrderModel;
import lk.rush.javafxx.model.StudentModel;
import lk.rush.javafxx.model.VehicleModel;
import lk.rush.javafxx.tm.ItemTM;
import lk.rush.javafxx.tm.StudentsTM;
import lk.rush.javafxx.tm.VehicleTM;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFormController {

    public AnchorPane OrderViewPane;
    public TextField txtId;
    public TextField txtBrand;
    public TextField txtModel;
    public TextField txtQuantity;
    public TextField txtPrice;
    public TextField txtOrderCount;
    public TableView<ItemTM> tblOrderTable;
    public Text subTotal;
    public ArrayList<OrderDetaildto> orderDetaildtos;

    public List<ItemTM> itemList;
    double fullTotal=0;

    public void search(ActionEvent actionEvent) {

        int id = Integer.parseInt(txtId.getText());

        System.out.println(id);

        Vehicledto vehicledto= VehicleModel.Search(id);

        if (id != 0) {

            txtBrand.setText(vehicledto.getBrand());
            txtModel.setText(vehicledto.getModel());
            txtQuantity.setText(String.valueOf(vehicledto.getQuantity()));
            txtPrice.setText(String.valueOf(vehicledto.getPrice()));
        }
    }

    public void addToCart(ActionEvent actionEvent) {
         int qty = Integer.parseInt(txtOrderCount.getText());
         String brand = txtBrand.getText();
         String model = txtModel.getText();
         double unitPrice = Double.parseDouble(txtPrice.getText());
         double total = unitPrice * qty;

         System.out.println(total);

         itemList.add(new ItemTM(brand,model,qty,unitPrice,total));

         int id = Integer.parseInt(txtId.getText());
         orderDetaildtos.add(new OrderDetaildto(id,qty,total));

         tblOrderTable.setItems(FXCollections.observableArrayList(itemList));


         fullTotal += total;
         subTotal.setText(String.valueOf(fullTotal));

    }

    public void placeOrder(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String formatedDate = dateFormat.format(date);
        System.out.println(formatedDate);

        boolean orderStatus = OrderModel.placeOrder(new Orderdto(formatedDate, fullTotal, orderDetaildtos));

        if (orderStatus){
            System.out.println("Oder Success");
        }


    }

    public void initialize() {
        tblOrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Brand"));
        tblOrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Model"));
        tblOrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        itemList = new ArrayList<>();
        orderDetaildtos=new ArrayList<>();

    }

}
