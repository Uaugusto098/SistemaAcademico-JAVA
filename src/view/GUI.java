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

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		tabbedPane.setBounds(123, 62, 893,442);
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
		tabbedPane.addTab("Cursos",null,panelCurso,"Curso do Aluno");
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
