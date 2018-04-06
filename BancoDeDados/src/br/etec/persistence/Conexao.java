package br.etec.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static String connectionDriverClass="com.mysql.jdbc.Driver";
	private static String  connectionUrl = "jdbc:mysql://localhost/java";
	private static String connectionUsername="root";
	private static String connectionPassword="";
	private static Connection conn;

	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(Conexao.conn != null) {
			return Conexao.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
					Conexao.connectionUrl,
					Conexao.connectionUsername,
					Conexao.connectionPassword);
		}
		
	}

}

