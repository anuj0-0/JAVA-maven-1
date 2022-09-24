package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMobile {
	String url = "jdbc:mysql://localhost:3306/jdbcprtc";
	String path = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "root";
	Connection con = null;

	public String insertMobile(Mobile m) {
		String query = "INSERT INTO `jdbcprtc`.`mobile`  VALUES (?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getBrand());
			ps.setString(4, m.getColour());
			ps.setDouble(5, m.getPrice());
			ps.setInt(6, m.getRam());
			ps.setInt(7, m.getCamera());
			int row = ps.executeUpdate();
			if (row == 1) {
				return "Data saved";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "failed to save mobile";
	}

	public String updateMobile(Mobile m) {
		String query = "UPDATE `jdbcprtc`.`mobile` SET `name` = ? `brand` = ?, 'color` = ?, `price` = ?, `ram` = ?, `camera` = ? WHERE (`id` = ?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(7, m.getId());
			ps.setString(1, m.getName());
			ps.setString(2, m.getBrand());
			ps.setString(3, m.getColour());
			ps.setDouble(4, m.getPrice());
			ps.setInt(5, m.getRam());
			ps.setInt(6, m.getCamera());
			int row = ps.executeUpdate();
			if (row == 1) {
				return "updated";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failed to update mobile";
	}

	public String deleteMobile(Mobile m) {
		String query = "DELETE FROM `jdbcprtc`.`mobile` WHERE (`id` = ?);";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getId());
			int row = ps.executeUpdate();
			if (row == 1) {
				return "mobile deleted";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failed to delete mobile";

	}

	public Mobile getMobile(Mobile m) {
		String query="SELECT * FROM jdbcprtc.mobile where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getId());
			ResultSet rs=ps.executeQuery();
			if(rs!=null) {
				Mobile m1=new Mobile();
				while(rs.next()) {
					m1.setId(rs.getInt(1));
					m1.setName(rs.getString(2));
					m1.setBrand(rs.getString(3));
					m1.setColour(rs.getString(4));
					m1.setPrice(rs.getDouble(5));
					m1.setRam(rs.getInt(6));
					m1.setCamera(rs.getInt(7));
					return m1;
				}
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
