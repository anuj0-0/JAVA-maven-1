package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load and register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprtc", "root", "root");
		//Create Statement
		Statement statment=connection.createStatement();
		//Execute query
		statment.execute("INSERT INTO EMP VALUES(1,'RAJU')");
		//close
		connection.close();
		System.out.println("SAVED");

	}

}
