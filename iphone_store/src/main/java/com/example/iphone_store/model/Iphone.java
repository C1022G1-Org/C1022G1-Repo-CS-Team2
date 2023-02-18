package com.example.iphone_store.model;

public class Iphone {
    private  int id;
    private  String productName;
    private String iphoneName;
    private String supplier;
    private String photo;
    private double price;
    private int quantity;

    public Iphone() {
    }

    public Iphone(int id, String productName, String iphoneName, String supplier, String photo, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.iphoneName = iphoneName;
        this.supplier = supplier;
        this.photo = photo;
        this.price = price;
        this.quantity = quantity;
    }

    public Iphone(String productName, String iphoneName, String supplier, String photo, double price, int quantity) {
        this.productName = productName;
        this.iphoneName = iphoneName;
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

    public String getIphoneName() {
        return iphoneName;
    }

    public void setIphoneName(String iphoneName) {
        this.iphoneName = iphoneName;
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
