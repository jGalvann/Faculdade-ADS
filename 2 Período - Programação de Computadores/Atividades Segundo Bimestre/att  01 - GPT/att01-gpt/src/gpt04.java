// Tabuada de um número

/*

public class Main {
    public static void main(String[] args) {
        int numero = 6;
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
}
 */
public class gpt04 {

    public static void tabuada (int numero) {

        for (int i = 1; i <= 10; i++){
            int resultado = numero * i;
            System.out.println(numero + " X " + i + " = " + resultado);
        }
    }



    public static void main(String[] args) {
        int num = 5;
        tabuada(num);

    }
}
