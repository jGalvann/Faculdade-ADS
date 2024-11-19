import java.util.Scanner;

public class CarteiraDigital {

    double saldo = 0.0;
    Scanner scanner = new Scanner(System.in);



        public void adicionarSaldo (){

            System.out.println("Qual o valor que deseja adicionar ?");
            double x = scanner.nextDouble();
            if (x>0){
            saldo += x;
            System.out.println("Saldo Adicionado com sucesso!");
            }else {
                System.out.println("Não é possível adicionar valores negativos");
            }



        }

        public void realizarPagamento(){

            System.out.println("Qual o valor do pagamento?");
            double valor = scanner.nextDouble();

            if (valor >0){
                if(saldo >= valor){
                    saldo -= valor;
                    System.out.println("Pagamento realizado");
                }else {
                    System.out.println("Saldo insufíciente");
                }
            }else{
                System.out.println("Vai pagar um valor negativo agora kkkkkk não pode!");
            }

        }

        public void verificarSaldo(){
            System.out.println("Este é seu saldo atual: " + saldo);

        }




}
