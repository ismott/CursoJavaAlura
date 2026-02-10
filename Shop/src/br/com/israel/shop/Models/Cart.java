package br.com.israel.shop.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private double totalPrice;

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        products = new ArrayList<>();
        this.products.add(product);
    }

    public List<Product> get(){
        return this.products;
    }


    public double calculateTotalPrice(){
        for (Product product : this.products){
            this.totalPrice =+ product.getPrice();
        }
        return this.totalPrice;
    }

}
