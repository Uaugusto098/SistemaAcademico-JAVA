import java.sql.*;

import util.ConnectionFactory;
public class Main {

	public static void main(String[] args) {
		
		try{
			System.out.println("Tentando conexão no banco de dados");
			Connection conn= ConnectionFactory.getConnection();
			
			if(conn!=null)
			{
				System.out.println("Conexão bem estabelecida com o banco de dados");
				ConnectionFactory.closeConnection(conn);
				System.out.println("Conexão fechada e testada!");
			}
		}catch(Exception e)
		{
			System.out.println("Falha na conexão: "+e.getMessage());
		}
			
				
				
			
			
			
			
		}

	}


