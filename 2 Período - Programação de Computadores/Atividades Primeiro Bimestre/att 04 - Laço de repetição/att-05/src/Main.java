import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numAleatorio = random.nextInt(100) + 1;
        int numUser = 0;
        System.out.println("Tente adivinhar o número aleatório de 1 a 100");
        do{
            System.out.println("Escolha algum numero: ");
            numUser = scanner.nextInt();

            if(numUser < numAleatorio){
                System.out.println("O numero aleatório é maior");
            }else if(numUser > numAleatorio){
                System.out.println("O numero aleatório é menor");
            } else{
                System.out.println("Voce acertou o numero. Parabens");
            }


        }while(numUser != numAleatorio);


    }
}