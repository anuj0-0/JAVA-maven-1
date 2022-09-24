package jdbcproject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class BikeInsert {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		InputStream in = new FileInputStream("jdbcProperties.properties");
		p.load(in);

		String path = p.getProperty("jdbc.path");
		String url = p.getProperty("jdbc.url");
		String uName = p.getProperty("jdbc.uName");
		String pwd = p.getProperty("jdbc.pwd");
		String query="Insert into bike values(?,?,?,?,?,?)";
		Class.forName(path);
		Connection con = DriverManager.getConnection(url, uName, pwd);
		PreparedStatement ps= con.prepareStatement(query);
		
		Scanner s=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.Enter data \n2.Exit..");
			int ch=s.nextInt();
			switch(ch) {
			case 1:
					System.out.println("Enter id");
					int id=s.nextInt();
					s.nextLine();
					System.out.println("Enter name");
					String name=s.nextLine();
					System.out.println("Enter brand");
					String brand=s.nextLine();
					System.out.println("Enter mileage");
					int mileage=s.nextInt();
					s.nextLine();
					System.out.println("Enter address");
					String address=s.nextLine();
					System.out.println("Enter model");
					String model=s.nextLine();

					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, brand);
					ps.setInt(4, mileage);
					ps.setString(5, address);
					ps.setString(6, model);
					
					ps.execute();
			break;
			case 2: flag=false;
			break;
			default: 
					System.out.println("Enter valid input");
			}
			
		}
		con.close();

		
		
	}

}
