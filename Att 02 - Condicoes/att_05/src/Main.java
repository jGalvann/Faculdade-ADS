import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int diaDaSemana = 0;
        System.out.println("Digite um dia da semana, em numeros");
        diaDaSemana = scanner.nextInt();

        switch (diaDaSemana) {
            case 1:
                System.out.print("Segunda");
                break;
            case 2:
                System.out.print("Terca");
                break;
            case 3:
                System.out.print("Quarta");
                break;
            case 4:
                System.out.print("Quinta");
                break;
            case 5:
                System.out.print("Sexta");
                break;
            case 6:
                System.out.print("Sabado");
                break;
            case 7:
                System.out.print("Domingo");
                break;
            default:
                System.out.print("Numero invalido, por favor insira um numero de 1 a 7");
                break;
        }
    }
}