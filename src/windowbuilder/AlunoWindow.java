package windowbuilder;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import entities.Curso;
import service.CursoService;

import javax.swing.JScrollPane;

public class AlunoWindow extends JFrame {
	private JTextField txtTxtregistroacademico;
	private JTextField txtTxtnome;
	private JFormattedTextField txtDataIngresso;
	private JTextField txtCoeficiente;
	private JTable tableAlunos;
	private JMenuBar menuBar;
	private MaskFormatter mascaraData;
	private ButtonGroup btnGroupSexo;

	private CursoService cursoService;
	private JComboBox<String> cbCurso;

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoWindow frame = new AlunoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AlunoWindow() {
		this.createMaskDate();
		this.initComponent();

		this.cursoService = new CursoService();
		this.buscarCursos();
	}

	private void buscarCursos() {
		ArrayList<Curso> cursos = this.cursoService.buscarTodos();

		for (Curso curso : cursos) {
			this.cbCurso.addItem(curso.getNome());
		}
	}

	private void createMaskDate() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
			this.txtDataIngresso = new JFormattedTextField(this.mascaraData);
		} catch (ParseException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 450);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistroAcadmico = new JLabel("Registro Acadêmico");
		lblRegistroAcadmico.setBounds(12, 12, 139, 15);
		contentPane.add(lblRegistroAcadmico);

		txtTxtregistroacademico = new JTextField();
		txtTxtregistroacademico.setBounds(171, 10, 160, 19);
		contentPane.add(txtTxtregistroacademico);
		txtTxtregistroacademico.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 39, 70, 15);
		contentPane.add(lblNome);

		txtTxtnome = new JTextField();
		txtTxtnome.setBounds(79, 39, 468, 19);
		contentPane.add(txtTxtnome);
		txtTxtnome.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 66, 165, 120);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(24, 24, 96, 23);
		panel.add(rdbtnMasculino);

		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(24, 51, 89, 23);
		panel.add(rdbtnFeminino);

		JRadioButton rdbtnNoInformar = new JRadioButton("Não Informar");
		rdbtnNoInformar.setBounds(24, 78, 117, 23);
		panel.add(rdbtnNoInformar);

		// agrupa os radio buttons relacionados ao sexo
		btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnFeminino);
		btnGroupSexo.add(rdbtnNoInformar);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(195, 70, 70, 15);
		contentPane.add(lblCurso);

		JLabel lblDataIngresso = new JLabel("Data de ingresso");
		lblDataIngresso.setBounds(195, 118, 122, 15);
		contentPane.add(lblDataIngresso);

		JLabel lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setBounds(195, 162, 80, 15);
		contentPane.add(lblCoeficiente);

		cbCurso = new JComboBox<String>();
		cbCurso.setBounds(259, 70, 288, 19);
		contentPane.add(cbCurso);

		txtDataIngresso.setBounds(328, 116, 96, 19);
		contentPane.add(txtDataIngresso);
		txtDataIngresso.setColumns(10);

		JLabel lblPerodo = new JLabel("Período");
		lblPerodo.setBounds(444, 118, 70, 15);
		contentPane.add(lblPerodo);

		JSpinner spPeriodo = new JSpinner();
		spPeriodo.setBounds(506, 116, 41, 20);
		contentPane.add(spPeriodo);

		txtCoeficiente = new JTextField();
		txtCoeficiente.setBounds(310, 160, 114, 19);
		contentPane.add(txtCoeficiente);
		txtCoeficiente.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 200, 535, 10);
		contentPane.add(separator);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.setBounds(405, 214, 142, 25);
		contentPane.add(btnLimparCampos);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(276, 214, 117, 25);
		contentPane.add(btnCadastrar);

		JPanel painelAlunos = new JPanel();
		painelAlunos.setBorder(new TitledBorder(null, "Alunos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelAlunos.setBounds(12, 251, 535, 120);
		contentPane.add(painelAlunos);
		painelAlunos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 26, 511, 82);
		painelAlunos.add(scrollPane);
		
				tableAlunos = new JTable();
				scrollPane.setViewportView(tableAlunos);
				tableAlunos.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"RA", "Nome", "Sexo", "Curso", "Data do Ingresso", "Per\u00EDodo", "Coeficiente"
					}
				));
				tableAlunos.getColumnModel().getColumn(4).setPreferredWidth(137);
				tableAlunos.getColumnModel().getColumn(6).setPreferredWidth(92);
	}
}
