package com.coffeshop.menu.model;

//import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@NotNull(message="A product name is required.")
    //@Size(min=2, max=50, message="Product name must be between 2 and 50 characters.")
    private String productName;
    //@NotNull(message="A product price is required.")
    //@Min(value=1,message="Product price must be a positive value.")
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
