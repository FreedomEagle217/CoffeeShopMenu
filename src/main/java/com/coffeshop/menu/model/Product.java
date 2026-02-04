package com.coffeshop.menu.model;

public class Product {
    private int id;
    private String productName;
    private float price;

    public Product(int id, String productName, float price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }


    public Product() {

        // Left intentionally blank since POST method in Controller
        // (ie, showProductForm() ) fills with the info
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
