package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentCallSt {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcprtc";
		String path = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(path);
			Connection con=DriverManager.getConnection(url,userName,password);
			CallableStatement cs=con.prepareCall("call get_student(?)");
			cs.setInt(1, 1);
//			cs.setInt(1,9);
//			cs.setString(2, "ashwini");
//			cs.setLong(3, 89288971);
//			cs.setString(4, "jhk");
//			cs.setInt(5,78);
			ResultSet rs=cs.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getLong(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
			}
			System.out.println("saved");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
