package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class FlowLayoutFrame extends JFrame {
    private JButton btnBotao1;
    private JButton btnBotao2;
    private JButton btnBotao3;
    private FlowLayout layout;

    public FlowLayoutFrame() {
        this.layout = new FlowLayout(FlowLayout.CENTER, 20, 20);
        this.setLayout(layout);

        this.btnBotao1 = new JButton("Botao 1");
        this.btnBotao2 = new JButton("Botao 2");
        this.btnBotao3 = new JButton("Botao 3");

        this.add(btnBotao1);
        this.add(btnBotao2);
        this.add(btnBotao3);

        this.setTitle("Exemplo de FlowLayout");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
