
public class MiniChatBot {

    String inicio;
    String guardaPergunta;

    public void saudacoes(){
        if(inicio != " ") {
            System.out.println("Bem vindo, sou o ChatBot");
        }
    }
    public void perguntas(){
        if (guardaPergunta.toLowerCase().contains("nome")){
            System.out.println("Sou conhecido como MiniChatBot!");
        }
        if(guardaPergunta.toLowerCase().contains("como está")||
                guardaPergunta.toLowerCase().contains("como esta")||
                guardaPergunta.toLowerCase().contains("como voce esta")||
                guardaPergunta.toLowerCase().contains("como você está")) {
            System.out.println("To funcionando legal, obrigado por perguntar");
        }
        if(guardaPergunta.toLowerCase().contains("clima")){
            System.out.println("No momento está um calor insuportável, espero ter ajudado");
        }
        if(guardaPergunta.toLowerCase().contains("")){
            System.out.println("Desculpe, não entendi");
        }


    }


}