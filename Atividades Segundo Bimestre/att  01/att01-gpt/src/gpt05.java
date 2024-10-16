// Verificação de número primo

/*

public class Main {
    public static void main(String[] args) {
        int numero = 17;
        boolean primo = true;

        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println(numero + " é um número primo.");
        } else {
            System.out.println(numero + " não é um número primo.");
        }
    }
}
 */
public class gpt05 {

    public static void numPrimo (int num) {

        boolean primo = true;
        // começa no 2 pq tirar mod de 0 e 1 n muda nd
        for (int i=2; i < num; i++){
            if (num % i == 0) {
                primo = false;
                break;
            }
        }
        if (primo) {
            System.out.println("o número " + num + " é um número primo");
        } else {
            System.out.println("o número " + num + " não e primo");
        }


    }


    public static void main(String[] args) {
        int num = 8;
        numPrimo(num);


    }
}
