import br.com.israel.shop.Models.Cart;
import br.com.israel.shop.Models.Product;
import br.com.israel.shop.Models.User;

import java.util.Objects;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        boolean out = true;
        Scanner read = new Scanner(System.in);
        Scanner readOption = new Scanner(System.in);
        Cart cart = new Cart();

        System.out.println("Qual é o seu nome?");
        String userName = read.nextLine();
        System.out.println("Quanto você tem na conta?");
        double credit = read.nextDouble();
        User user = new User(userName, credit);
        while (out){
            System.out.printf("""
                    |Olá %s-------------Saldo atual: %.2f |
                    | 1- Comprar                          |
                    | 2- Carrinho                         |
                    | 3- Sair                             |
                    |-------------------------------------|
                    """, user.getName(), user.getCredit());
            String option = readOption.nextLine();
            switch (option){
                case "1":
                    if(cart.get() != null && cart.calculateTotalPrice() < user.getCredit()){
                        System.out.printf("""
                                |Olá %s----------Saldo atual: %.2f-|
                                |Produtos                          |
                                |%s                                |
                                |----------------------------------|
                                |    Deseja finalisar a compra?    |
                                |       1- Sim        2- Não       |
                                |----------------------------------|
                               """, user.getName(), user.getCredit(), cart.get());
                        option = readOption.nextLine();
                        if (option.equals("1")){
                            user.buy(cart.calculateTotalPrice());
                            System.out.println("Compra efetuada com sucesso!");
                        }
                    }else if(cart.calculateTotalPrice() > user.getCredit()){
                        System.out.println("Saldo insuficiente! remova alguns produtos do carrinho");
                    }else{
                        System.out.println("O carrinho está vazio, adicione alguma coisa primeiro!");
                    }
                    break;
                case "2":
                    System.out.printf("""
                                |Olá %s----------Saldo atual: %.2f-|
                                |Produtos                          |
                                |%s                                |
                                |                                  |
                                |Preço total: %.2f                 |
                                |----------------------------------|
                                | 1- Adicionar item ao carrinho    |
                                | 2- Remover item do carrinho      |
                                |----------------------------------|
                               """, user.getName(), user.getCredit(), cart.get(), cart.calculateTotalPrice());
                    option = readOption.nextLine();
                    if(option.equals("1")) {
                        System.out.println("Qual é o nome do produto?");
                        String productName = read.nextLine();
                        System.out.println("Quanto custa o produto?");
                        double value = read.nextDouble();
                        Product product = new Product(productName, value);
                        cart.add(product);
                    }else {
                        break;
                    }
                    break;
                case "3":
                    out = false;
                    break;
            }
        }
    }
}