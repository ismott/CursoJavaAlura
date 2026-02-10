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
        Scanner readProductName = new Scanner(System.in);
        Scanner readProductValue = new Scanner(System.in);
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
                                |Total: %.2f                       |
                                |----------------------------------|
                                |    Deseja finalisar a compra?    |
                                |       1- Sim        2- Não       |
                                |----------------------------------|
                               """, user.getName(), user.getCredit(), cart.get(), cart.calculateTotalPrice());
                        option = readOption.nextLine();
                        if (option.equals("1")){
                            user.buy(cart.calculateTotalPrice());
                            System.out.println("Compra efetuada com sucesso!");
                            cart.removeAll();
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
                                Produtos:
                                %s
                                |----------------------------------|
                                |Preço total: %.2f                 |
                                |----------------------------------|
                                | 1- Adicionar item ao carrinho    |
                                | 2- Remover item do carrinho      |
                                | 3- Sair                          |
                                |----------------------------------|
                               """, user.getName(), user.getCredit(), cart.get(), cart.calculateTotalPrice());
                    option = readOption.nextLine();
                    if(option.equals("1")) {
                        System.out.println("Qual é o nome do produto?");
                        String productName = readProductName.nextLine();
                        System.out.println("Quanto custa o produto?");
                        double value = readProductValue.nextDouble();
                        Product product = new Product(productName, value);
                        cart.add(product);
                    }else if(option.equals("2")){
                        System.out.println("Qual é o nome do produto que deseja excluir?");
                        String productName = readProductName.nextLine();
                        cart.removeItem(productName);
                    }
                    break;
                case "3":
                    out = false;
                    break;
            }
        }
    }
}