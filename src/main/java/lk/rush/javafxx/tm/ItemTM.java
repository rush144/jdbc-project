package lk.rush.javafxx.tm;

public class ItemTM {
    private String model;
    private String brand;
    private int qty;
    private double unitPrice;
    private double total;

    public ItemTM(String brand, String model, int qty, double unitPrice, double total) {

        this.brand = brand;
        this.model = model;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
