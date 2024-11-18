import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// passos
// primeiro tem que pegar as informações no textField
// depois tem que usar o botão para jogar elas de maneira organizada para o LIST
// e implementar o botão para remover o ultimo adicionado
// não pode ter entrada nula!
public class CadastroDeContatos {
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAddCtt;
    private JList<String> listaContatos;
    private JButton btnRemoverCtt;
    private JPanel panelMain;
    private JLabel lblMensagem;


    // aparentemente o JList não pode ser utilizado diretamente com arrays, tem que usar um modelo aí para add e remover elementos

    DefaultListModel<String> modelo = new DefaultListModel<>(); // aq é onde os contatos vao ser armazenados


// construtor
    public CadastroDeContatos() {

        listaContatos.setModel(modelo); // vincula o modelo com a lista

        btnAddCtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // metodo trim é usado para remover espaços no inicio e final do texto
                String nome = txtNome.getText().trim();
                String telefone = txtTelefone.getText().trim();
                String email = txtEmail.getText().trim();

                // agora checando se estão vazios

                if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()){
                    lblMensagem.setText("Todos os campos devem ser preenchidos");
                    return;
                    // esse return impede que o código continue
                }
                    lblMensagem.setText(""); // reseta o label

                String contato = nome + ", " + telefone + ", " + email;

                modelo.addElement(contato); // com esse modelo aq não precisa usar loop para trabalhar com arrays ( e nem arrays )

                // reseta as infos do contato
                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");


            }
        });

        btnRemoverCtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(modelo.getSize() > 0){ // checa se tem algo na lista
                    int ultimoElemento = modelo.getSize() - 1;  // se tiver, pega o último elemento
                    modelo.removeElementAt(ultimoElemento);   // remove o ultimo ( tem q ser removeElementAt pq esse usa o index, o outro espera um objeto
                } else {
                    lblMensagem.setText("Não há contatos para remover");
                }



            }
        });


    }













    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastroDeContatos().panelMain);
        frame.pack();
        frame.setVisible(true);

    }
}


