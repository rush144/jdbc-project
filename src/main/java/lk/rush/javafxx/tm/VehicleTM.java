package lk.rush.javafxx.tm;

public class VehicleTM {
    private int id;
    private String model;
    private String brand;
    private int quantity ;
    private double price;

    public VehicleTM(int id, String model, String brand, int quantity, double price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
