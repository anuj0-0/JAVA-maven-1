package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	String url = "jdbc:mysql://localhost:3306/jdbcprtc";
	String path = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "root";
	Connection con = null;

	public String saveProduct(List<Product> l) {
		String query = "INSERT INTO `jdbcprtc`.`product` VALUES (?,?,?,?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			for (Product pr : l) {
				ps.setInt(1, pr.getId());
				ps.setString(2, pr.getName());
				ps.setDouble(3, pr.getPrice());
				ps.setString(4, pr.getManufacturer());
				ps.setDouble(5, pr.getDiscount());
				ps.setInt(6, pr.getWarranty());
				ps.setString(7, pr.getManufaterDate());
				ps.setInt(8, pr.getGst());
				ps.addBatch();
			}
			ps.executeBatch();
			return "inserted";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "failed to insert";
	}

	public String saveProduct(Product pr) {
		String query = "INSERT INTO `jdbcprtc`.`product` VALUES (?,?,?,?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			// for (Product pr : l) {
			ps.setInt(1, pr.getId());
			ps.setString(2, pr.getName());
			ps.setDouble(3, pr.getPrice());
			ps.setString(4, pr.getManufacturer());
			ps.setDouble(5, pr.getDiscount());
			ps.setInt(6, pr.getWarranty());
			ps.setString(7, pr.getManufaterDate());
			ps.setInt(8, pr.getGst());
			ps.addBatch();

			ps.executeBatch();
			return "inserted";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "failed to insert";
	}

	public String updatePerson(Product pr) {
		String query = "UPDATE `jdbcprtc`.`product` SET `name` = ?, `price` = ?, `manufacter` = ?, `discount` = ?, `warranty` = ?, `manufacterDate` =?, `GST` = ? WHERE (`id` = ?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(8, pr.getId());
			ps.setString(1, pr.getName());
			ps.setDouble(2, pr.getPrice());
			ps.setString(3, pr.getManufacturer());
			ps.setDouble(4, pr.getDiscount());
			ps.setInt(5, pr.getWarranty());
			ps.setString(6, pr.getManufaterDate());
			ps.setInt(7, pr.getGst());
			int a = ps.executeUpdate();
			return "updated";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return "failed to update";
	}

	public String deleteProduct(Product p) {
		String query = "DELETE FROM `jdbcprtc`.`product` WHERE (`id` = ?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			int a = ps.executeUpdate();
			return "deleted";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return "failed to delete";
	}

	public Product getProduct(Product p) {
		String query = "SELECT * FROM jdbcprtc.product where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();
			Product p1 = new Product();
			while (rs.next()) {

				p1.setId(rs.getInt(1));
				p1.setName(rs.getString(2));
				p1.setPrice(rs.getDouble(3));
				p1.setManufacturer(rs.getString(4));
				p1.setDiscount(rs.getDouble(5));
				p1.setWarranty(rs.getInt(6));
				p1.setGst(rs.getInt(8));

			}
			return p1;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;

	}

	public List<Product> getProduct() {
		String query = "SELECT * FROM jdbcprtc.product ";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Product> l = new ArrayList();
			while (rs.next()) {
				Product p1 = new Product();
				p1.setId(rs.getInt(1));
				p1.setName(rs.getString(2));
				p1.setPrice(rs.getDouble(3));
				p1.setManufacturer(rs.getString(4));
				p1.setDiscount(rs.getDouble(5));
				p1.setWarranty(rs.getInt(6));
				p1.setGst(rs.getInt(8));
				l.add(p1);

			}
			return l;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;

	}
}
