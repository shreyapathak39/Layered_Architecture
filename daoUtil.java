package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoUtil {
		static Connection con; // holds connection in between java & database
		

		
		public static Connection dbconnect() throws SQLException, ClassNotFoundException {
			String path = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "system";
			String password = "Oracle_1998";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(path, username, password);
			System.out.println(" Connection Establish ----->> " + con);
			return con;
		}
}

