package br.com.israel.shop.Models;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "| Nome: " + getName() + " Preço: " + getPrice() + " |\n";
    }

}
