package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbcprtc";
		String uName="root";
		String pwd="root";
		Class.forName(path);
		Connection connection = DriverManager.getConnection(url,uName,pwd);
		Statement st = connection.createStatement();
		st.execute("DELETE FROM `jdbcprtc`.`empolyee` WHERE (`Id` = '7')");
		connection.close();
		System.out.println("deleted");
	}

}
