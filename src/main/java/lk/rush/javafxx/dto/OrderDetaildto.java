package lk.rush.javafxx.dto;

public class OrderDetaildto {
    private int vehicleId;
    private int quantity;
    private double price;

    public OrderDetaildto(int vehicleId, int quantity, double price) {
        this.vehicleId = vehicleId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
