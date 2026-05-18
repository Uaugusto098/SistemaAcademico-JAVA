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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import java.util.List;
import model.Curso;
import dao.AlunoDAO;
import dao.CursoDAO;
import dao.DesempenhoDAO;
import dao.DisciplinasDAO;
import model.Aluno;
import model.Desempenho;
import model.Disciplina;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Aba Dados Pessoais
    private JTextField txtRa;
    private JTextField textField_1;  // Nome
    private JTextField textField_3;  // Endereço
    private JTextField textField_4;  // Email
    private JTextField textField_6;  // Município
    private JFormattedTextField textField_7;
    private JFormattedTextField fldDataNasc;
    private JFormattedTextField fldCpf;
    private JComboBox cmbUF;

    // Aba Cursos
    private JComboBox cmbCursos;
    private JComboBox cmbCampus;
    private JRadioButton rdbtnMatutino;
    private JRadioButton rdbtnVespertino;
    private JRadioButton rdbtnNoturno;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    // Aba Notas e Faltas
    private JTextField txtRaNotas;
    private JTextField txtNomeNotas;
    private JTextField txtCursoNotas;
    private JTextField txtFaltas;

    // Aba Boletim
    private JLabel lblRgmBoletim;
    private JLabel lblNomeBoletim;
    private JLabel lblCursoBoletim;
    private JTable tabelaBoletim;
    private DefaultTableModel modeloTabelaBoletim;

    // Filtro UF → Campus
    private java.util.List<String> todosCampi;
    private java.util.Map<String, java.util.List<String>> mapaUFCampi;

    // =========================================================
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
   

    // =========================================================
    public GUI() throws Exception {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1169, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(235, 117, 687, 349);
        contentPane.add(tabbedPane);

        JPanel panelDados        = new JPanel();
        JPanel panelCurso        = new JPanel();
        JPanel panelNotasFaltas  = new JPanel();
        JPanel panelBoletim      = new JPanel();

        panelDados.setLayout(null);
        panelCurso.setLayout(null);
        panelNotasFaltas.setLayout(null);
        panelBoletim.setLayout(null);

        // =================================================
        // ABA DADOS PESSOAIS
        // =================================================
        tabbedPane.addTab("Dados Pessoais", null, panelDados, "Informações do Aluno");

        JLabel lblNewLabel = new JLabel("RA");
        lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel.setBounds(21, 24, 46, 14);
        panelDados.add(lblNewLabel);

        txtRa = new JTextField();
        txtRa.setBounds(51, 22, 158, 20);
        txtRa.setColumns(10);
        txtRa.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null) return;
                if ((getLength() + str.length()) <= 13) {
                    super.insertString(offs, str, a);
                }
            }
        });
        panelDados.add(txtRa);

        JLabel lblNewLabel_1 = new JLabel("Nome");
        lblNewLabel_1.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(21, 66, 57, 14);
        panelDados.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(77, 64, 158, 20);
        panelDados.add(textField_1);

        JLabel lblNewLabel_1_1 = new JLabel("Data de Nascimento");
        lblNewLabel_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(21, 114, 162, 14);
        panelDados.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(21, 174, 57, 14);
        panelDados.add(lblNewLabel_1_1_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(77, 172, 158, 20);
        panelDados.add(textField_4);

        JLabel lblNewLabel_1_2 = new JLabel("Endereço");
        lblNewLabel_1_2.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_2.setBounds(21, 213, 89, 14);
        panelDados.add(lblNewLabel_1_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(107, 211, 158, 20);
        panelDados.add(textField_3);

        JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
        lblNewLabel_1_1_2.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_1_2.setBounds(370, 24, 46, 14);
        panelDados.add(lblNewLabel_1_1_2);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 149, 666, 14);
        panelDados.add(separator);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Município");
        lblNewLabel_1_1_1_1.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(359, 168, 83, 26);
        panelDados.add(lblNewLabel_1_1_1_1);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(452, 172, 158, 20);
        panelDados.add(textField_6);

        JLabel lblNewLabel_1_2_1 = new JLabel("UF");
        lblNewLabel_1_2_1.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_2_1.setBounds(359, 209, 40, 26);
        panelDados.add(lblNewLabel_1_2_1);

        cmbUF = new JComboBox(new String[]{"SP", "RJ", "MG", "ES", "RS"});
        cmbUF.setBounds(408, 206, 65, 31);
        panelDados.add(cmbUF);
        cmbUF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrarCampiPorUF();
            }
        });

        JLabel lblNewLabel_1_1_2_1 = new JLabel("Celular");
        lblNewLabel_1_1_2_1.setFont(new Font("Dubai", Font.PLAIN, 18));
        lblNewLabel_1_1_2_1.setBounds(370, 68, 57, 14);
        panelDados.add(lblNewLabel_1_1_2_1);

        try {
            // Cria a máscara no formato padrão de celular do Brasil
            javax.swing.text.MaskFormatter mascaraCelular = new javax.swing.text.MaskFormatter("(##) #####-####");
            mascaraCelular.setPlaceholderCharacter('_'); // Mostra um sublinhado onde o usuário deve digitar
            
            // Troca o JTextField pelo JFormattedTextField
            textField_7 = new javax.swing.JFormattedTextField(mascaraCelular);
            textField_7.setFocusLostBehavior(JFormattedTextField.PERSIST); 
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            textField_7 = new JFormattedTextField(); // fallback sem máscara
        }

        textField_7.setColumns(10);
        textField_7.setBounds(437, 64, 158, 20);
        panelDados.add(textField_7);

        // Campos formatados globais (sem duplicata)
        try {
        	fldDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        	fldDataNasc.setBounds(181, 112, 65, 20);
        	fldDataNasc.setFocusLostBehavior(JFormattedTextField.PERSIST); 
        	panelDados.add(fldDataNasc);
        	
        	fldCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        	fldCpf.setBounds(410, 22, 109, 20);
        	fldCpf.setFocusLostBehavior(JFormattedTextField.PERSIST); // <-- adicione
        	panelDados.add(fldCpf);
        } catch (Exception e) {
            System.err.println("Erro ao inicializar máscaras: " + e.getMessage());
        }

        // =================================================
        // ABA CURSOS
        // =================================================
        tabbedPane.addTab("Cursos", null, panelCurso, "Curso do Aluno");

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

        // --- Botão SALVAR (INSERT completo) ---
        JButton btnSalvarCursos = new JButton("");
        btnSalvarCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/save_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnSalvarCursos.setBounds(32, 265, 89, 45);
        panelCurso.add(btnSalvarCursos);
        btnSalvarCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
                try {
                    // Coleta dados da aba Dados Pessoais
                    String ra          = txtRa.getText().trim();
                    String nome        = textField_1.getText().trim();
                    String email       = textField_4.getText().trim();
                    String endereco    = textField_3.getText().trim();
                    String municipio   = textField_6.getText().trim();
                    String celular     = textField_7.getText().trim();
                    String uf          = (cmbUF.getSelectedItem() != null) ? cmbUF.getSelectedItem().toString() : "";
                    String cpf         = (fldCpf != null) ? fldCpf.getText().trim() : "";
                    String dataNascStr = (fldDataNasc != null) ? fldDataNasc.getText().trim() : "";

                    // Validações básicas
                    if (ra.isEmpty() || nome.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                            "Preencha pelo menos o RA e o Nome na aba 'Dados Pessoais'.");
                        return;
                    }

                    // Validação de todos os campos obrigatórios
                    if (email.isEmpty() || endereco.isEmpty() || municipio.isEmpty() ||
                        celular.replaceAll("[^0-9]", "").isEmpty() ||
                        cpf.replaceAll("[^0-9]", "").isEmpty() ||
                        uf.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                            "Preencha todos os campos obrigatórios:\n\n" +
                            (email.isEmpty()                              ? "- Email\n"     : "") +
                            (endereco.isEmpty()                           ? "- Endereço\n"  : "") +
                            (municipio.isEmpty()                          ? "- Município\n" : "") +
                            (celular.replaceAll("[^0-9]", "").isEmpty()   ? "- Celular\n"   : "") +
                            (cpf.replaceAll("[^0-9]", "").isEmpty()       ? "- CPF\n"       : "") +
                            (uf.isEmpty()                                 ? "- UF\n"        : ""),
                            "Campos obrigatórios",
                            JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Verifica RA ou CPF duplicado
                    dao.AlunoDAO alunoDAO = new dao.AlunoDAO();
                    if (alunoDAO.existeRaOuCpf(ra, cpf)) {
                        JOptionPane.showMessageDialog(null,
                            "RA ou CPF já cadastrados.",
                            "Duplicidade", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Converte data dd/MM/yyyy → java.sql.Date
                    java.sql.Date dataNasc = null;
                    if (!dataNascStr.replace("/", "").trim().isEmpty()) {
                        try {
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                            sdf.setLenient(false);
                            dataNasc = new java.sql.Date(sdf.parse(dataNascStr).getTime());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,
                                "Data de Nascimento inválida. Use o formato dd/MM/aaaa.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Informe a Data de Nascimento.");
                        return;
                    }

                    // Valida seleção de curso
                    if (cmbCursos.getSelectedItem() == null || cmbCampus.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "Selecione um Curso e um Campus.");
                        return;
                    }

                    String cursoSelecionado  = cmbCursos.getSelectedItem().toString();
                    String campusSelecionado = cmbCampus.getSelectedItem().toString();

                    String periodoSelecionado = "";
                    if      (rdbtnMatutino.isSelected())  periodoSelecionado = "Matutino";
                    else if (rdbtnVespertino.isSelected()) periodoSelecionado = "Vespertino";
                    else if (rdbtnNoturno.isSelected())    periodoSelecionado = "Noturno";

                    if (periodoSelecionado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Selecione um Período.");
                        return;
                    }

                    // Descobre o codCurso pela combinação
                    dao.CursoDAO cursoDAO = new dao.CursoDAO();
                    int codCurso = cursoDAO.descobrirCodCurso(
                        cursoSelecionado, campusSelecionado, periodoSelecionado);

                    if (codCurso == 0) {
                        JOptionPane.showMessageDialog(null,
                            "Combinação de Curso, Campus e Período não encontrada no sistema.");
                        return;
                    }

                    // Monta e insere o Aluno
                    model.Aluno aluno = new model.Aluno(
                        nome, ra, cpf, dataNasc,
                        email, municipio, uf,
                        String.valueOf(codCurso),
                        endereco, celular
                    );

                    alunoDAO.salvar(aluno);

                    JOptionPane.showMessageDialog(null,
                        "Aluno cadastrado com sucesso!\n\n" +
                        "RA: "      + ra               + "\n" +
                        "Nome: "    + nome             + "\n" +
                        "Curso: "   + cursoSelecionado  + "\n" +
                        "Campus: "  + campusSelecionado + "\n" +
                        "Período: " + periodoSelecionado);

                    limparCampos(); // Limpa os campos após salvar

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                        "Erro ao cadastrar aluno: " + ex.getMessage());
                }
            }
        });

        // --- Botão ALTERAR (UPDATE completo) ---
 
        JButton btnAlterarCursos = new JButton("");
        btnAlterarCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/update_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnAlterarCursos.setBounds(158, 265, 89, 45);
        panelCurso.add(btnAlterarCursos);
        btnAlterarCursos.addActionListener(new ActionListener() {  // <-- CORRETO
            public void actionPerformed(ActionEvent e) {
                try {
                    String ra          = txtRa.getText().trim();
                    String nome        = textField_1.getText().trim();
                    String email       = textField_4.getText().trim();
                    String endereco    = textField_3.getText().trim();
                    String municipio   = textField_6.getText().trim();
                    String celular     = textField_7.getText().trim();
                    String uf          = (cmbUF.getSelectedItem() != null) ? cmbUF.getSelectedItem().toString() : "";
                    String cpf         = (fldCpf != null) ? fldCpf.getText().trim() : "";
                    String dataNascStr = (fldDataNasc != null) ? fldDataNasc.getText().trim() : "";

                    if (ra.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Informe o RA do aluno.");
                        return;
                    }

                    java.sql.Date dataNasc = null;
                    if (!dataNascStr.replace("/", "").trim().isEmpty()) {
                        try {
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                            sdf.setLenient(false);
                            dataNasc = new java.sql.Date(sdf.parse(dataNascStr).getTime());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Data de Nascimento inválida.");
                            return;
                        }
                    }

                    if (cmbCursos.getSelectedItem() == null || cmbCampus.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "Selecione um Curso e um Campus.");
                        return;
                    }

                    String cursoSelecionado  = cmbCursos.getSelectedItem().toString();
                    String campusSelecionado = cmbCampus.getSelectedItem().toString();

                    String periodoSelecionado = "";
                    if      (rdbtnMatutino.isSelected())  periodoSelecionado = "Matutino";
                    else if (rdbtnVespertino.isSelected()) periodoSelecionado = "Vespertino";
                    else if (rdbtnNoturno.isSelected())    periodoSelecionado = "Noturno";

                    if (periodoSelecionado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Selecione um Período.");
                        return;
                    }

                    dao.CursoDAO cursoDAO = new dao.CursoDAO();
                    int codCurso = cursoDAO.descobrirCodCurso(cursoSelecionado, campusSelecionado, periodoSelecionado);

                    if (codCurso == 0) {
                        JOptionPane.showMessageDialog(null, "Combinação não encontrada.");
                        return;
                    }

                    int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Confirma a alteração do aluno RA " + ra + "?",
                        "Confirmar Alteração", JOptionPane.YES_NO_OPTION);
                    if (confirmacao != JOptionPane.YES_OPTION) return;

                    model.Aluno aluno = new model.Aluno(
                        nome, ra, cpf, dataNasc,
                        email, municipio, uf,
                        String.valueOf(codCurso),
                        endereco, celular
                    );

                    dao.AlunoDAO alunoDAO = new dao.AlunoDAO();
                    alunoDAO.atualizar(aluno);  // <-- CORRETO, usa atualizar e não salvar

                    JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
                    limparCampos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar aluno: " + ex.getMessage());
                }
            }
        });

        // --- Botão CONSULTAR ---
        JButton btnConsultarCursos = new JButton("");
        btnConsultarCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/search_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnConsultarCursos.setBounds(289, 265, 89, 45);
        panelCurso.add(btnConsultarCursos);
        btnConsultarCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ra = txtRa.getText().trim();

                if (ra.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo RA não pode estar vazio!");
                    return;
                }

                try {
                    AlunoDAO alunoDAO = new AlunoDAO();
                    Aluno aluno = alunoDAO.procurarAluno(ra);

                    if (aluno == null) {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                        return;
                    }

                    // Preenche campos da aba Dados Pessoais
                    textField_1.setText(aluno.getNome());
                    textField_4.setText(aluno.getEmail());
                    textField_3.setText(aluno.getEndereco());
                    textField_6.setText(aluno.getMunicipio());
                    textField_7.setText(aluno.getCelular());

                    if (fldCpf != null && aluno.getCpf() != null) {
                        String cpfLimpo = aluno.getCpf().replaceAll("[^0-9]", "");
                        if (cpfLimpo.length() == 11) {
                            String cpfFormatado = cpfLimpo.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                            fldCpf.setText(cpfFormatado);
                        } else {
                            fldCpf.setText(aluno.getCpf());
                        }
                    }

                    if (aluno.getUf() != null) cmbUF.setSelectedItem(aluno.getUf());

                    if (aluno.getDataNasc() != null) {
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                        fldDataNasc.setText(sdf.format(aluno.getDataNasc()));
                    }

                    // Preenche campos da aba Cursos
                    if (aluno.getCodCurso() != null && !aluno.getCodCurso().isEmpty()) {
                        try {
                            int codCurso = Integer.parseInt(aluno.getCodCurso());
                            dao.CursoDAO cursoDAO = new dao.CursoDAO();
                            model.Curso curso = cursoDAO.buscarPorCodigo(codCurso); // você precisa ter esse método

                            if (curso != null) {
                                // Seleciona o curso no combo
                                cmbCursos.setSelectedItem(curso.getNomeCurso());

                                // Seleciona a UF e filtra o campus
                                if (aluno.getUf() != null) {
                                    cmbUF.setSelectedItem(aluno.getUf());
                                    filtrarCampiPorUF();
                                }

                                // Seleciona o campus
                                cmbCampus.setSelectedItem(curso.getCampus());

                                // Seleciona o período
                                String periodo = curso.getPeriodo();
                                if ("Matutino".equalsIgnoreCase(periodo))        rdbtnMatutino.setSelected(true);
                                else if ("Vespertino".equalsIgnoreCase(periodo)) rdbtnVespertino.setSelected(true);
                                else if ("Noturno".equalsIgnoreCase(periodo))    rdbtnNoturno.setSelected(true);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Código de curso inválido.");
                        }
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao consultar aluno: " + ex.getMessage());
                }
            }
        });

        // --- Botão EXCLUIR ---
        JButton btnExcluirCursos = new JButton("");
        btnExcluirCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/delete_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnExcluirCursos.setBounds(419, 265, 89, 45);
        panelCurso.add(btnExcluirCursos);
        btnExcluirCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ra = txtRa.getText().trim();

                if (ra.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo RA não pode estar vazio!");
                    return;
                }

                int confirmacao = JOptionPane.showConfirmDialog(null,
                    "Confirma a exclusão do aluno RA " + ra + "?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION);

                if (confirmacao != JOptionPane.YES_OPTION) return;

                try {
                    AlunoDAO alunoDAO = new AlunoDAO();
                    Aluno aluno = new Aluno();
                    aluno.setRa(ra);
                    alunoDAO.excluir(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
                    
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                        "Erro ao excluir aluno: " + ex.getMessage());
                }
            }
        });

        // --- Botão SAIR ---
        JButton btnSairCursos = new JButton("");
        btnSairCursos.setIcon(new ImageIcon(GUI.class.getResource("/images/exit_to_app_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnSairCursos.setBounds(549, 265, 89, 45);
        panelCurso.add(btnSairCursos);
        btnSairCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // =================================================
        // ABA NOTAS E FALTAS
        // =================================================
        tabbedPane.addTab("Notas e Faltas", null, panelNotasFaltas, "Notas e faltas do aluno");

        JLabel lblRa = new JLabel("RA");
        lblRa.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblRa.setBounds(10, 25, 46, 14);
        panelNotasFaltas.add(lblRa);

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

        JLabel lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblDisciplina.setBounds(10, 118, 88, 24);
        panelNotasFaltas.add(lblDisciplina);
        
        JComboBox<Disciplina> cmbDisciplinas = new JComboBox();
        cmbDisciplinas.setBounds(99, 122, 383, 22);
        try {
            DisciplinasDAO dao = new DisciplinasDAO();
            for (Disciplina d : dao.listarParaCombo()) {
                cmbDisciplinas.addItem(d);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar disciplinas: " + e.getMessage());
        }
        panelNotasFaltas.add(cmbDisciplinas);

        JLabel lblSemestre = new JLabel("Semestre");
        lblSemestre.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblSemestre.setBounds(10, 181, 81, 24);
        panelNotasFaltas.add(lblSemestre);

        JComboBox<String> cmbSemestre = new JComboBox();
        cmbSemestre.setBounds(99, 185, 94, 22);
        cmbSemestre.addItem("2024-1");
        cmbSemestre.addItem("2024-2");
        cmbSemestre.addItem("2025-1");
        panelNotasFaltas.add(cmbSemestre);

        JLabel lblNota = new JLabel("Nota");
        lblNota.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblNota.setBounds(234, 181, 38, 24);
        panelNotasFaltas.add(lblNota);
        
        JTextField txtNota = new JTextField();
        txtNota.setColumns(10);
        txtNota.setBounds(280, 186, 80, 20);
        panelNotasFaltas.add(txtNota);

        JLabel lblFaltas = new JLabel("Faltas");
        lblFaltas.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblFaltas.setBounds(389, 181, 53, 24);
        panelNotasFaltas.add(lblFaltas);

        txtFaltas = new JTextField();
        txtFaltas.setColumns(10);
        txtFaltas.setBounds(445, 186, 102, 20);
        panelNotasFaltas.add(txtFaltas);
        
        

        JButton btnSalvarNotas = new JButton("");
        btnSalvarNotas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 try {
        	            if (txtNota.getText().isEmpty() || txtFaltas.getText().isEmpty()) {
        	                JOptionPane.showMessageDialog(null, "Preencha nota e faltas!");
        	                return;
        	            }
        	            
        	            Disciplina disc = (Disciplina) cmbDisciplinas.getSelectedItem();
        	            Desempenho d = new Desempenho();
        	            d.setRa(txtRaNotas.getText());
        	            d.setCodDisciplina(disc.getCodDisciplina());
        	            d.setSemestre(cmbSemestre.getSelectedItem().toString());
        	            d.setNota(Double.parseDouble(txtNota.getText())); 
        	            d.setFaltas(Integer.parseInt(txtFaltas.getText()));

        	            DesempenhoDAO dao = new DesempenhoDAO();
        	            dao.inserir(d);

        	            JOptionPane.showMessageDialog(null, "Nota salva com sucesso!");
        	            txtNota.setText("");
                        txtFaltas.setText("");
        	        } catch (Exception ex) {
        	            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        	        }
            }
        });
        btnSalvarNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/save_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnSalvarNotas.setBounds(26, 268, 89, 45);
        panelNotasFaltas.add(btnSalvarNotas);

        JButton btnAlterarNotas = new JButton("");
        btnAlterarNotas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 try {
        			 	Disciplina disc = (Disciplina) cmbDisciplinas.getSelectedItem();
        	            Desempenho d = new Desempenho();
        	            d.setRa(txtRaNotas.getText());
        	            d.setCodDisciplina(disc.getCodDisciplina());
        	            d.setSemestre(cmbSemestre.getSelectedItem().toString());
        	            d.setNota(Double.parseDouble(txtNota.getText())); // ✅ CORRIGIDO
        	            d.setFaltas(Integer.parseInt(txtFaltas.getText()));

        	            DesempenhoDAO dao = new DesempenhoDAO();
        	            if (dao.alterar(d)) {
        	                JOptionPane.showMessageDialog(null, "Nota alterada com sucesso!");
        	                txtNota.setText("");
                            txtFaltas.setText("");
        	            } else {
        	                JOptionPane.showMessageDialog(null, "Registro não encontrado.");
        	            }
        	        } catch (Exception ex) {
        	            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
        	        }
        	}
        });
        btnAlterarNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/update_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnAlterarNotas.setBounds(152, 268, 89, 45);
        panelNotasFaltas.add(btnAlterarNotas);

        JButton btnConsultarNotas = new JButton("");
        btnConsultarNotas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    String ra = txtRaNotas.getText().trim();

                    if (cmbDisciplinas.getSelectedItem() == null || cmbSemestre.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "Selecione Disciplina e Semestre!");
                        return;
                    }

                    Disciplina disc = (Disciplina) cmbDisciplinas.getSelectedItem();
                    int codDisciplina = disc.getCodDisciplina(); // ✅ CORRETO

                    String semestre = cmbSemestre.getSelectedItem().toString();

                    DesempenhoDAO dao = new DesempenhoDAO();
                    Desempenho d = dao.consultar(ra, codDisciplina, semestre); // ✅ CORRETO

                    if (d != null) {
                        txtNomeNotas.setText(d.getNome());
                        txtCursoNotas.setText(d.getCodCurso());
                        txtFaltas.setText(String.valueOf(d.getFaltas()));
                        txtNota.setText(String.valueOf(d.getNota()));
                    } else {
                        model.Aluno a = dao.buscarAlunoPorRa(ra);
                        if (a != null) {
                            txtNomeNotas.setText(a.getNome());
                            txtCursoNotas.setText(a.getCodCurso());
                            JOptionPane.showMessageDialog(null, "Aluno encontrado, mas sem nota.");
                            txtNota.setText("");
                            txtFaltas.setText("");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "RA não encontrado.");
                        }
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
                }
        	}
        });
        btnConsultarNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/search_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnConsultarNotas.setBounds(283, 268, 89, 45);
        panelNotasFaltas.add(btnConsultarNotas);

        JButton btnExcluirNotas = new JButton("");
        btnExcluirNotas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta nota?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        String ra = txtRaNotas.getText();

                        Disciplina disc = (Disciplina) cmbDisciplinas.getSelectedItem();
                        int codDisciplina = disc.getCodDisciplina(); // ✅ CORRETO

                        String sem = cmbSemestre.getSelectedItem().toString();

                        DesempenhoDAO dao = new DesempenhoDAO();

                        if (dao.excluir(ra, codDisciplina, sem)) { // ✅ CORRETO
                            JOptionPane.showMessageDialog(null, "Nota excluída!");
                            txtNota.setText("");
                            txtFaltas.setText("");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
                    }
                }
        	}
        });
        btnExcluirNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/delete_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnExcluirNotas.setBounds(413, 268, 89, 45);
        panelNotasFaltas.add(btnExcluirNotas);

        JButton btnSairNotas = new JButton("");
        btnSairNotas.setIcon(new ImageIcon(GUI.class.getResource("/images/exit_to_app_38dp_000000_FILL0_wght400_GRAD0_opsz40.png")));
        btnSairNotas.setBounds(543, 268, 89, 45);
        panelNotasFaltas.add(btnSairNotas);

        // =================================================
        // ABA BOLETIM
        // =================================================
        tabbedPane.addTab("Boletim", null, panelBoletim, "Boletim Completo");

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

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaBoletim.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabelaBoletim.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        JScrollPane scrollTabelaBoletim = new JScrollPane(tabelaBoletim);
        scrollTabelaBoletim.setBounds(10, 107, 662, 203);
        panelBoletim.add(scrollTabelaBoletim);

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 3) {
                String raDigitado = txtRaNotas.getText().trim();
                if (!raDigitado.isEmpty()) {
                    // Descomente quando AlunoDAO.buscarBoletim() estiver implementado:
                    /*
                    try {
                        dao.AlunoDAO daoAluno = new dao.AlunoDAO();
                        java.util.List<Desempenho> notas = daoAluno.buscarBoletim(raDigitado);
                        atualizarInterfaceBoletim(notas);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    */
                }
            }
        });

        contentPane.add(tabbedPane);

        // =================================================
        // MENU BAR
        // =================================================
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1121, 22);
        contentPane.add(menuBar);

        JMenu mnAluno = new JMenu("Aluno");
        menuBar.add(mnAluno);

        JMenuItem mntmSalvar = new JMenuItem("Salvar");
        mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
        mnAluno.add(mntmSalvar);

        JMenuItem mntmConsultar = new JMenuItem("Consultar");
        mnAluno.add(mntmConsultar);

        JMenuItem mntmAlterar = new JMenuItem("Alterar");
        mnAluno.add(mntmAlterar);

        JMenuItem mntmExcluir = new JMenuItem("Excluir");
        mnAluno.add(mntmExcluir);

        mnAluno.add(new JSeparator());

        JMenuItem mntmSair = new JMenuItem("Sair");
        mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        mntmSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnAluno.add(mntmSair);

        JMenu mnNotasFaltas = new JMenu("Notas e faltas");
        menuBar.add(mnNotasFaltas);
        mnNotasFaltas.add(new JMenuItem("Salvar"));
        mnNotasFaltas.add(new JMenuItem("Alterar"));
        mnNotasFaltas.add(new JMenuItem("Excluir"));
        mnNotasFaltas.add(new JMenuItem("Consultar"));

        JMenu mnAjuda = new JMenu("Ajuda");
        menuBar.add(mnAjuda);

        JMenuItem mntmSobre = new JMenuItem("Sobre");
        mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK));
        mntmSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sistema Acadêmico - v1.0");
            }
        });
        mnAjuda.add(mntmSobre);

        carregarSeletoresCurso();
    }

    // =========================================================
    // MÉTODOS AUXILIARES
    // =========================================================

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

            todosCampi = cursoDAO.listarCampiParaCombo();

            inicializarMapaUFCampi();
            filtrarCampiPorUF();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao popular seletores: " + e.getMessage());
        }
    }

    private void inicializarMapaUFCampi() {
        mapaUFCampi = new java.util.HashMap<>();
        mapaUFCampi.put("SP", java.util.Arrays.asList("Itaquera", "Guarulhos", "Ferraz de Vasconcelos"));
        mapaUFCampi.put("RJ", java.util.Arrays.asList("Rio de Janeiro", "Niteroi", "Campo Grande"));
        mapaUFCampi.put("MG", java.util.Arrays.asList("Belo Horizonte", "Uberlandia"));
        mapaUFCampi.put("ES", java.util.Arrays.asList("Vitoria"));
        mapaUFCampi.put("RS", java.util.Arrays.asList("Porto Alegre"));
    }

    private void filtrarCampiPorUF() {
        if (cmbUF == null || cmbCampus == null || mapaUFCampi == null) return;

        String ufSelecionada = (String) cmbUF.getSelectedItem();
        cmbCampus.removeAllItems();

        java.util.List<String> campiDaUF = mapaUFCampi.get(ufSelecionada);
        if (campiDaUF != null) {
            for (String campus : campiDaUF) {
                if (todosCampi != null && todosCampi.contains(campus)) {
                    cmbCampus.addItem(campus);
                }
            }
        }

        if (cmbCampus.getItemCount() == 0) {
            cmbCampus.addItem("Nenhum campus disponível");
        }
    }

    public void atualizarInterfaceBoletim(java.util.List<Desempenho> listaDesempenho) {
        if (listaDesempenho == null || listaDesempenho.isEmpty()) return;

        modeloTabelaBoletim.setRowCount(0);

        try {
            Desempenho primeiroRegistro = listaDesempenho.get(0);
            lblRgmBoletim.setText("RA: "    + primeiroRegistro.getRa());
            lblNomeBoletim.setText("Nome: " + primeiroRegistro.getNome());
            lblCursoBoletim.setText("Curso: " + primeiroRegistro.getCodCurso());

            for (Desempenho d : listaDesempenho) {
                modeloTabelaBoletim.addRow(new Object[]{
                    d.getCodDisciplina(),
                    d.getNota(),
                    d.getFaltas()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao popular a tabela de boletim: " + ex.getMessage());
        }
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) popup.show(e.getComponent(), e.getX(), e.getY());
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
    private void limparCampos() {
        txtRa.setText("");
        textField_1.setText("");
        textField_4.setText("");
        textField_3.setText("");
        textField_6.setText("");
        textField_7.setText("");
        if (fldCpf != null)      fldCpf.setValue(null);
        if (fldDataNasc != null) fldDataNasc.setValue(null);
        cmbUF.setSelectedIndex(0);
        buttonGroup.clearSelection();
    }
    
}