// soma de três números

/*
 código dado pelo chatGPT
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 15;
        int resultado = a + b + c;
        System.out.println("O resultado da soma é: " + resultado);
    }
}
 */

public class gpt01 {

    public static int soma (int a, int b, int c) {
        return a + b + c;
    }
    public static void mostrarResultado (int resultado) {
        System.out.println("o resultado da soma é: " + resultado);
    }


    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 7;
        int resultado = soma(a,b,c);
        mostrarResultado(resultado);


    }
}
