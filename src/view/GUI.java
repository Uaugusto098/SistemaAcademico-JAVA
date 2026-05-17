package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JFormattedTextField;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;

import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import dao.CursoDAO;

// Importações do modelo do grupo
import model.Aluno;
import model.Desempenho;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtRaNotas;
	private JTextField txtNomeNotas;
	private JTextField txtCursoNotas;
	private JTextField txtFaltas;
	private JComboBox cmbCursos;
	private JComboBox cmbCampus;
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	// Componentes globais da aba Boletim
	private JLabel lblRgmBoletim;
	private JLabel lblNomeBoletim;
	private JLabel lblCursoBoletim;
	private JTable tabelaBoletim;
	private DefaultTableModel modeloTabelaBoletim;

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
	public GUI() throws Exception {
		
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
		
		try {
			JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextField.setBounds(181, 112, 65, 20);
			panelDados.add(formattedTextField);
			
			JFormattedTextField formattedTextField_1 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			formattedTextField_1.setBounds(410, 22, 109, 20);
			panelDados.add(formattedTextField_1);
		} catch (Exception e) {
			System.err.println("Erro ao inicializar formatação de máscaras: " + e.getMessage());
		}
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedTextField.setBounds(181, 112, 65, 20);
		panelDados.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formattedTextField_1.setBounds(410, 22, 109, 20);
		panelDados.add(formattedTextField_1);
		tabbedPane.addTab("Cursos",null,panelCurso,"Curso do Aluno");
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblCurso.setBounds(10, 31, 76, 14);
		panelCurso.add(lblCurso);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblCampus.setBounds(10, 64, 76, 28);
		panelCurso.add(lblCampus);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblPeriodo.setBounds(10, 112, 76, 14);
		panelCurso.add(lblPeriodo);
		
		cmbCursos = new JComboBox();
		cmbCursos.setBounds(96, 28, 286, 22);
		panelCurso.add(cmbCursos);
		
		cmbCampus = new JComboBox();
		cmbCampus.setBounds(96, 70, 286, 22);
		panelCurso.add(cmbCampus);
		
		// Remova o "JRadioButton" do início destas linhas:
		rdbtnMatutino = new JRadioButton("Matutino");
		buttonGroup.add(rdbtnMatutino);
		rdbtnMatutino.setFont(new Font("Dubai", Font.PLAIN, 14));
		rdbtnMatutino.setBounds(106, 109, 79, 23);
		panelCurso.add(rdbtnMatutino);
		
		rdbtnVespertino = new JRadioButton("Vespertino");
		buttonGroup.add(rdbtnVespertino);
		rdbtnVespertino.setFont(new Font("Dubai", Font.PLAIN, 14));
		rdbtnVespertino.setBounds(187, 109, 89, 23);
		panelCurso.add(rdbtnVespertino);
		
		rdbtnNoturno = new JRadioButton("Noturno");
		buttonGroup.add(rdbtnNoturno);
		rdbtnNoturno.setFont(new Font("Dubai", Font.PLAIN, 14));
		rdbtnNoturno.setBounds(278, 109, 74, 23);
		panelCurso.add(rdbtnNoturno);

		
		JButton btnSalvarCursos= new JButton("");
		btnSalvarCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/save_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnSalvarCursos.setBounds(32, 265, 89, 45);
		panelCurso.add(btnSalvarCursos);
		
		btnSalvarCursos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            //Valida o RA
		            String ra = textField.getText().trim();
		            if (ra.isEmpty()) {
		                JOptionPane.showMessageDialog(null,
		                    "Informe o RA do aluno na aba 'Dados Pessoais' antes de salvar o curso.");
		                return;
		            }

		            //Valida combos
		            if (cmbCursos.getSelectedItem() == null || cmbCampus.getSelectedItem() == null) {
		                JOptionPane.showMessageDialog(null,
		                    "Selecione um Curso e um Campus.");
		                return;
		            }

		            String cursoSelecionado  = cmbCursos.getSelectedItem().toString();
		            String campusSelecionado = cmbCampus.getSelectedItem().toString();

		            //Valida período
		            String periodoSelecionado = "";
		            if      (rdbtnMatutino.isSelected())  periodoSelecionado = "Matutino";
		            else if (rdbtnVespertino.isSelected()) periodoSelecionado = "Vespertino";
		            else if (rdbtnNoturno.isSelected())    periodoSelecionado = "Noturno";

		            if (periodoSelecionado.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Selecione um Período.");
		                return;
		            }

		            //Descobre o codCurso
		            dao.CursoDAO cursoDAO = new dao.CursoDAO();
		            int codCurso = cursoDAO.descobrirCodCurso(
		                cursoSelecionado, campusSelecionado, periodoSelecionado);

		            if (codCurso == 0) {
		                JOptionPane.showMessageDialog(null,
		                    "Combinação de Curso, Campus e Período não encontrada no sistema.");
		                return;
		            }

		            //Salva o vínculo
		            dao.AlunoDAO alunoDAO = new dao.AlunoDAO();
		            alunoDAO.salvarCursoDoAluno(ra, codCurso);

		            JOptionPane.showMessageDialog(null,
		                "Curso vinculado com sucesso!\n\n" +
		                "RA: "      + ra               + "\n" +
		                "Curso: "   + cursoSelecionado  + "\n" +
		                "Campus: "  + campusSelecionado  + "\n" +
		                "Período: " + periodoSelecionado + "\n" +
		                "ID do Curso: " + codCurso);

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null,
		                "Erro ao salvar curso: " + ex.getMessage());
		        }
		    }
		});
		
		JButton btnAlterarCursos = new JButton("");
		btnAlterarCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/update_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnAlterarCursos.setBounds(158, 265, 89, 45);
		panelCurso.add(btnAlterarCursos);
		
		btnAlterarCursos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            //Valida o RA (vem da aba Dados Pessoais)
		            String ra = textField.getText().trim();
		            if (ra.isEmpty()) {
		                JOptionPane.showMessageDialog(null,
		                    "Informe o RA do aluno na aba 'Dados Pessoais' antes de alterar o curso.");
		                return;
		            }

		            //Valida as seleções do combo
		            if (cmbCursos.getSelectedItem() == null || cmbCampus.getSelectedItem() == null) {
		                JOptionPane.showMessageDialog(null, "Selecione um Curso e um Campus.");
		                return;
		            }

		            String cursoSelecionado  = cmbCursos.getSelectedItem().toString();
		            String campusSelecionado = cmbCampus.getSelectedItem().toString();

		            //Valida o período
		            String periodoSelecionado = "";
		            if      (rdbtnMatutino.isSelected())   periodoSelecionado = "Matutino";
		            else if (rdbtnVespertino.isSelected())  periodoSelecionado = "Vespertino";
		            else if (rdbtnNoturno.isSelected())     periodoSelecionado = "Noturno";

		            if (periodoSelecionado.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Selecione um Período.");
		                return;
		            }

		            //Descobre o codCurso pela combinação escolhida
		            dao.CursoDAO cursoDAO = new dao.CursoDAO();
		            int codCurso = cursoDAO.descobrirCodCurso(
		                cursoSelecionado, campusSelecionado, periodoSelecionado);

		            if (codCurso == 0) {
		                JOptionPane.showMessageDialog(null,
		                    "Combinação de Curso, Campus e Período não encontrada no sistema.");
		                return;
		            }

		            //Confirmação antes de gravar
		            int confirmacao = JOptionPane.showConfirmDialog(null,
		                "Confirma a alteração do curso do aluno RA " + ra + "?\n\n" +
		                "Curso:   " + cursoSelecionado  + "\n" +
		                "Campus:  " + campusSelecionado  + "\n" +
		                "Período: " + periodoSelecionado,
		                "Confirmar Alteração",
		                JOptionPane.YES_NO_OPTION);

		            if (confirmacao != JOptionPane.YES_OPTION) return;

		            //Executa o UPDATE
		            dao.AlunoDAO alunoDAO = new dao.AlunoDAO();
		            alunoDAO.atualizarCursoAluno(ra, codCurso);

		            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null,
		                "Erro ao atualizar curso: " + ex.getMessage());
		        }
		    }
		});
		
		JButton btnConsultarCursos = new JButton("");
		btnConsultarCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/search_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnConsultarCursos.setBounds(289, 265, 89, 45);
		panelCurso.add(btnConsultarCursos);
		
		JButton btnExcluirCursos = new JButton("");
		btnExcluirCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/delete_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnExcluirCursos.setBounds(419, 265, 89, 45);
		panelCurso.add(btnExcluirCursos);
		
		JButton btnSairCursos = new JButton("");
		btnSairCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/exit_to_app_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnSairCursos.setBounds(549, 265, 89, 45);
		panelCurso.add(btnSairCursos);
		
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
		
		JButton btnExcluirNotas = new JButton("");
		btnExcluirNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/delete_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnExcluirNotas.setBounds(413, 268, 89, 45);
		panelNotasFaltas.add(btnExcluirNotas);
		
		JButton btnSairNotas = new JButton("");
		btnSairNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/exit_to_app_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnSairNotas.setBounds(543, 268, 89, 45);
		panelNotasFaltas.add(btnSairNotas);
		
		JButton btnConsultarNotas = new JButton("");
		btnConsultarNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/search_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnConsultarNotas.setBounds(283, 268, 89, 45);
		panelNotasFaltas.add(btnConsultarNotas);
		
		JButton btnAlterarNotas = new JButton("");
		btnAlterarNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/update_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
		btnAlterarNotas.setBounds(152, 268, 89, 45);
		panelNotasFaltas.add(btnAlterarNotas);
		
		JButton btnSalvarNotas = new JButton("");
		btnSalvarNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/save_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
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
		
		// Painel contêiner superior para os dados básicos do Aluno
		JPanel painelFichaAluno = new JPanel();
		painelFichaAluno.setLayout(null);
		painelFichaAluno.setBorder(BorderFactory.createTitledBorder("Informações Acadêmicas"));
		painelFichaAluno.setBounds(10, 11, 662, 85);
		panelBoletim.add(painelFichaAluno);
		
		lblRgmBoletim = new JLabel("RA: ");
		lblRgmBoletim.setFont(new Font("Dubai", Font.BOLD, 14));
		lblRgmBoletim.setBounds(15, 20, 600, 20);
		painelFichaAluno.add(lblRgmBoletim);
		
		lblNomeBoletim = new JLabel("Nome: ");
		lblNomeBoletim.setFont(new Font("Dubai", Font.BOLD, 14));
		lblNomeBoletim.setBounds(15, 40, 600, 20);
		painelFichaAluno.add(lblNomeBoletim);
		
		lblCursoBoletim = new JLabel("Curso: ");
		lblCursoBoletim.setFont(new Font("Dubai", Font.BOLD, 14));
		lblCursoBoletim.setBounds(15, 60, 600, 20);
		painelFichaAluno.add(lblCursoBoletim);
		
		// Definição da tabela e bloqueio de edição manual nas células pelo usuário
		String[] colunasBoletim = {"Disciplina / Matéria", "Nota Final", "Faltas Totais"};
		modeloTabelaBoletim = new DefaultTableModel(colunasBoletim, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabelaBoletim = new JTable(modeloTabelaBoletim);
		tabelaBoletim.setRowHeight(22);
		tabelaBoletim.setFillsViewportHeight(true);
		
		// Alinhamento centralizado para as colunas de Notas e Faltas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tabelaBoletim.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tabelaBoletim.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		
		// Barra de rolagem para a tabela acoplada via posicionamento absoluto
		JScrollPane scrollTabelaBoletim = new JScrollPane(tabelaBoletim);
		scrollTabelaBoletim.setBounds(10, 107, 662, 203);
		panelBoletim.add(scrollTabelaBoletim);
		
		// Ouvinte que intercepta o momento exato em que a aba "Boletim" ganha foco
		tabbedPane.addChangeListener(e -> {
			if (tabbedPane.getSelectedIndex() == 3) { // Índice 3 é a aba Boletim
				String raDigitado = txtRaNotas.getText().trim();
				
				if (!raDigitado.isEmpty()) {
					
					// O AlunoDAO será chamado aqui para alimentar a tabela de forma automática.
					/*
					try {
						dao.AlunoDAO daoAluno = new dao.AlunoDAO();
						java.util.List<Desempenho> notas = daoAluno.buscarBoletim(raDigitado);
						atualizarInterfaceBoletim(notas);
					} catch(Exception ex) {
						ex.printStackTrace();
					}
					*/
				}
			}
		});
		
		contentPane.add(tabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1121, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Alterar");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sair");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Editar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Alterar Fonte");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu_1.add(separator_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Formato");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Ajudar");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Sobre");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Informações do Menu");
			}
		});
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		carregarSeletoresCurso();
	}
	
	private void carregarSeletoresCurso() {
		try {
			dao.CursoDAO cursoDAO = new dao.CursoDAO();
			
			if (cmbCursos != null) cmbCursos.removeAllItems();
			if (cmbCampus != null) cmbCampus.removeAllItems();
			
			java.util.List<model.Curso> listaCursos = cursoDAO.listarCursosParaCombo();
			if (listaCursos != null) {
				for (model.Curso c : listaCursos) {
					cmbCursos.addItem(c.getNomeCurso()); 
				}
			}
			
			java.util.List<String> listaCampi = cursoDAO.listarCampiParaCombo();
			if (listaCampi != null) {
				for (String campus : listaCampi) {
					cmbCampus.addItem(campus);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao popular seletores: " + e.getMessage());
		}
	}
	
	/**
	 * Função responsável por receber os dados processados do banco e atualizar a interface do Boletim.
	 */
	public void atualizarInterfaceBoletim(java.util.List<Desempenho> listaDesempenho) {
		if (listaDesempenho == null || listaDesempenho.isEmpty()) {
			return;
		}
		
		modeloTabelaBoletim.setRowCount(0); 
		
		try {
			// Usando a herança da classe Desempenho (extends Aluno) para preencher a ficha
			Desempenho primeiroRegistro = listaDesempenho.get(0);
			
			lblRgmBoletim.setText("RA: " + primeiroRegistro.getRa()); 
			lblNomeBoletim.setText("Nome: " + primeiroRegistro.getNome());
			lblCursoBoletim.setText("Curso: " + primeiroRegistro.getCodCurso());
			
			// Varre a lista populando as linhas da tabela
			for (Desempenho d : listaDesempenho) {
				modeloTabelaBoletim.addRow(new Object[]{
					d.getCodDisciplina(), 
					d.getNota(),       
					d.getFaltas()      
				});
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Erro ao popular a tabela de boletim: " + ex.getMessage());
		}
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