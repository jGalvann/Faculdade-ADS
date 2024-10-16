import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota do aluno:");
        double nota = scanner.nextDouble();

        if (nota >= 7){
            System.out.println("Aluno aprovado");
        } else if (nota >= 5 && nota < 7) {
            System.out.println("Aluno em recuperacao");
        } else {
            System.out.println("Aluno reprovado");
        }



    }
}