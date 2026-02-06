import java.util.Scanner;

public class Bank {
    static void main() {
        boolean here = true;
        Scanner readMoney = new Scanner(System.in);
        Scanner readOption = new Scanner(System.in);
        double balance = 0;
        while (here){
            System.out.print("""
                    Você está no RouBank
                    
                    Esolha uma das opções:
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    """);
            String option = readOption.nextLine();
            switch (option){
                case "1":
                    System.out.printf("Seu saldo bancario é: %.2f \n\n", balance);
                    break;
                case "2":
                    System.out.println("Quanto você quer receber?");
                    double moneyAdd = readMoney.nextDouble();
                    balance += moneyAdd;
                    System.out.printf("Seu saldo atual é de %.2f\n\n", balance);
                    break;
                case "3":
                    System.out.println("Quanto deseja transferir?");
                    double moneyRemove = readMoney .nextDouble();
                    if (moneyRemove < balance){
                        balance -= moneyRemove;
                        System.out.printf("Transferência realizada com sucesso! Seu saldo atual agora é de %.2f\n\n", balance);
                    }else {
                        System.out.println("Você não tem saldo o suficiente!\n\n");
                    }
                    break;
                case "4":
                    here = false;
                    break;
                case null, default:
                    System.out.printf("Escolha uma opção valida! Como: 1, 2, 3 ou 4.\n\n");
                    break;
            }
        }
    }
}
