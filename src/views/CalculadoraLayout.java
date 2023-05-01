package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraLayout extends JFrame {
    private BorderLayout layout;
    private JPanel panel;

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
    private JButton btnComma;

    private JButton btnC;
    private JButton btnMS;
    private JButton btnMR;
    private JButton btnMC;

    private JTextField txtField;

    public CalculadoraLayout() {
        this.initComponents();
    }

    private void initComponents() {
        this.layout = new BorderLayout(20, 20);
        this.setLayout(layout);

        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        this.txtField = new JTextField("0.0");
        this.txtField.setFont(new Font("Tahoma", Font.PLAIN, 25));
        this.txtField.setHorizontalAlignment(JTextField.RIGHT);
        this.txtField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.txtField.setEnabled(false);

        this.add(txtField, BorderLayout.NORTH);

        this.panel.setLayout(new GridLayout(5, 4, 5, 5));

        defineButtons();

        addButtonsToPanel();

        this.add(panel, BorderLayout.CENTER);

        this.setTitle("Calculador");
        this.setSize(350, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addButtonsToPanel() {
        this.panel.add(btnMS);
        this.panel.add(btnMR);
        this.panel.add(btnMC);
        this.panel.add(btnC);

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

        this.panel.add(btnZero);
        this.panel.add(btnComma);
        this.panel.add(btnEquals);
        this.panel.add(btnPlus);
    }

    private void defineButtons() {
        this.btnOne = new JButton("1");
        this.btnOne.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnOne.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("1");
            } else {
                this.txtField.setText(text + "1");
            }
        });

        this.btnTwo = new JButton("2");
        this.btnTwo.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnTwo.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("2");
            } else {
                this.txtField.setText(text + "2");
            }
        });

        this.btnThree = new JButton("3");
        this.btnThree.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnThree.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("3");
            } else {
                this.txtField.setText(text + "3");
            }
        });

        this.btnFour = new JButton("4");
        this.btnFour.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnFour.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("4");
            } else {
                this.txtField.setText(text + "4");
            }
        });

        this.btnFive = new JButton("5");
        this.btnFive.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnFive.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("5");
            } else {
                this.txtField.setText(text + "5");
            }
        });

        this.btnSix = new JButton("6");
        this.btnSix.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnSix.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("6");
            } else {
                this.txtField.setText(text + "6");
            }
        });

        this.btnSeven = new JButton("7");
        this.btnSeven.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnSeven.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("7");
            } else {
                this.txtField.setText(text + "7");
            }
        });

        this.btnEight = new JButton("8");
        this.btnEight.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnEight.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("8");
            } else {
                this.txtField.setText(text + "8");
            }
        });

        this.btnNine = new JButton("9");
        this.btnNine.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnNine.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("9");
            } else {
                this.txtField.setText(text + "9");
            }
        });

        this.btnZero = new JButton("0");
        this.btnZero.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnZero.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("0");
            } else {
                this.txtField.setText(text + "0");
            }
        });

        this.btnC = new JButton("C");
        this.btnC.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnC.addActionListener(e -> {
            this.txtField.setText("0.0");
        });

        this.btnComma = new JButton(",");
        this.btnComma.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnComma.addActionListener(e -> {
            String text = this.txtField.getText();
            if (text.equals("0.0")) {
                this.txtField.setText("0.");
            } else {
                this.txtField.setText(text + ".");
            }
        });

        this.btnMS = new JButton("MS");
        this.btnMS.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnMR = new JButton("MR");
        this.btnMR.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnMC = new JButton("MC");
        this.btnMC.setFont(new Font("Tahoma", Font.PLAIN, 24));

        this.btnPlus = new JButton("+");
        this.btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnPlus.addActionListener(e -> {
            String text = this.txtField.getText();
            if (!text.equals("0.0")) {
                this.txtField.setText(text + "+");
            }
        });

        this.btnMinus = new JButton("-");
        this.btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnMinus.addActionListener(e -> {
            String text = this.txtField.getText();
            if (!text.equals("0.0")) {
                this.txtField.setText(text + "-");
            }
        });

        this.btnTimes = new JButton("*");
        this.btnTimes.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnTimes.addActionListener(e -> {
            String text = this.txtField.getText();
            if (!text.equals("0.0")) {
                this.txtField.setText(text + "*");
            }
        });

        this.btnDivide = new JButton("/");
        this.btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.btnDivide.addActionListener(e -> {
            String text = this.txtField.getText();
            if (!text.equals("0.0")) {
                this.txtField.setText(text + "/");
            }
        });

        this.btnEquals = new JButton("=");
        this.btnEquals.setFont(new Font("Tahoma", Font.PLAIN, 24));

        this.btnEquals.addActionListener(e -> {
            try {
                String[] command = { "python", "util/calculadora.py" };
                Process exec = Runtime.getRuntime().exec(command);

                OutputStream out = exec.getOutputStream();
                PrintWriter pw = new PrintWriter(out);
                
                pw.println(txtField.getText());
                pw.flush();

                InputStream in = exec.getInputStream();
                Scanner scan = new Scanner(in);

                while (scan.hasNext()) {
                    txtField.setText(scan.nextLine());
                }

                scan.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
