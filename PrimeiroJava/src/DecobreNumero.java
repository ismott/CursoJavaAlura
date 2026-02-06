import java.util.Random;
import java.util.Scanner;

public class DecobreNumero {
  public void main(String[] args) {
   int secretNumber = new Random().nextInt(100);
   Scanner read = new Scanner(System.in);
    System.out.println("Você terá 5 tentativas para acertar um numero secreto que pode ir de 0 á 100");
    System.out.println("Vamos começar!");
   for (int i = 0; i < 5; i++){
     System.out.println("Qual o número secreto?");
     int numberUser = read.nextInt();
     if(numberUser < secretNumber && i < 4){
       System.out.println("Hmm... parece que o número que você digitou é menor que o numero secreto, tente novamente!");
     }else if(numberUser > secretNumber && i < 4){
       System.out.println("Hmm... parece que o número que você digitou é maior que o numero secreto, tente novamente!");
     }else if(numberUser < secretNumber || numberUser > secretNumber && i == 4){
       System.out.println("Que pena, parece que você é meio burrinho o numero secreto era: " + secretNumber);
     }else{
       System.out.println("Parabéns você tem pelo menos 10 de QI, o numero secreto é: " + secretNumber);
     }
   }
  }
}