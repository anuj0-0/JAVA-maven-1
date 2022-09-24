package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.SignUp;

public class SignUpDao {
	String url = "jdbc:mysql://localhost:3306/jdbcprtc";
	String path = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "root";
	Connection con = null;

	public String saveUser(SignUp s) {
		String query = "INSERT INTO `jdbcprtc`.`users` VALUES (?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setLong(5, s.getPhone());
			ps.setString(6, s.getDob());
			ps.setString(7, s.getGender());
			ps.executeUpdate();
			return "saved";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "failed to save";
	}

	public String updateUser(SignUp s) {
		String query = "UPDATE `jdbcprtc`.`users` SET  firstName=?,`lastName` = ?,  `password` = ?, `phone` = ?, `dob` = ?, `gender` = ? WHERE (`email` = ?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(7, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getPhone());
			ps.setString(5, s.getDob());
			ps.setString(6, s.getGender());
			int a = ps.executeUpdate();
			if (a == 1) {
				return "updated";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "failed to update";
	}

	public String deleteUser(String email) {
		String query = "DELETE FROM `jdbcprtc`.`users` WHERE (`email` = ?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			int a = ps.executeUpdate();
			if (a == 1)
				return "deleted";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "failed to delete";
	}

	public SignUp getUser(String email) {
		String query = "SELECT * FROM jdbcprtc.users where email=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			SignUp s = new SignUp();
			while (rs.next()) {

				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(5));
				s.setDob(rs.getString(6));
				s.setGender(rs.getString(7));
			}
			return s;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<SignUp> getAll() {
		String query = "SELECT * FROM jdbcprtc.users";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<SignUp> l = new ArrayList();
			while (rs.next()) {
				SignUp s = new SignUp();
				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(5));
				s.setDob(rs.getString(6));
				s.setGender(rs.getString(7));
				l.add(s);
			}
			return l;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public SignUp getByUsernameAndPassword(String email, String password) {
		String query = "Select * from users where email=? AND password =?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, userName, this.password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				rs.next();
				SignUp s = new SignUp();
				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(5));
				s.setDob(rs.getString(6));
				s.setGender(rs.getString(7));
				return s;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
