package cn.iisjy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;

import cn.iisjy.main.entity.iUser;

public class UserDao {
	public static iUser getUserEntity(int user_id) throws ClassNotFoundException, SQLException {
		iUser u = new iUser();
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql ="select * from iUser where user_id = ?";
		pStmt = c.prepareStatement(sql);
		pStmt.setInt(1, user_id);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			u.user_id = rs.getInt("user_id");
			u.user_name = rs.getString("user_name");
			u.user_pswd_hash = rs.getString("user_pswd_salt");
			u.user_pswd_salt = rs.getString("user_pswd_salt");
			u.user_login_phone = rs.getString("user_login_phone");
			u.user_login_email = rs.getString("user_login_email");
			u.user_real_name = rs.getString("user_real_name");
			u.user_certificate = rs.getInt("user_certificate");
			u.user_avatar_hash = rs.getString("user_avatar");
			u.user_sex = rs.getString("user_sex");
			u.user_birthdate = rs.getTimestamp("user_birthdate");
		}
		if (u.user_id == -1) {
			return null;
		} else {
//			u.user_avatar = ImageDao.getImageEntity(u.user_avatar_hash);
			return u;
		}

	}

	public static String getSalt(String account) throws ClassNotFoundException, SQLException {
		String salt = "NULL";
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql = "select user_pswd_salt from iUser where (user_name = ? or user_login_phone = ? or user_login_email = ?)";
		pStmt = c.prepareStatement(sql);
		pStmt.setString(1, account);
		pStmt.setString(2, account);
		pStmt.setString(3, account);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			salt = rs.getString("user_pswd_salt");
		}
		return salt;
	}

	public static String login(String account, String token) throws ClassNotFoundException, SQLException {
		iUser u = new iUser();
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql = "select * from iUser where (pswd_hash = ? and (user_name = ? or user_login_phone = ? or user_login_email = ?))";
		pStmt = c.prepareStatement(sql);
		pStmt.setString(1, token);
		pStmt.setString(2, account);
		pStmt.setString(3, account);
		pStmt.setString(4, account);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			u.user_id = rs.getInt("user_id");
			u.user_name = rs.getString("user_name");
			u.user_pswd_hash = rs.getString("user_pswd_salt");
			u.user_pswd_salt = rs.getString("user_pswd_salt");
			u.user_login_phone = rs.getString("user_login_phone");
			u.user_login_email = rs.getString("user_login_email");
			u.user_real_name = rs.getString("user_real_name");
			u.user_certificate = rs.getInt("user_certificate");
			u.user_avatar_hash = rs.getString("user_avatar");
			u.user_sex = rs.getString("user_sex");
			u.user_birthdate = rs.getTimestamp("user_birthdate");
		}
		if (u.user_id == -1) {
			return "NULL";
		} else {
			u.user_avatar = ImageDao.getImageEntity(u.user_avatar_hash);
			return JSONObject.toJSONString(u);
		}
	}
}
