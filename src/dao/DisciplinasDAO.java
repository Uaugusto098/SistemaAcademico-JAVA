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

public class DisciplinasDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Aluno aluno; 
	
	public DisciplinasDAO() {
		
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
}

