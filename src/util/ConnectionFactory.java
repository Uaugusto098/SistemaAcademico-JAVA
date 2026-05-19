package util;
import java.sql.*;
import java.security.DomainCombiner;
public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception{
		System.setProperty("file.encoding", "UTF-8");  // ← adicione aqui
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/dbacademico?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
		String login="root";
		String senha="";
		
		Connection conn = DriverManager.getConnection(url, login, senha);
		conn.createStatement().execute("SET NAMES 'utf8mb4'");
		return conn;
		
	} 
		catch(Exception e) {
		throw new Exception(e.getMessage());
	}
	}
	
	
	
	public static void closeConnection(Connection conn) {
        if (conn != null) { // ← evita NullPointerException
            try {
                conn.close();
            } catch (Exception e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}





	