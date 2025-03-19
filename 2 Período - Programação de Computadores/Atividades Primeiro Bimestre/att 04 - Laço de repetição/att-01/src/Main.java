import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um número inteiro: ");
        int num = scanner.nextInt();

        for(int i = 1; i < 11; i++) {
            System.out.println( num + " * " + i + " = " + num * i );

        }



    }
}