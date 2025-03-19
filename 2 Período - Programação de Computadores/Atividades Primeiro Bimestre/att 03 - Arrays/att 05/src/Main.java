import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha tres nomes aí: ");
        String[] nomes = new String[] { scanner.next(), scanner.next(), scanner.next() };

        for(int i = 0; i < 3; i++){
            System.out.println(nomes[i]);
        }
    }
}
