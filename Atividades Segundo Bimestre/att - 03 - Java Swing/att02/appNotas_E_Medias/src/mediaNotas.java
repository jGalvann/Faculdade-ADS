import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// acho que da pra implementar uma linkedList, já que nsei o numero de notas.
// como vou fzr isso? nsei

public class mediaNotas {
    private JPanel panelMain;
    private JButton btnAddNota;
    private JTextArea txtAreaNotas;
    private JButton btnCalcMedia;
    private JLabel txtAprovacao;
    private JTextField txtEntradaNota;
    private JLabel txtMediaFinal;

    No no1 = new No(0.0);
    ListaEncadeada listaNotas = new ListaEncadeada();

public mediaNotas(){
    // criando a linkedList para as notas.

    btnAddNota.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            double nota = Double.valueOf(txtEntradaNota.getText());

            listaNotas.adicionarNo(nota);

            txtAreaNotas.setText(listaNotas.mostrarValores());

        }
    });
    btnCalcMedia.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        double media = listaNotas.calculoMedia();
        txtMediaFinal.setText(String.valueOf(media));
        if(media >= 7.0){
            txtAprovacao.setText("Aprovado");
        }else {
            txtAprovacao.setText("Reprovado");
        }


        }
    });

}





    public static void main(String[] args) {
            JFrame frame = new JFrame("calculadora");
            frame.setContentPane(new mediaNotas().panelMain);
            frame.pack();
            frame.setVisible(true);
    }

}

