package cn.iisjy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;

import cn.iisjy.main.entity.iBlog;

public class BlogDao {
	public static String getBlogListJson() throws ClassNotFoundException, SQLException {
		ArrayList<iBlog> blog_entities = new ArrayList<iBlog>();
		iBlog b ;
		
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql = "select * from blogs order by article_id DESC;";
		pStmt = c.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			b=new iBlog();
			b.article_id = rs.getInt("");
			b.article_title = rs.getString("");
			b.article_author_id = rs.getInt("");
			b.article_sumary = rs.getString("");
			b.article_coverimg_hash = rs.getString("");
			b.article_type = rs.getString("");
			b.article_content = rs.getString("");
			b.article_status = rs.getString("");
			b.article_createtime = rs.getTimestamp("");
			b.article_author = UserDao.getUserEntity(b.article_author_id);
			b.article_coverimg = ImageDao.getImageEntity(b.article_coverimg_hash);
			blog_entities.add(b);
		}
		return JSONObject.toJSONString(blog_entities);
	}

	public static String getBlogListJson(int size) throws ClassNotFoundException, SQLException {
		iBlog[] blog_entities = new iBlog[size];
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql = "select * from blogs order by article_id DESC limit ?;";
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
			i+=1;
		}
		return JSONObject.toJSONString(blog_entities);

	}

	public static String getBlogListJson(int size, int page) {
		String blogs = "NULL";

		return blogs;
	}
}
