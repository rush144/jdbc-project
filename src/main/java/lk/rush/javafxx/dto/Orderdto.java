package lk.rush.javafxx.dto;

import java.util.ArrayList;

public class Orderdto {
    private String orderDate;
    private double subTotal;

    private ArrayList<OrderDetaildto> orderDetailsDto;  //since order has many order details

    public Orderdto(String orderDate, double subTotal, ArrayList<OrderDetaildto> orderDetailsDto) {
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.orderDetailsDto = orderDetailsDto;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public ArrayList<OrderDetaildto> getOrderDetailsDto() {
        return orderDetailsDto;
    }

    public void setOrderDetailsDto(ArrayList<OrderDetaildto> orderDetailsDto) {
        this.orderDetailsDto = orderDetailsDto;
    }
}
