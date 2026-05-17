package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import util.ConnectionFactory;

public class CursoDAO {

    //Povoa o JComboBox de Cursos sem duplicar nomes (Retorna os 5 cursos unicos)
    public List<Curso> listarCursosParaCombo() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT MIN(codCurso) as codCurso, nomeCurso FROM tbcurso GROUP BY nomeCurso ORDER BY nomeCurso";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setCodCurso(rs.getInt("codCurso"));
                c.setNomeCurso(rs.getString("nomeCurso"));
                lista.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar cursos para o combo: ", e);
        }
        return lista;
    }

    //Povoa o JComboBox de Campus sem duplicar (Retorna os 3 campi unicos)
    public List<String> listarCampiParaCombo() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT campus FROM tbcurso GROUP BY campus ORDER BY campus";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getString("campus"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar campi: ", e);
        }
        return lista;
    }

    //O Detetive: Descobre o codCurso (1 a 45) baseado na combinacao da tela
    public int descobrirCodCurso(String nomeCurso, String campus, String periodo) {
        String sql = "SELECT codCurso FROM tbcurso WHERE nomeCurso = ? AND campus = ? AND periodo = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nomeCurso);
            stmt.setString(2, campus);
            stmt.setString(3, periodo);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("codCurso");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ID do curso: ", e);
        }
        return 0;
    }
    
}