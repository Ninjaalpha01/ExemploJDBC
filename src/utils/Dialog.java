package utils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog frame = new Dialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 313, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 25));
		
		JButton btnInfoDialog = new JButton("Mensagem de Informacao");
		btnInfoDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnInfoDialog, "Mensagem de Informacao", "Informacao", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnInfoDialog);
		
		JButton btnWarningDialog = new JButton("Mensagem de Advertencia");
		btnWarningDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnWarningDialog, "Mensagem de Advertencia", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		});
		contentPane.add(btnWarningDialog);
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		contentPane.add(btnNewButton_4);
		
		JButton btnDataEntry = new JButton("Calcular");
		btnDataEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double x = Double.parseDouble(JOptionPane.showInputDialog(btnDataEntry, "Insira o primeiro valor", "Entrada 1", JOptionPane.QUESTION_MESSAGE));
				Double y = Double.parseDouble(JOptionPane.showInputDialog(btnDataEntry, "Insira o primeiro valor", "Entrada 2", JOptionPane.QUESTION_MESSAGE));
				
				Double sum = x + y;
				Double sub = x - y;
				Double mul = x * y;
				Double div = x / y;

				JOptionPane.showMessageDialog(btnDataEntry, "soma = " + sum + "\nsubt = " + sub + "\nmult = " + mul + "\ndivi = " + div, "Resposta", JOptionPane.PLAIN_MESSAGE);
			}
		});
		contentPane.add(btnDataEntry);

		JButton btnConfirmDialog = new JButton("Confirmacao");
		btnConfirmDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(btnConfirmDialog, "Deseja confirmar a acao?", "Confirmacao", JOptionPane.YES_NO_CANCEL_OPTION);
				System.out.println("Confirmou? " + confirmacao);
			}
		});
		contentPane.add(btnConfirmDialog);
	}

}
