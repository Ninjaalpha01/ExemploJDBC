package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Evento extends JFrame {
    private JLabel lblDigite;
    private JLabel lblResultado;
    private JTextField txtTexto;
    private JButton btnCapturar;

    private FlowLayout layout;

    public Evento() {
        this.initComponents();
    }

    private void initComponents() {
        this.layout = new FlowLayout(FlowLayout.CENTER, 15, 20);
        this.setLayout(layout);

        this.lblDigite = new JLabel("Digite");
        this.lblResultado = new JLabel("<O texto aparecera aqui>");
        
        this.txtTexto = new JTextField("Digite aqui o texto...");
        this.txtTexto.setColumns(25);
        this.txtTexto.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                txtTextoFocusGained();
            }
            
            @Override
            public void focusLost(FocusEvent arg0) {
                lblDigite.setText("digita ae");
            }
        });

        this.btnCapturar = new JButton("Capturar");
        this.btnCapturar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                lblResultado.setText(txtTexto.getText());
            }
        });

        this.windowListener();

        this.add(this.lblDigite);
        this.add(this.txtTexto);
        this.add(this.btnCapturar);
        this.add(this.lblResultado);

        this.setTitle("Exemplo de Eventos");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void txtTextoFocusGained() {
        lblDigite.setText("digitado");
        txtTexto.setText("");
    }

    private void windowListener() {
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowClosed(WindowEvent arg0) {
            }

            @Override
            public void windowClosing(WindowEvent arg0) {
                System.out.println("Bye bye");
            }

            @Override
            public void windowDeactivated(WindowEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowDeiconified(WindowEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowIconified(WindowEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowOpened(WindowEvent arg0) {
                System.out.println("Hello");
            }
            
        });
    }
}
