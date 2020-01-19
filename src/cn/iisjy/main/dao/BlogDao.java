package cn.iisjy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;

import cn.iisjy.main.entity.iBlog;

public class BlogDao {
	public static String getBlogListJson() {
		String blogs = "NULL";

		return blogs;
	}

	public static String getBlogListJson(int size) throws ClassNotFoundException, SQLException {
		iBlog[] blog_entities = new iBlog[size];
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql = "select * from blogs order by xxx DESC limit ?;";
		pStmt = c.prepareStatement(sql);
		pStmt.setInt(1, size);
		ResultSet rs = pStmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			blog_entities[i].article_id = rs.getInt("");
			blog_entities[i].article_title = rs.getString("");
			blog_entities[i].article_author_id = rs.getInt("");
			blog_entities[i].article_sumary = rs.getString("");
			blog_entities[i].article_coverimg_hash = rs.getString("");
			blog_entities[i].article_type = rs.getString("");
			blog_entities[i].article_content = rs.getString("");
			blog_entities[i].article_status = rs.getString("");
			blog_entities[i].article_createtime = rs.getTimestamp("");
			blog_entities[i].article_author = UserDao.getUserEntity(blog_entities[i].article_author_id);
			blog_entities[i].article_coverimg = ImageDao.getImageEntity(blog_entities[i].article_coverimg_hash);
		}
		return JSONObject.toJSONString(blog_entities);

	}

	public static String getBlogListJson(int size, int page) {
		String blogs = "NULL";

		return blogs;
	}
}
