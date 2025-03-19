import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        double salarioBruto;
        int anosTrabalhados;

        System.out.println("Digite o salário bruto do funcionário: ");
        salarioBruto = sc.nextDouble();
        System.out.println("Digite quantos anos foram trabalhados na empresa: ");
        anosTrabalhados = sc.nextInt();

        double bonusBruto = 0.0;

        if(anosTrabalhados >= 10){
            bonusBruto = salarioBruto * 0.10;
        }
        else if(anosTrabalhados >= 5){
            bonusBruto = salarioBruto * 0.05;
        }


        double impostoBruto;

        if(salarioBruto >= 5000){
            impostoBruto = salarioBruto * 0.27;
        }
        else if(salarioBruto >= 3000){
            impostoBruto = salarioBruto * 0.18;
        }
        else{
            impostoBruto = salarioBruto * 0.10;
        }

        double salarioLiquido = salarioBruto + bonusBruto - impostoBruto;

        System.out.printf("\nSalário Bruto: R$ %.2f", salarioBruto);
        System.out.printf("\nBônus recebido: R$ %.2f", bonusBruto);
        System.out.printf("\nImposto descontado: R$ %.2f", impostoBruto);
        System.out.printf("\nSalário Líquido: R$ %.2f", salarioLiquido);



    }

}