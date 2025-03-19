public class Main {
    public static void main(String[] args) {

        int[] num = new int[2];
        num[0] = 5;
        num[1] = 10;

        System.out.println(num[0] + " " + " " + num[1]);

        int aux = num[0];
        num[0] = num[1];
        num[1] = aux;

        System.out.println(num[0]+  " `" + " " +  num[1]);


    }
}
