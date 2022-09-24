package jdbcproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class RetrevingStudent {
	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		InputStream in=new FileInputStream("jdbcproperties.properties");
		p.load(in);
		
		
		String url = p.getProperty("jdbc.url");
		String uName =p.getProperty("jdbc.uName");
		String pwd =p.getProperty("jdbc.pwd");

		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection connection = DriverManager.getConnection(url, uName, pwd);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM student");
			System.out.println("ID  Name   PhoneNumber  Address  Pincode");
			System.out.println("--------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");
				System.out.printf(rs.getString(2) + " ");
				System.out.print(rs.getLong(3) + " ");
				System.out.print(rs.getString(4) + " ");
				System.out.println(rs.getLong(5) + " ");
				System.out.println("--------------------------------------");

			}
			st.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
