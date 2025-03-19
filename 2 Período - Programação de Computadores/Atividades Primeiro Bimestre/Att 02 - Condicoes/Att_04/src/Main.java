import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String usuario = "padrao";
        String senhaOrig = "123";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual seu usuario?");
        String user = scanner.nextLine();
        System.out.println("Qual a senha?");
        String senha = scanner.nextLine();



    if (usuario.equals(user) && senhaOrig.equals(senha)){
        System.out.println("Logado com Sucesso");
    } else {
        System.out.println("Informações incorretas");
    }


    }
}