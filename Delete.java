package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprtc", "root", "root");
		Statement statment=connection.createStatement();
		statment.execute("DELETE FROM `jdbcprtc`.`student` WHERE (`Id` = '7')");
		connection.close();
		System.out.println("deleted");
	}

}
