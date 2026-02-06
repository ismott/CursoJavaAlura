import java.util.Scanner;

public class Soma {
    public void main(String[] args) {
        double celsius = 10.5;
        double fahrenheit = (celsius * 1.8) + 32;
        int fahrenheitInt = (int) (fahrenheit);
        System.out.printf("""
                %.2f Celsius
                é
                %.2f em Fahrenheit
                em inteiro é
                %d
                %n""", celsius, fahrenheit, fahrenheitInt);
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite seu nome \n");
        String nome = ler.nextLine();
        System.out.print("digite sua idade \n");
        int idade = ler.nextInt();
        System.out.println(nome + idade);
    }
}
