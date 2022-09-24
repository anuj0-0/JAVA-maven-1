package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonBatch {
	String url = "jdbc:mysql://localhost:3306/jdbcprtc";
	String path = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "root";
	Connection con = null;

	public String insertPerson(List<Person> l) {
		String query = "INSERT INTO `jdbcprtc`.`person`  VALUES (?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			for (Person p : l) {
				ps.setInt(1, p.getId());
				ps.setString(2, p.getName());
				ps.setString(3, p.getAddress());
				ps.setLong(4, p.getPhone());
				ps.setInt(5, p.getId());
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("saved");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "not saved";

	}

}
