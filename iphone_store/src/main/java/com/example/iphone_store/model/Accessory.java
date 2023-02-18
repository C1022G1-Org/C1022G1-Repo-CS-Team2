package com.example.iphone_store.model;

public class Accessory {
    private  int id;
    private  String productName;
    private String accessoryName;
    private String supplier;
    private String photo;
    private double price;
    private int quantity;

    public Accessory() {
    }

    public Accessory(int id, String productName, String accessoryName, String supplier, String photo, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.accessoryName = accessoryName;
        this.supplier = supplier;
        this.photo = photo;
        this.price = price;
        this.quantity = quantity;
    }

    public Accessory(String productName, String accessoryName, String supplier, String photo, double price, int quantity) {
        this.productName = productName;
        this.accessoryName = accessoryName;
        this.supplier = supplier;
        this.photo = photo;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
