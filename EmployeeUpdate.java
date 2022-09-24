package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprtc", "root", "root");
		Statement st = connection.createStatement();
		st.execute("UPDATE `jdbcprtc`.`empolyee` SET `Floor` = '12' WHERE (`Id` = '6')");
		st.execute("UPDATE `jdbcprtc`.`empolyee` SET `Floor` = '13' WHERE (`Id` = '7')");
		st.execute("UPDATE `jdbcprtc`.`empolyee` SET `Floor` = '9' WHERE (`Id` = '5');");

		connection.close();
		System.out.println("UPDATED");
	}

}
