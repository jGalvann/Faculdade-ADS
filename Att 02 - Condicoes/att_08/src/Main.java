import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual a temperatura?");
        int temp = scanner.nextInt();

        if(temp >= 30){
            System.out.println("tá quente");
        } else if (temp < 30 && temp >= 15) {
            System.out.println("tá agradavel");
        } else {
            System.out.println("Friozim");
        }




    }
}