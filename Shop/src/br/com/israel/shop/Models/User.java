package br.com.israel.shop.Models;

public class User {
    private String name;
    private double credit;

    public User(String name, double credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public void buy(double value){
        if (value > this.getCredit()){
            System.out.println("Saldo insuficiente!");
        }else {
            credit -= value;
            System.out.println("Compra realizada com sucesso!");
        }
    }
}
