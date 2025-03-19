import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor da compra realizada?");
        double valor = scanner.nextDouble();

        if(valor >= 500) {
            System.out.println("voce tem um desconto de 20%\n valor original: " + valor + "\n desconto: "
                    + valor * 0.20 + "\n Valor a ser pago: " + valor * 0.80);
        } else if(valor >= 200 && valor < 500) {
            System.out.println("voce tem um desconto de 10%\n valor original: " + valor + "\n desconto: "
                    + valor * 0.10 + "\n Valor a ser pago: " + valor * 0.90);
        } else if (valor >= 100 && valor <200){
            System.out.println("voce tem um desconto de 5%\n valor original: " + valor + "\n desconto: "
                    + valor * 0.05 + "\n Valor a ser pago: " + valor * 0.95);
        } else {
            System.out.println("no tiene desconto");
        }


    }
}