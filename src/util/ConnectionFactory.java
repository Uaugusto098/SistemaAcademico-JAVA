package util;
import java.sql.*;
import java.security.DomainCombiner;
public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/aluno_academico";
		String login="root";
		String senha="";
		
		return DriverManager.getConnection(url,login,senha);
		
	} 
		catch(Exception e) {
		throw new Exception(e.getMessage());
	}
	}
	
	
	
	public static void closeConnection(Connection conn) throws Exception{
		close(conn);
		
	}
	
	private static void close(Connection conn) 
		throws Exception{
			
			try {
				conn.close();
				
			}
			
			catch(Exception e)
			{
				throw new Exception(e.getMessage());
			}
		}
	}





	