package pages;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraLayout extends JFrame {
    private BorderLayout layout;

    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnThree;
    private JButton btnFour;
    private JButton btnFive;
    private JButton btnSix;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnNine;
    private JButton btnZero;

    private JButton btnPlus;
    private JButton btnTimes;
    private JButton btnMinus;
    private JButton btnDivide;
    private JButton btnEquals;
    private JButton btnC;

    private JTextField txtField;

    private JPanel panel;

    public CalculadoraLayout() {
        this.layout = new BorderLayout(20, 20);
        this.setLayout(layout);

        this.panel = new JPanel();

        this.txtField = new JTextField("0.0");
        this.txtField.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.txtField.setHorizontalAlignment(JTextField.RIGHT);
        this.txtField.setEnabled(false);
        
        this.add(txtField, BorderLayout.NORTH);

        this.panel.setLayout(new GridLayout(4, 4, 5, 5));

        this.btnOne = new JButton("1");
        this.btnTwo = new JButton("2");
        this.btnThree = new JButton("3");
        this.btnFour = new JButton("4");
        this.btnFive = new JButton("5");
        this.btnSix = new JButton("6");
        this.btnSeven = new JButton("7");
        this.btnEight = new JButton("8");
        this.btnNine = new JButton("9");

        this.btnC = new JButton("C");
        this.btnPlus = new JButton("+");
        this.btnMinus = new JButton("-");
        this.btnTimes = new JButton("*");
        this.btnDivide = new JButton("/");

        this.panel.add(btnSeven);
        this.panel.add(btnOne);
        this.panel.add(btnTwo);
        this.panel.add(btnThree);
        this.panel.add(btnFour);
        this.panel.add(btnFive);
        this.panel.add(btnSix);

        this.add(panel, BorderLayout.CENTER);

        this.setTitle("Calculador");
        this.setSize(320, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
