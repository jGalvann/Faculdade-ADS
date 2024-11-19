
public class MiniChatBot {

    String inicio;
    String guardaPergunta;

    public void saudacoes() {
        if (inicio != " ") {
            System.out.println("Bem vindo, sou o ChatBot");
        }
    }

    public void perguntas() {


        if (guardaPergunta.toLowerCase().contains("nome")) {
            System.out.println("Sou conhecido como MiniChatBot!");

        } else if (guardaPergunta.toLowerCase().contains("como está") ||
                guardaPergunta.toLowerCase().contains("como esta") ||
                guardaPergunta.toLowerCase().contains("como voce esta") ||
                guardaPergunta.toLowerCase().contains("como você está")) {
            System.out.println("To funcionando legal, obrigado por perguntar");

        } else if (guardaPergunta.toLowerCase().contains("clima")) {
            System.out.println("No momento está um calor insuportável, espero ter ajudado");
        } else if (
                !guardaPergunta.toLowerCase().contains("nome") &&
                        !guardaPergunta.toLowerCase().contains("como esta") &&
                        !guardaPergunta.toLowerCase().contains("clima") &&
                        !guardaPergunta.toLowerCase().contains("como voce está") &&
                        !guardaPergunta.equals("1")

        ) {
            System.out.println("Desculpe, não entendi");
        }

    }
}