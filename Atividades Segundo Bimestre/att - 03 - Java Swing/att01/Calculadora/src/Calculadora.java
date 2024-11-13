import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JButton btnLimpar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JButton btnSubtrair;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnSomar;
    private JButton btn6;
    private JButton btn1;
    private JButton btn5;
    private JButton btn2;
    private JButton btn4;
    private JButton btn3;
    private JButton btnResultado;
    private JButton btn0;
    private JTextField txtNumTela;
    private JPanel panelMain;

//---------------------------------------------------------------------------------------------------------------
    // instanciando para poder usar nas operações

    private CalcOperations calcOperations = new CalcOperations();
    // metodo para os botões 0 - 9


//---------------------------------------------------------------------------------------------------------------
    // anotações -> .equals() compara o conteúdo do obj || '== ' compara o endereço da memória ( se apontam para a msm fita )
    // usa-se == para tipos primitivos ( int, double, char, bool... ) e .equals() para conteúdo de objetos ( String, integer... )
    public  void digita(String texto){
        if(txtNumTela.getText().equals("0")){
            txtNumTela.setText(texto);
        } else {
            txtNumTela.setText(txtNumTela.getText().concat(texto));
        }
    }
    // .concat() da no mesmo que escrever + "...."

//---------------------------------------------------------------------------------------------------------------
    // metodo para limpar o txtfield
    public void limpa(){
        txtNumTela.setText("0.0");
    }

    // ---------------------------------------------------------------------------------------------------------------

    // metodo para realizar as operações

    public static class CalcOperations {
        // aq defini dentro desse escopo as var q vou usar
        public String operacao;
        public Double total;

        // definir a operação e o valor inicial
        // nsei bem oq isso faz, mas ta funcionando ( vou procurar exatamente o motivo )
        public void setOperacao(String operacao, double valor) {
            this.operacao = operacao;
            this.total = valor;
        }

        // chega qual operação é para realizar, e a executa
        public double realizaOperacao(double valor){
            if(operacao.equals("soma")){
                total+=valor;
            }else if(operacao.equals("subtrair")){
                total -= valor;
            }else if(operacao.equals("dividir")){
                total /= valor;
            }else if(operacao.equals("multiplicar")){
                total *= valor;
            }
            return total;
        }
        // devolve o total
        public Double getTotal(){
            return this.total;
        }
        // zera
        public void zerar(){
            total = 0.0;
        }
    }


// --------------------------------------------------------------------------------------------------------------



//---------------------------------------------------------------------------------------------------------------
    public Calculadora(){

// btn1 ao ao btn 0 -- add o numero do botão conforme espeficicado dentro da função "digita"
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("9");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digita("0");
            }
        });
        // ------ botões que fazem algo sem ser add num ------ //

        // basicamente envia um texto zerado para mostrar
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpa();
            }
        });

        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transforma a string de num em double ( para realizar as continha )
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                // checa qual operação é para ser realizada e executa a conta.
                calcOperations.setOperacao("soma", valorAtual);
                // limpa a tela para o prox num
                txtNumTela.setText("0");
            }
        });
        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("subtrair", valorAtual);
                // limpa a tela para o prox num
                txtNumTela.setText("0");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("multiplicar", valorAtual);
                // limpa a tela para o prox num
                txtNumTela.setText("0");
            }
        });
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                calcOperations.setOperacao("dividir", valorAtual);
                // limpa a tela para o prox num
                txtNumTela.setText("0");
            }
        });

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorAtual = Double.parseDouble(txtNumTela.getText());
                double resultado = calcOperations.realizaOperacao(valorAtual);

                // Exibe o resultado no visor
                txtNumTela.setText(Double.toString(resultado));

                // Zera a operação atual para q n de conflito com a próxima.
                calcOperations.zerar();
            }
        });


    }


//---------------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {
        JFrame frame = new JFrame("calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.pack();
        frame.setVisible(true);
    }
}

