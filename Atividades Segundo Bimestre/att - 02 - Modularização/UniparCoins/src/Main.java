import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarteiraDigital carteira = new CarteiraDigital();
        boolean continuar = true;
        int acao = 0;
        double valor = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Bem vindo a sua Carteira digital");

        do{
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Saldo");
            System.out.println("2 - Realizar Pagamento");
            System.out.println("3 - Verificar Saldo");
            System.out.println("4 - Sair");

            acao = scanner.nextInt();

            if(acao > 4){
                System.out.println("Escolha um número que corresponda a uma ação.");
            }else {
                if(acao == 1){
                    carteira.adicionarSaldo();
                }
                if(acao == 2){
                    carteira.realizarPagamento();
                }
                if(acao == 3){
                    carteira.verificarSaldo();
                }
                if (acao == 4){
                    continuar = false;
                    System.out.println("Agradeço o uso de nossos serviços");
                }

            }







        }while(continuar);






    }
}