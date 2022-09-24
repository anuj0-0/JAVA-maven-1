package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprtc", "root", "root");
		Statement statment=connection.createStatement();
		statment.execute("INSERT INTO STUDENT VALUES(1,'ESHU',9900990099,'White Filed',560040)");
		statment.execute("INSERT INTO STUDENT VALUES(2,'Nagu',8800880088,'WF',560041)");
		statment.execute("INSERT INTO STUDENT VALUES(3,'Saurav',7700770077,'Odisha',340056)");
		statment.execute("INSERT INTO STUDENT VALUES(4,'MSDHONI',600660066,'Ranchi',440044)");
		statment.execute("INSERT INTO STUDENT VALUES(5,'Ramesh',5500550055,'dk',112211)");
		statment.execute("INSERT INTO STUDENT VALUES(6,'Rani',44044004400,'Pakistan',000000)");
		statment.execute("INSERT INTO STUDENT VALUES(7,'Ranna',3300330033,'HR',710023)");
		connection.close();
		System.out.println("saved");
		
		
	}

}
