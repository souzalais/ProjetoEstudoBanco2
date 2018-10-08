package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/bdpessoas";
		try {
			conn = DriverManager.getConnection(url, "root","");
			//JOptionPane.showMessageDialog(null, "Conectado com Sucesso!");
		}catch(SQLException e) {
			System.out.println("Error na conexão com o banco! ");
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
