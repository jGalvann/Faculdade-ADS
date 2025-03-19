
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] num = new int[3];
        System.out.println("Escolhe um numero aí: ");
        num[0] = scanner.nextInt();
        System.out.println("escolhe outro aí: ");
        num[1] = scanner.nextInt();
        System.out.println("Mais um: ");
        num[2] = scanner.nextInt();

        System.out.println("os numeros que voce escolheu foram:");
        System.out.println(num[0] + " " + num[1] + " " + num[2]);
        System.out.print("e a media entre eles é: ");
        System.out.println( (num[0] + num[1] + num[2]) / 3 );

    }
}
