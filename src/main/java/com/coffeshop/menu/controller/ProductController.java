package com.coffeshop.menu.controller;

import com.coffeshop.menu.model.Product;
import com.coffeshop.menu.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        return "menu";
    }

    @GetMapping
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-new-product";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/products/";
    }


    /*          No longer needed method. The above uses JPA
    @RequestMapping("/list")
    //@ResponseBody     No longer needed
    public String listProducts(Model productListModel){
        productListModel.addAttribute("products", productList);
        return "menu";
    }
    */

    /*      Maybe this will be implemented later
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
    */

    /*      Old methods
    @RequestMapping("/add")
    public String showProductForm(Model productAddFormModel){
        productAddFormModel.addAttribute("product", new Product());
        return "add-new-product";
    }

    @PostMapping
    public String addProduct(Product product){
        productList.add(product);
        System.out.print(productList);
        return "redirect:/products/list";
    }
    */
}
