import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiniChatBot chatbot = new MiniChatBot();
        boolean continuar = true;
        int num;

        System.out.println("Digite algo para começar: ");
        chatbot.inicio = scanner.nextLine();
        chatbot.saudacoes();


        while(continuar){

            System.out.println("faça-me uma pergunta");
            chatbot.guardaPergunta = scanner.nextLine();
            chatbot.perguntas();

            System.out.println("deseja continuar?");
            System.out.println("1 - sim ");
            System.out.println("0 - nao");
            num = scanner.nextInt();
            scanner.nextLine();

            if (num == 0){
                continuar = false;
            }

        }
    }
}