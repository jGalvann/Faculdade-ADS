import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um número inteiro: ");
        int num = scanner.nextInt();

        while ( num > 0 ) {
            System.out.println( num);
            num = num - 1;
        }


    }
}