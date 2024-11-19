import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


// entender como o JSpinner funfa ( se tem de escrever a data e hora ou clicar em algo )
// botão -> pegar a atividade e a data/hora a ser realizada e jogar para o table
// descobrir como funciona o table ( se é estilo array ou oq)
// botão de remover compromisso tem que remover a atividade SELECIONADA e não o ultimo elemento
public class Agenda {
    private JPanel panelMain;
    private JTextField txtEntradaAtt;
    private JSpinner spnData;
    private JTable tblCompromissos;
    private JButton btnAddCompromisso;
    private JButton btnRmvCompromisso;
    private JSpinner spnHora;
    private JLabel lblAviso;

    // configurando os Spinners
    private void configSpinners() {
        // aqui define o modelo do spinner para trabalhar com data
        spnData.setModel(new SpinnerDateModel());
        // .dateEditor é uma classe que serve como editor para esse modelo,
        // o JSpinner.DateEditor recebe 2 argumentos, spnData, sendo o spinner associado ao editor, e o formato da exibição ( dd/MM/yyyy)
        JSpinner.DateEditor editorData = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        // depois de criar um dateEditor, aqui ele é atribuído ao spinner
        spnData.setEditor(editorData);


        spnHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spnHora, "HH:mm");
        spnHora.setEditor(editorHora);
    }


    // construtor
    public Agenda(){
        // chamando a função que configurou os Spinners
        configSpinners();


        // criando e configurando a Table
        DefaultTableModel modeloTable = new DefaultTableModel(
                new String[]{"Compromisso", "Data", "Hora"},  0
        );
        // vinculando a table do form com essa criada
                tblCompromissos.setModel(modeloTable);


        btnAddCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // pegando os valores dos campos
                String atividade = txtEntradaAtt.getText();
                // tem que formatar as datas pq se não da uns problema legal
                String data = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                String hora = new SimpleDateFormat("HH:mm").format(spnHora.getValue());

                // checando se a atividade é null
                if(atividade.isBlank()){
                    lblAviso.setText("Favor declare o nome da atividade");
                    // textinho em vermelho pq sim, chique elegante
                    lblAviso.setForeground(Color.red);
                }else{
                // add os valores na tabela
                modeloTable.addRow(new Object[]{atividade, data, hora});

                // limpa o txtfield
                txtEntradaAtt.setText("");
                lblAviso.setText("");
                }
            }
        });

        btnRmvCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int linhaSelecionada = tblCompromissos.getSelectedRow();

                if(linhaSelecionada != -1) {
                    modeloTable.removeRow(linhaSelecionada);
                    lblAviso.setText("");
                }else {
                    lblAviso.setText("Selecione um compromisso para remover");
                    lblAviso.setForeground(Color.red);
                }


            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda");
        frame.setContentPane(new Agenda().panelMain);
        frame.setSize(300,400);
        frame.setVisible(true);
    }


}
