package br.com.israel.shop.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private double totalPrice = 0;

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        this.products.add(product);
    }

    public List<Product> get(){
        return this.products;
    }

    public void removeItem(String productName){
        this.products.removeIf(product -> product.getName().equals(productName));
    }

    public void removeAll(){
        this.products.clear();
    }

    public double calculateTotalPrice() {
        totalPrice = 0;
        if (products != null) {
            for (Product product : this.products) {
                totalPrice += product.getPrice();
            }
            return totalPrice;
        }
        return 0;
    }

}
