package jdbcproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RetrevingEmpolyee {
	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		InputStream in = new FileInputStream("jdbcProperties.properties");
		p.load(in);

		String path = p.getProperty("jdbc.path");
		String url = p.getProperty("jdbc.url");
		String uName = p.getProperty("jdbc.uName");
		String pwd = p.getProperty("jdbc.pwd");

		try {

			Class.forName(path);
			Connection connection = DriverManager.getConnection(url, uName, pwd);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM empolyee where floor='4'");
			System.out.println("--------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getLong(3) + " ");
				System.out.print(rs.getString(4) + " ");
				System.out.print(rs.getString(5) + " ");
				System.out.print(rs.getString(6) + " ");
				System.out.print(rs.getInt(7) + " ");
				System.out.println(rs.getString(8) + " ");
				System.out.println("--------------------------------------");
			}
			st.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
