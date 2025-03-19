// tentativa de criar uma lista encadeada

class No {

    // valor armazenado no nó
    private double valor;
    // referencia para o próximo nó
    private No next;


    // construtor
    // aq informa qual tipo de informação vai ter dentro do nó
    public No(double valor) {
        // aq armazena o valor no nó
        this.valor = valor;
        // e aq faz referencia para o próximo ( como nsei se tem proximo ele fica em null )
        this.next = null;
    }

    // getter | setter

    // primeiro tem q fzr esses 2 metodos para o "valor", e depois para o "next"
    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }


    // metodo para o next

    // esse next tem 2 atributos, o atributo Double, e o atributo No
    // o tipo é No
    public No getNext() {
        return next;
    }
    // aq n retorna nd qndo for chamado -> void
    public void setNext(No next) {
        this.next = next;
    }
}
// ------ até aqui foi a criação do nó, mas precisa de uma outra classe para gerenciar essas fita

class ListaEncadeada {
    // inicio da lista || primeiro nó
    private No head;

    // metodo construtor da lista
// começa com o head zerado
    public ListaEncadeada(){
        this.head = null;
    }

    public void adicionarNo(double valor) {
        // cria um novo nó com o valor
        No newNode = new No(valor);

        if(head == null) {          // aqui checa se a lista ta vazia
            head = newNode;         // se estiver, o novo nó se torna o HEAD
        } else {
            No atual = head;        // começa no head
            while(atual.getNext()!= null) {     // aqui percorre até o ultimo nó
                atual = atual.getNext();
            }
            atual.setNext(newNode);     // e aqui define um nó novo como próximo do último
        }
    // a variavel "atual" é uma var temporária que serve para começar a percorrer a lista.
    // ela ajuda a andar um nó por vez até o ultimo, aquele que tu quer add o valor novo
        }
        // aparentemente tem que criar um metodo para mostrar os valores tb


    // metodo para exibir os valores da lista
    public String mostrarValores(){
        // stringbuilder é uma classe que permite operar string dinamicamente.
        StringBuilder valores = new StringBuilder();
        No atual = head;    // faz começar do primeiro nó
        while(atual!= null){
            valores.append(atual.getValor()).append("\n");  // aqui adiciona o valor na string
            atual = atual.getNext(); // anda para o prox nó
        }
        return valores.toString();
    }

    public double calculoMedia(){

        if(head == null){
            return 0;
        }

        double soma = 0;
        int contador = 0;
        No atual = head;

        while(atual!=null){
            soma += atual.getValor(); // pega o valor do nó e vai somando
            contador++;               // conta quanto valores foram somados
            atual = atual.getNext();  // anda para o prox nó ( ou aponta, nsei como fala ainda )

        }
        return  soma / contador; // retorna a media

    }


    }


















