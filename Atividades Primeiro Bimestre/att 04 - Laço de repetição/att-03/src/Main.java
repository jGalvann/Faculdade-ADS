import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um numero qual deseja calcular o fatorial: ");
        int num = scanner.nextInt();
        int fatorial = 1;
        int i = 1;

         // normalmente faz o fatorial ( 5 * 4 * 3 * 2 * 1 ) mas da pa fzr ao contrário ate o número desejado.
        do {
        fatorial = fatorial * i;
        i++;

        }while(i <= num);

        System.out.println(fatorial);



    }
}