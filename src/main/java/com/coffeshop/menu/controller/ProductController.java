package com.coffeshop.menu.controller;

import com.coffeshop.menu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/products")
public class ProductController {
    private List<Product> productList = List.of(
            new Product(1, "Cappucino", 7.50f),
            new Product(2, "Macha", 8.00f),
            new Product(3, "Frappucino", 8.50f));

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "Welcome to the Coffee Shop!";
    }

    @RequestMapping("/list")
    //@ResponseBody     No longer needed
    public String listProducts(Model productListModel){
        productListModel.addAttribute("products", productList);
        return "menu";
    }

    @RequestMapping("details/{id}")
    @ResponseBody
    public String getProductDetailsById(@PathVariable int id){
        for (Product p: productList){
            if (p.getId() == id){
                return "<strong>Requested Product Details:</strong><hr>" +
                        "Product ID: " + p.getId() +
                        " Product Name: " + p.getProductName() +
                        " Price: " + p.getPrice();
            }
        }
        return "Product not found";
    }
    
}
