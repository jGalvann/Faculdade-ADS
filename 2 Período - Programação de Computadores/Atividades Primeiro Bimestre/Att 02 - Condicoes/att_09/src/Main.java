import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira um numero");
        Double num = scanner.nextDouble();

        if(num > 0 ) {
            System.out.print("Numero positivo");
        } else if ( num < 0 ) {
            System.out.println("Numero negativo");
        } else {
            System.out.println("é zero");
        }


    }
}