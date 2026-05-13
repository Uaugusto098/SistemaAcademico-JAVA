package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import java.awt.TextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtRaNotas;
	private JTextField txtNomeNotas;
	private JTextField txtCursoNotas;
	private JTextField txtFaltas;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1169, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(235, 117, 687,349);
		contentPane.add(tabbedPane);
		
		
		//Instanciando os paineis
		JPanel panelDados = new JPanel();
		JPanel panelCurso = new JPanel();
		JPanel  panelNotasFaltas= new JPanel();
		JPanel panelBoletim=new JPanel();
		
		//Definindo os paineis de navegação 
		panelDados.setLayout(null);
		panelCurso.setLayout(null);
		panelNotasFaltas.setLayout(null);
		panelBoletim.setLayout(null);
		
		
		
		//ABA DADOS PESSOAIS**************
		tabbedPane.addTab("Dados Pessoais",null,panelDados,"Informações do Aluno");
		
		JLabel lblNewLabel = new JLabel("RA");
		lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel.setBounds(21, 24, 46, 14);
		panelDados.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(51, 22, 158, 20);
		panelDados.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 66, 57, 14);
		panelDados.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(21, 114, 162, 14);
		panelDados.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(77, 64, 158, 20);
		panelDados.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(193, 114, 158, 20);
		panelDados.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(21, 174, 57, 14);
		panelDados.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(107, 211, 158, 20);
		panelDados.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(77, 172, 158, 20);
		panelDados.add(textField_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endereço");
		lblNewLabel_1_2.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(21, 213, 89, 14);
		panelDados.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
		lblNewLabel_1_1_2.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(370, 24, 46, 14);
		panelDados.add(lblNewLabel_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(414, 22, 158, 20);
		panelDados.add(textField_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 149, 666, 14);
		panelDados.add(separator);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Município");
		lblNewLabel_1_1_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(366, 176, 83, 14);
		panelDados.add(lblNewLabel_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(452, 172, 158, 20);
		panelDados.add(textField_6);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("UF");
		lblNewLabel_1_2_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(366, 215, 76, 14);
		panelDados.add(lblNewLabel_1_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(410, 210, 30, 22);
		panelDados.add(comboBox);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Celular");
		lblNewLabel_1_1_2_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(370, 68, 57, 14);
		panelDados.add(lblNewLabel_1_1_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(437, 64, 158, 20);
		panelDados.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setBounds(21, 263, 89, 47);
		panelDados.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Alterar");
		btnNewButton_1_1.setBounds(140, 263, 89, 47);
		panelDados.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Consultar");
		btnNewButton_1_2.setBounds(270, 263, 89, 47);
		panelDados.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Excluir");
		btnNewButton_1_3.setBounds(400, 263, 89, 47);
		panelDados.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Sair");
		
		
		//ABA CURSO DO ALUNO********************
		btnNewButton_1_4.setBounds(537, 263, 89, 47);
		panelDados.add(btnNewButton_1_4);
		tabbedPane.addTab("Cursos",null,panelCurso,"Curso do Aluno");
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblCurso.setBounds(10, 31, 46, 14);
		panelCurso.add(lblCurso);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblCampus.setBounds(10, 73, 58, 14);
		panelCurso.add(lblCampus);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblPeriodo.setBounds(10, 112, 58, 14);
		panelCurso.add(lblPeriodo);
		
		JComboBox cmbCursos = new JComboBox();
		cmbCursos.setBounds(96, 28, 286, 22);
		panelCurso.add(cmbCursos);
		
		JComboBox cmbCampus = new JComboBox();
		cmbCampus.setBounds(96, 70, 286, 22);
		panelCurso.add(cmbCampus);
		
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		buttonGroup.add(rdbtnMatutino);
		rdbtnMatutino.setFont(new Font("Dubai", Font.PLAIN, 14));
		buttonGroup.add(rdbtnMatutino);
		rdbtnMatutino.setBounds(106, 109, 79, 23);
		panelCurso.add(rdbtnMatutino);
		
		JRadioButton rdbtnVespertino = new JRadioButton("Vespertino");
		buttonGroup.add(rdbtnVespertino);
		rdbtnVespertino.setFont(new Font("Dubai", Font.PLAIN, 14));
		buttonGroup.add(rdbtnVespertino);
		rdbtnVespertino.setBounds(187, 109, 89, 23);
		panelCurso.add(rdbtnVespertino);
		
		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		buttonGroup.add(rdbtnNoturno);
		rdbtnNoturno.setFont(new Font("Dubai", Font.PLAIN, 14));
		buttonGroup.add(rdbtnNoturno);
		rdbtnNoturno.setBounds(278, 109, 74, 23);
		panelCurso.add(rdbtnNoturno);
		
		JButton btnSalvarNotas_1 = new JButton("Salvar");
		btnSalvarNotas_1.setBounds(32, 265, 89, 45);
		panelCurso.add(btnSalvarNotas_1);
		
		JButton btnAlterarNotas_1 = new JButton("Alterar");
		btnAlterarNotas_1.setBounds(158, 265, 89, 45);
		panelCurso.add(btnAlterarNotas_1);
		
		JButton btnConsultarNotas_1 = new JButton("Consultar");
		btnConsultarNotas_1.setBounds(289, 265, 89, 45);
		panelCurso.add(btnConsultarNotas_1);
		
		JButton btnExcluirNotas_1 = new JButton("Excluir");
		btnExcluirNotas_1.setBounds(419, 265, 89, 45);
		panelCurso.add(btnExcluirNotas_1);
		
		JButton btnSairNotas_1 = new JButton("Sair");
		btnSairNotas_1.setBounds(549, 265, 89, 45);
		panelCurso.add(btnSairNotas_1);
		
		JButton btnSalvar2 = new JButton("");
		btnSalvar2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		//ABA NOTAS E FALTAS*****************
		tabbedPane.addTab("Notas e Faltas",null,panelNotasFaltas,"Notas e faltas do aluno");
		JLabel lblRa = new JLabel("RA");
		lblRa.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblRa.setBounds(10, 25, 46, 14);
		panelNotasFaltas.add(lblRa);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDisciplina.setBounds(10, 118, 88, 24);
		panelNotasFaltas.add(lblDisciplina);
		
		JComboBox cmbCursoNotas = new JComboBox();
		cmbCursoNotas.setBounds(99, 122, 383, 22);
		panelNotasFaltas.add(cmbCursoNotas);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblSemestre.setBounds(10, 181, 81, 24);
		panelNotasFaltas.add(lblSemestre);
		
		JComboBox cmbSemestre = new JComboBox();
		cmbSemestre.setBounds(99, 185, 94, 22);
		panelNotasFaltas.add(cmbSemestre);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNota.setBounds(234, 181, 38, 24);
		panelNotasFaltas.add(lblNota);
		
		JComboBox cmbSemestre_1 = new JComboBox();
		cmbSemestre_1.setBounds(282, 185, 53, 22);
		panelNotasFaltas.add(cmbSemestre_1);
		
		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblFaltas.setBounds(389, 181, 53, 24);
		panelNotasFaltas.add(lblFaltas);
		
		JButton btnExcluirNotas = new JButton("Excluir");
		btnExcluirNotas.setBounds(413, 268, 89, 45);
		panelNotasFaltas.add(btnExcluirNotas);
		
		JButton btnSairNotas = new JButton("Sair");
		btnSairNotas.setBounds(543, 268, 89, 45);
		panelNotasFaltas.add(btnSairNotas);
		
		JButton btnConsultarNotas = new JButton("Consultar");
		btnConsultarNotas.setBounds(283, 268, 89, 45);
		panelNotasFaltas.add(btnConsultarNotas);
		
		JButton btnAlterarNotas = new JButton("Alterar");
		btnAlterarNotas.setBounds(152, 268, 89, 45);
		panelNotasFaltas.add(btnAlterarNotas);
		
		JButton btnSalvarNotas = new JButton("Salvar");
		btnSalvarNotas.setBounds(26, 268, 89, 45);
		panelNotasFaltas.add(btnSalvarNotas);
		
		txtRaNotas = new JTextField();
		txtRaNotas.setColumns(10);
		txtRaNotas.setBounds(43, 25, 198, 20);
		panelNotasFaltas.add(txtRaNotas);
		
		txtNomeNotas = new JTextField("Deverá mostrar o nome do Aluno");
		txtNomeNotas.setEditable(false);
		txtNomeNotas.setColumns(10);
		txtNomeNotas.setBounds(284, 25, 369, 20);
		panelNotasFaltas.add(txtNomeNotas);
		
		txtCursoNotas = new JTextField("Deverá mostrar o curso do Aluno");
		txtCursoNotas.setEditable(false);
		txtCursoNotas.setColumns(10);
		txtCursoNotas.setBounds(26, 70, 627, 20);
		panelNotasFaltas.add(txtCursoNotas);
		
		txtFaltas = new JTextField();
		txtFaltas.setColumns(10);
		txtFaltas.setBounds(445, 186, 102, 20);
		panelNotasFaltas.add(txtFaltas);
		
		
		//ABA BOLETIM***********************
		tabbedPane.addTab("Boletim",null,panelBoletim,"Boletim Completo");
		
		
		contentPane.add(tabbedPane);
		
		

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
