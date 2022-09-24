package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String url = "jdbc:mysql://localhost:3306/jdbcprtc";
	String path = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "root";
	Connection con = null;

	public String savePerson(int id, String name, String address, long phone, int pin) {
		String query = "INSERT INTO `jdbcprtc`.`person`  VALUES (?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setLong(4, phone);
			ps.setInt(5, pin);
			int a = ps.executeUpdate();
			if (a == 1) {
				return "Values inserted";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failed to insert values";

	}

	public String savePerson(Person p) {
		String query = "INSERT INTO `jdbcprtc`.`person`  VALUES (?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,p.getId());
			ps.setString(2,p.getName());
			ps.setString(3,p.getAddress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPin());
			int a = ps.executeUpdate();
			if (a == 1) {
				return "Values inserted";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failed to insert values";

	}

	public String updatePerson(int id, String name, String address, long phone, int pin) {
		String query = "UPDATE `jdbcprtc`.`person` SET `name` = ?, `address` = ?, `phone` = ?, `pincode` = ? WHERE id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(5, id);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setLong(3, phone);
			ps.setInt(4, pin);
			int a = ps.executeUpdate();
			if (a == 1) {
				return "Updated";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failed to update values";
	}
	
	public String updatePerson(Person p) {
		String query = "UPDATE `jdbcprtc`.`person` SET `name` = ?, `address` = ?, `phone` = ?, `pincode` = ? WHERE id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(5, p.getId());
			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress());
			ps.setLong(3, p.getPhone());
			ps.setInt(4, p.getPin());
			int a = ps.executeUpdate();
			if (a == 1) {
				return "Updated";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failed to update values";
	}

	public String deletePerson(int id) {
		String query = "DELETE FROM `jdbcprtc`.`person` WHERE (`id` = ?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				return "Deleted";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Failed to delete";

	}

	public String getPerson(int id) {
		String query = "Select * from person where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				System.out.println("--------------------------------------");
				while (rs.next()) {
					System.out.print(rs.getInt(1) + " ");
					System.out.printf(rs.getString(2) + " ");
					System.out.print(rs.getString(3) + " ");
					System.out.print(rs.getLong(4) + " ");
					System.out.println(rs.getInt(5) + " ");
					System.out.println("--------------------------------------");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Failed to Get Person";
	}
		
		public Person getPersonObj(int id) {
			String query = "Select * from person where id=?";
			try {
				Class.forName(path);
				con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Person p=new Person();
						p.setId(rs.getInt(1));
						p.setName(rs.getString(2));
						p.setAddress(rs.getString(3));
						p.setPhone(rs.getLong(4));
						p.setPin(rs.getInt(5));
						return p;
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
	}

}
