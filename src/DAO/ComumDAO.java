package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class ComumDAO {

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/restaurante", "root", "");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}

		return connection;

	}

}
