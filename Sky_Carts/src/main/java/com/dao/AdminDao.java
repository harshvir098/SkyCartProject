package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Admin;
import com.entity.User;

public class AdminDao {

	private Connection conn;

	public AdminDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	/*helloworld*/

	public boolean addUser(Admin user) {
		boolean f = false;
		try {
			String sql = "insert into admin(full_name,email,mobno,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getPassword());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateUser(Admin user) {
		boolean f = false;
		try {
			String sql = "update admin set full_name=?,email=?,mobno=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getId());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Admin login(String email, String password) {
		Admin user = null;
		try {
			String sql = "select * from admin where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Admin();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<Admin> getAllAdmin() {
		List<Admin> list = new ArrayList<Admin>();
		Admin user = null;
		try {
			String sql = "select * from admin";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Admin();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				list.add(user);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Admin getUser(int userId) {
		Admin user = null;
		try {
			String sql = "select * from admin where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Admin();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkEmail(String email) {
		boolean f = true;
		try {
			String sql = "select * from admin where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteAdmin(int id) {
		boolean f = true;
		try {
			String sql = "delete from admin where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
