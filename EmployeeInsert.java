package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprtc", "root", "root");
		Statement st = connection.createStatement();
		st.execute("INSERT INTO empolyee VALUES(1,'AJJU',7834987645,'SOFTWARE ENGINEER','BANGALORE','JOHN',2,'A') ");
		st.execute("INSERT INTO empolyee VALUES(2,'SHANU',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',3,'B') ");
		st.execute("INSERT INTO empolyee VALUES(3,'SHAIVI',7834987645,'SOFTWARE ENGINEER','BANGALORE','JOHN',4,'C') ");
		st.execute("INSERT INTO empolyee VALUES(4,'SIMMI',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',1,'C') ");
		st.execute("INSERT INTO empolyee VALUES(5,'ESHU',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',2,'D') ");
		st.execute("INSERT INTO empolyee VALUES(6,'ABHI',7834987645,'SOFTWARE ENGINEER','BANGALORE','JOHN',3,'A') ");
		st.execute("INSERT INTO empolyee VALUES(7,'SURI',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',2,'B') ");
		connection.close();
		System.out.println("Inserted");

	}

}
