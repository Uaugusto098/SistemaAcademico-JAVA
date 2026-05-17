package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Aluno;





public class AlunoDAO {
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Aluno aluno; 
	
	
	
	
	
	public AlunoDAO() throws Exception{
		
		
		try {
			this.conn = ConnectionFactory.getConnection();
			
		}catch(Exception e) {
			
			throw new Exception("erro:\n"+e.getMessage());
		}
	}
	
	
	public void atualizar(Aluno aluno) throws Exception{
		
		
		
		
	}
	
	
	
	
	
	
	

}
