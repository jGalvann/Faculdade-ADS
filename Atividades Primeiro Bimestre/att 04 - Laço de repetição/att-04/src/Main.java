import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int age;
        do{
            System.out.println("Qual sua idade?");
            age = scanner.nextInt();

        }while(age < 18);

        System.out.println("De fato maior de idade");


    }
}