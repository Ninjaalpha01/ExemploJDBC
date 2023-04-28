package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
        this.panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        this.txtField = new JTextField("0.0");
        this.txtField.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.txtField.setHorizontalAlignment(JTextField.RIGHT);
        this.txtField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.txtField.setEnabled(false);
        
        this.add(txtField, BorderLayout.NORTH);

        this.panel.setLayout(new GridLayout(4, 4, 5, 5));

        defineButtons();
        addButtonsToPanel();

        this.add(panel, BorderLayout.CENTER);

        this.setTitle("Calculador");
        this.setSize(320, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addButtonsToPanel() {
        this.panel.add(btnSeven);
        this.panel.add(btnEight);
        this.panel.add(btnNine);
        this.panel.add(btnDivide);
        this.panel.add(btnFour);
        this.panel.add(btnFive);
        this.panel.add(btnSix);
        this.panel.add(btnTimes);
        this.panel.add(btnOne);
        this.panel.add(btnTwo);
        this.panel.add(btnThree);
        this.panel.add(btnMinus);
        this.panel.add(btnC);
        this.panel.add(btnZero);
        this.panel.add(btnEquals);
        this.panel.add(btnPlus);
    }

    private void defineButtons() {
        this.btnOne = new JButton("1");
        this.btnOne.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnTwo = new JButton("2");
        this.btnTwo.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnThree = new JButton("3");
        this.btnThree.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnFour = new JButton("4");
        this.btnFour.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnFive = new JButton("5");
        this.btnFive.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnSix = new JButton("6");
        this.btnSix.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnSeven = new JButton("7");
        this.btnSeven.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnEight = new JButton("8");
        this.btnEight.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnNine = new JButton("9");
        this.btnNine.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnZero = new JButton("0");
        this.btnZero.setFont(new Font("Tahoma", Font.BOLD, 25));

        this.btnC = new JButton("C");
        this.btnC.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnPlus = new JButton("+");
        this.btnPlus.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnMinus = new JButton("-");
        this.btnMinus.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnTimes = new JButton("*");
        this.btnTimes.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnDivide = new JButton("/");
        this.btnDivide.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.btnEquals = new JButton("=");
        this.btnEquals.setFont(new Font("Tahoma", Font.BOLD, 25));
    }
}
