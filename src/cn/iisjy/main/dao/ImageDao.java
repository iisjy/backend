package cn.iisjy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;

import cn.iisjy.main.entity.iImage;

public class ImageDao {
	public static String getImage(String hash) throws SQLException, ClassNotFoundException {
		iImage img=new iImage();
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql="select * from iImg where img_hash = ? ;";
		pStmt = c.prepareStatement(sql);
		pStmt.setString(1, hash);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			img.img_hash	=rs.getString(0);
			img.img_location=rs.getString(1);
			img.img_type	=rs.getString(2);
			img.img_title	=rs.getString(3);
			img.img_alt		=rs.getString(4);
		}
		c.close();
		if("NULL".equals(img.img_type)) {
			return "NULL";
		}
		return JSONObject.toJSONString(img);
	}
}
