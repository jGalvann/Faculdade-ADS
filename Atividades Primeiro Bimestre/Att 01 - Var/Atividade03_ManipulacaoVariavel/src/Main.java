public class Main {
    public static void main(String[] args) {
        String nome = "Jaime Dunes";
        int idade = 23;
        double salario = 1420.69;
        int mesTrabalho = 7;
        int prodCompr = 12;
        double valorTotalCompras = 1512.32;
        double fazoL = 3500.00;


        double salAnualBt = salario * mesTrabalho;
        double salAnualliq = salAnualBt - fazoL;
        double mediaCompras = valorTotalCompras / prodCompr;


        System.out.println("Olá "+ nome + " seu salarios liquido esses ano foi de " + salAnualliq);
        System.out.println("nome: " + nome);
        System.out.println("salario: " + salario);
        System.out.println("trabalhou por " + mesTrabalho + " meses");
        System.out.println("voce comprou " + prodCompr + " itens");
        System.out.println("e gastou um total de " + valorTotalCompras + " com eles");
        System.out.println("Pagou essee valor de imposto: " + fazoL);
        System.out.println("salario bruto " + salAnualBt);
        System.out.println("salario liquido " + salAnualliq);
        System.out.println("e gastou em media " + mediaCompras + " dinheiros por compra");



    }
}