package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConnectionFactory;
import model.Aluno;
import model.Desempenho;

public class DesempenhoDAO {

    // ── CONSULTAR ────────────────────────────────────────────────
    // Botão 🔍 — busca nota e faltas pelo trio (RA, disciplina, semestre)
	public Desempenho consultar(String ra, int codDisciplina, String semestre) throws Exception {
	    String SQL = """
	        SELECT d.ra, d.codDisciplina, d.semestre, d.nota, d.faltas,
	               a.nome, c.nomeCurso
	          FROM tbdesempenho d
	          JOIN tbaluno a ON a.ra = d.ra
	          JOIN tbcurso c ON c.codCurso = a.codCurso
	         WHERE d.ra = ? AND d.codDisciplina = ? AND d.semestre = ?
	        """;

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(SQL)) {

	        ps.setString(1, ra);
	        ps.setInt(2, codDisciplina); // ✅ CORRETO
	        ps.setString(3, semestre);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                Desempenho d = new Desempenho();
	                d.setRa(rs.getString("ra"));
	                d.setNome(rs.getString("nome"));
	                d.setCodCurso(rs.getString("nomeCurso"));
	                d.setCodDisciplina(rs.getInt("codDisciplina")); // ✅ CORRETO
	                d.setSemestre(rs.getString("semestre"));
	                d.setNota(rs.getDouble("nota"));
	                d.setFaltas(rs.getInt("faltas"));
	                return d;
	            }
	        }
	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao consultar desempenho: " + sqle);
	    }
	    return null;
	}

    // ── INSERIR ──────────────────────────────────────────────────
    // Botão 💾 — grava novo registro
	public void inserir(Desempenho d) throws Exception {
	    String SQL = "INSERT INTO tbdesempenho (ra, codDisciplina, semestre, nota, faltas) VALUES (?, ?, ?, ?, ?)";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(SQL)) {

	        ps.setString(1, d.getRa());
	        ps.setInt(2, d.getCodDisciplina()); // ✅ CORRETO
	        ps.setString(3, d.getSemestre());
	        ps.setDouble(4, d.getNota());
	        ps.setInt(5, d.getFaltas());

	        ps.executeUpdate();

	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao inserir desempenho: " + sqle);
	    }
	}

    // ── ALTERAR ──────────────────────────────────────────────────
    // Botão 🔄 — atualiza nota e faltas de registro existente
	public boolean alterar(Desempenho d) throws Exception {
	    String SQL = """
	        UPDATE tbdesempenho
	           SET nota = ?, faltas = ?
	         WHERE ra = ? AND codDisciplina = ? AND semestre = ?
	        """;

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(SQL)) {

	        ps.setDouble(1, d.getNota());
	        ps.setInt(2, d.getFaltas());
	        ps.setString(3, d.getRa());
	        ps.setInt(4, d.getCodDisciplina()); // ✅ CORRETO
	        ps.setString(5, d.getSemestre());

	        return ps.executeUpdate() > 0;

	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao alterar desempenho: " + sqle);
	    }
	}
    // ── EXCLUIR ──────────────────────────────────────────────────
    // Botão 🗑️ — remove o registro
	public boolean excluir(String ra, int codDisciplina, String semestre) throws Exception {
	    String SQL = "DELETE FROM tbdesempenho WHERE ra = ? AND codDisciplina = ? AND semestre = ?";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(SQL)) {

	        ps.setString(1, ra);
	        ps.setInt(2, codDisciplina); // ✅ CORRETO
	        ps.setString(3, semestre);

	        return ps.executeUpdate() > 0;

	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao excluir desempenho: " + sqle);
	    }
	}

    // ── BUSCAR ALUNO POR RA ──────────────────────────────────────
    // Usado no focusLost do txtRaNotas para preencher nome e curso
    public Aluno buscarAlunoPorRa(String ra) throws Exception {
        String SQL = """
            SELECT a.nome, c.nomeCurso
              FROM tbaluno a
              JOIN tbcurso c ON c.codCurso = a.codCurso
             WHERE a.ra = ?
            """;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setString(1, ra);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Aluno a = new Aluno();
                    a.setRa(ra);
                    a.setNome(rs.getString("nome"));
                    a.setCodCurso(rs.getString("nomeCurso"));
                    return a;
                }
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro ao buscar aluno: " + sqle);
        }
        return null;
    }
    
    
    // ── BUSCAR BOLETIM COMPLETO DO ALUNO ──────────────────────────
    // Retorna a lista de todas as matérias cursadas pelo aluno com notas e faltas
    public java.util.List<Desempenho> buscarBoletimCompleto(String ra) throws Exception {
        String SQL = """
            SELECT d.nota, d.faltas, disc.nomeDisciplina
              FROM tbdesempenho d
              JOIN tbdisciplinas disc ON disc.codDisciplina = d.codDisciplina
             WHERE d.ra = ?
            """;
            
        java.util.List<Desempenho> listaBoletim = new java.util.ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setString(1, ra);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Desempenho d = new Desempenho();
                    d.setNota(rs.getDouble("nota"));
                    d.setFaltas(rs.getInt("faltas"));
                    
                    // Como Desempenho herda de Aluno, usamos o setNome() herdado
                    // para guardar temporariamente o nome da Disciplina que vai para a tabela
                    d.setNome(rs.getString("nomeDisciplina")); 
                    
                    listaBoletim.add(d);
                }
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro ao buscar lista do boletim: " + sqle);
        }
        return listaBoletim;
    }
    
}

