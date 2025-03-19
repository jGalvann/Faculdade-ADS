import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual será o tamanho da lista?");
        int n = scanner.nextInt();
        int soma = 0;

        int[] numeros = new int[n];
        for(int i = 0; i < n; i++){
            System.out.println("Informe o " + (i+1) + " valor da lista: ");
            numeros[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            soma += numeros[i];
        }
        System.out.println("A média entre os números é: " + (soma / n));





    }
}