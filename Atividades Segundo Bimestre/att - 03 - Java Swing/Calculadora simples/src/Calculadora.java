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

    public Calculadora(){
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +1;
                txtNumTela.setText(var1.toString());
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +2;
                txtNumTela.setText(var1.toString());
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +3;
                txtNumTela.setText(var1.toString());
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +4;
                txtNumTela.setText(var1.toString());
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +5;
                txtNumTela.setText(var1.toString());
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +6;
                txtNumTela.setText(var1.toString());
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +7;
                txtNumTela.setText(var1.toString());
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +8;
                txtNumTela.setText(var1.toString());
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +9;
                txtNumTela.setText(var1.toString());
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer var1 = +0;
                txtNumTela.setText(var1.toString());
            }
        });
        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
