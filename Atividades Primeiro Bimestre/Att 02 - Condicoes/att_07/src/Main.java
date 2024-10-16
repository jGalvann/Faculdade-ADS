import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um numero:");
        Double num1 = scanner.nextDouble();
        System.out.println("Escolha o proximo numero");
        Double num2 = scanner.nextDouble();
        System.out.println("Qual operacao deseja realizar?");
        String operacao = scanner.next();


        if (operacao.equals("+")) {
            System.out.println(num1 + num2 + " é a soma ");
        } else if (operacao.equals("-")) {
            System.out.println(num1 - num2 + " é a subtracao");
        } else if (operacao.equals("*")) {
            System.out.print(num1 * num2 + " é a multiplicacao");
        } else if (operacao.equals("/")) {
            System.out.println(num1 / num2 + " é o resultado da divisao");
        } else {
            System.out.println("caracteres inseridos sao invalidos");
        }



    }
}