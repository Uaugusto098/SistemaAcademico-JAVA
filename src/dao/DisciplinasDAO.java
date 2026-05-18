package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Aluno;
import model.Disciplina;

public class DisciplinasDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private Aluno aluno;

    public DisciplinasDAO() {}

    // ================= SALVAR ALUNO =================
    public void salvar(Aluno aluno) throws Exception {
        if (aluno == null) throw new Exception("O Aluno nao pode ser nulo");

        try {
            conn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tbaluno (ra, nome, cpf, dataNasc, email, municipio, uf, codCurso, endereco, celular) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, aluno.getRa());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getCpf());
            ps.setDate(4, aluno.getDataNasc());
            ps.setString(5, aluno.getEmail());
            ps.setString(6, aluno.getMunicipio());
            ps.setString(7, aluno.getUf());
            ps.setString(8, aluno.getCodCurso());
            ps.setString(9, aluno.getEndereco());
            ps.setString(10, aluno.getCelular());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir aluno: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    // ================= LISTAR ALUNOS =================
    public List<Aluno> todosAlunos() throws Exception {
        List<Aluno> list = new ArrayList<>();

        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement("SELECT * FROM tbaluno");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Aluno(
                    rs.getString("nome"),
                    rs.getString("ra"),
                    rs.getString("cpf"),
                    rs.getDate("dataNasc"),
                    rs.getString("email"),
                    rs.getString("municipio"),
                    rs.getString("uf"),
                    rs.getString("codCurso"),
                    rs.getString("endereco"),
                    rs.getString("celular")
                ));
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar alunos: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }

        return list;
    }

    // ================= ATUALIZAR =================
    public void atualizar(Aluno aluno) throws Exception {
        if (aluno == null) throw new Exception("Aluno nao pode ser nulo");

        try {
            conn = ConnectionFactory.getConnection();

            String SQL = """
                UPDATE tbaluno
                   SET nome=?, cpf=?, celular=?, dataNasc=?, email=?, endereco=?, municipio=?, uf=?, codCurso=?
                 WHERE ra=?
            """;

            ps = conn.prepareStatement(SQL);

            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getCelular());
            ps.setDate(4, aluno.getDataNasc());
            ps.setString(5, aluno.getEmail());
            ps.setString(6, aluno.getEndereco());
            ps.setString(7, aluno.getMunicipio());
            ps.setString(8, aluno.getUf());
            ps.setString(9, aluno.getCodCurso());
            ps.setString(10, aluno.getRa());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar aluno: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    // ================= EXCLUIR =================
    public void excluir(Aluno aluno) throws Exception {
        if (aluno == null) throw new Exception("Aluno nao pode ser nulo");

        try {
            conn = ConnectionFactory.getConnection();

            ps = conn.prepareStatement("DELETE FROM tbaluno WHERE ra = ?");
            ps.setString(1, aluno.getRa());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao excluir aluno: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    // ================= BUSCAR POR RA =================
    public Aluno procurarAluno(String ra) throws Exception {
        try {
            conn = ConnectionFactory.getConnection();

            ps = conn.prepareStatement("SELECT * FROM tbaluno WHERE ra=?");
            ps.setString(1, ra);

            rs = ps.executeQuery();

            if (rs.next()) {
                aluno = new Aluno(
                    rs.getString("nome"),
                    rs.getString("ra"),
                    rs.getString("cpf"),
                    rs.getDate("dataNasc"),
                    rs.getString("email"),
                    rs.getString("municipio"),
                    rs.getString("uf"),
                    rs.getString("codCurso"),
                    rs.getString("endereco"),
                    rs.getString("celular")
                );
            }

            return aluno;

        } catch (SQLException e) {
            throw new Exception("Erro ao buscar aluno: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    // ================= LISTAR DISCIPLINAS (COMBO) =================
    public List<Disciplina> listarParaCombo() throws Exception {
        List<Disciplina> lista = new ArrayList<>();

        String SQL = "SELECT codDisciplina, nomeDisciplina FROM tbdisciplinas ORDER BY nomeDisciplina";

        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Disciplina d = new Disciplina();

                d.setCodDisciplina(rs.getInt("codDisciplina")); // ✅ INT
                d.setNomeDisciplina(rs.getString("nomeDisciplina"));

                lista.add(d);
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar disciplinas: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }

        return lista;
    }
}