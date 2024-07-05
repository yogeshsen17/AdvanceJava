package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.bean.UserBean;

public class UserModel {

	public List search(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		StringBuffer sql = new StringBuffer("select * from users where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "'");

			}

		}
		System.out.println(sql.toString());

		PreparedStatement ptmt = conn.prepareStatement(sql.toString());
		ResultSet rs = ptmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLastName(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setGender(rs.getString(7));
			list.add(bean);
		}
		return list;

	}

	public int nextPK() throws Exception {

		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement ptmt = conn.prepareStatement("select max(id) from users");
		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

			System.out.println("max id" + pk);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		UserBean existBean = findbyloginId(bean.getLoginId());

		if (existBean != null) {

			System.out.println("login id is not exist please use different loginId");
		} else {

			PreparedStatement ptmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");

			ptmt.setInt(1, nextPK());
			ptmt.setString(2, bean.getFirstName());
			ptmt.setString(3, bean.getLastName());
			ptmt.setString(4, bean.getLoginId());
			ptmt.setString(5, bean.getPassword());
			ptmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			ptmt.setString(7, bean.getGender());

			int i = ptmt.executeUpdate();
			System.out.println("successfull");
		}

	}

	private UserBean findbyloginId(String loginId) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement ptmt = conn.prepareStatement("select * from users where loginId=?");
		ptmt.setString(1, loginId);
		ResultSet rs = ptmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setGender(rs.getString(7));
		}

		return bean;
	}

	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceJava", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update users set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ?, gender = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getGender());
		pstmt.setInt(7, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Update successfully.. " + i);
	}

}
