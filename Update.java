package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprtc", "root", "root");
		Statement statment=connection.createStatement();
		statment.execute("UPDATE `jdbcprtc`.`student` SET `Name` = 'Msdhoni' WHERE (`Id` = '4')");
		statment.execute("UPDATE `jdbcprtc`.`student` SET `PhoneNumber` = 1100110011 WHERE (`Id` = '1')");
		statment.execute("UPDATE `jdbcprtc`.`student` SET `Pincode` = 333333 WHERE (`Id` = '6')");
		connection.close();
		System.out.println("UPDATED");
	}

}
