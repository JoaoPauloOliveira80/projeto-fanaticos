package fanaticos.application.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	private static Connection conn;
	// create the connection
	private static String USER = "root";
	private static String DB ="db_fanaticos";
	private static String PASSWORD = "vertrigo";
	private static String URL = "jdbc:mysql://localhost:3306/"+DB+"?autoReconnect=true&useSSL=false";

	public static Connection conectar() {

		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				if (conn != null) {
					System.out.println("Connected to Database...");
					
				}
				return conn;

			} catch (SQLException e) {
				throw new RuntimeException("Cannot connect to database", e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}
	
//	public static void main(String[] args) throws SQLException {
//		
//		//RECUPERA UMA CONEXAO COM O BANCO
//		Connection conn =  conectar();
//		
//		//TESTA CONEXAO
//		if(conn != null) {
//			System.out.println("Conexão Obtida com sucesso");
//			conn.close();
//		}
//		
//	}

}
