package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Aluno;

public class AlunoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Aluno aluno; 
	
	public AlunoDAO() {
		
	}

	// 1. Método Salvar 
	public void salvar(Aluno aluno) throws Exception {	
		if(aluno == null) {
			throw new Exception ("O Aluno nao pode ser nulo");
		}
			
        try {
            this.conn = ConnectionFactory.getConnection();
            
           
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
            
        } catch(SQLException sql) {
            throw new Exception("Erro ao inserir dados: " + sql);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
	}
	
	// 2. Método Listar 
	public List<Aluno> todosAlunos() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tbaluno");
			rs = ps.executeQuery();
			List<Aluno> list = new ArrayList<Aluno>();
			
			while (rs.next()) {
               
				String ra = rs.getString("ra");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				Date dataNasc = rs.getDate("dataNasc");
				String email = rs.getString("email");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String codCurso = rs.getString("codCurso");
				String endereco = rs.getString("endereco");
				String celular = rs.getString("celular");
				
				list.add(new Aluno(nome, ra, cpf, dataNasc, email, municipio, uf, codCurso, endereco, celular));
			}
			
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn);
		}
	}
	
	// 3. Método Atualizar 
	public void atualizar(Aluno aluno) throws Exception {
		if (aluno == null) {
			throw new Exception("O valor passado nao pode ser nulo");
        }
		
		try {
            this.conn = ConnectionFactory.getConnection();
		    String SQL = "UPDATE tbaluno SET nome=?, cpf=?, celular=?, dataNasc=?, email=?, endereco=?, municipio=?, uf=?, codCurso=? WHERE ra = ?";
			
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
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn);
		}
	}
	public boolean existeRaOuCpf(String ra, String cpf) {
	    String sql = "SELECT COUNT(*) FROM tbaluno WHERE ra = ? OR cpf = ?";
	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, ra);
	        stmt.setString(2, cpf);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0; // retorna true se encontrou pelo menos 1
	            }
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao verificar duplicidade: ", e);
	    }
	    return false;
	}
	// 4. Método Excluir 
	public void excluir(Aluno aluno) throws Exception {
		if (aluno == null) {
			throw new Exception("O valor passado nao pode ser nulo");
        }
		
		try {
            this.conn = ConnectionFactory.getConnection();
			String SQL = "DELETE FROM tbaluno WHERE ra = ?"; 
			ps = conn.prepareStatement(SQL);
			ps.setString(1, aluno.getRa());
			ps.executeUpdate();
            
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn);
		}
	}

	// 5. Método Procurar Aluno Específico
	public Aluno procurarAluno(String caAluno) throws Exception {
		try {
            this.conn = ConnectionFactory.getConnection();
			String SQL = "SELECT * FROM tbaluno WHERE ra=?"; 
			ps = conn.prepareStatement(SQL);
			ps.setString(1, caAluno);			
			rs = ps.executeQuery();
			
			if (rs.next()) {
               
				String ra = rs.getString("ra");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				Date dataNasc = rs.getDate("dataNasc");
				String email = rs.getString("email");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String codCurso = rs.getString("codCurso");
				String endereco = rs.getString("endereco");
				String celular = rs.getString("celular");
                
				aluno = new Aluno(nome, ra, cpf, dataNasc, email, municipio, uf, codCurso, endereco, celular);
			}
			
			return aluno;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn);
		}
	}
	
	public void salvarCursoDoAluno(String ra, int codCurso) {
	    
	    String sqlVerifica = "SELECT ra FROM tbaluno WHERE ra = ?";
	    String sqlAtualiza = "UPDATE tbaluno SET codCurso = ? WHERE ra = ?";

	    try (Connection conn = ConnectionFactory.getConnection()) {

	        try (PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica)) {
	            stmtVerifica.setString(1, ra);
	            ResultSet rs = stmtVerifica.executeQuery();
	            if (!rs.next()) {
	                throw new RuntimeException(
	                    "Aluno com RA " + ra + " não encontrado.\n" +
	                    "Salve os Dados Pessoais antes de vincular o curso.");
	            }
	        }

	        try (PreparedStatement stmtAtualiza = conn.prepareStatement(sqlAtualiza)) {
	            stmtAtualiza.setInt(1, codCurso);
	            stmtAtualiza.setString(2, ra);
	            stmtAtualiza.executeUpdate();
	        }

	    } catch (RuntimeException e) {
	        throw e;
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao salvar curso do aluno: ", e);
	    }
	}
	
	// Atualiza o codCurso do aluno na tabela tbaluno
	public void atualizarCursoAluno(String ra, int codCurso) {
	    String sql = "UPDATE tbaluno SET codCurso = ? WHERE ra = ?";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, codCurso);
	        stmt.setString(2, ra);

	        int linhasAfetadas = stmt.executeUpdate();

	        if (linhasAfetadas == 0) {
	            throw new RuntimeException("Nenhum aluno encontrado com o RA: " + ra);
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao atualizar curso do aluno: ", e);
	    }
	}
	
}