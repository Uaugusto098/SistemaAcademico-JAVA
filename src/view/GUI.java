package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
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
		lblNewLabel_1.setBounds(21, 66, 46, 14);
		panelDados.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(21, 114, 154, 14);
		panelDados.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(77, 64, 158, 20);
		panelDados.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 112, 158, 20);
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
		lblNewLabel_1_2.setBounds(21, 213, 76, 14);
		panelDados.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
		lblNewLabel_1_1_2.setFont(new Font("Dubai", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(370, 24, 34, 14);
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
		btnNewButton_1_4.setBounds(537, 263, 89, 47);
		panelDados.add(btnNewButton_1_4);
		tabbedPane.addTab("Cursos",null,panelCurso,"Curso do Aluno");
		
		JButton btnNewButton = new JButton("botao");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(101, 156, 89, 23);
		panelCurso.add(btnNewButton);
		tabbedPane.addTab("Notas e Faltas",null,panelNotasFaltas,"Notas e faltas do aluno");
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
