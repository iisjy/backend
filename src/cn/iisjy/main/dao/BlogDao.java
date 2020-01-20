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
		String sql = "select * from iblog order by article_id DESC;";
		pStmt = c.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			b=new iBlog();
			b.article_id = rs.getInt("article_id");
			b.article_title = rs.getString("article_title");
			b.article_author_id = rs.getInt("article_author");
			b.article_sumary = rs.getString("article_sumary");
			b.article_coverimg_hash = rs.getString("article_coverimg");
			b.article_type = rs.getString("article_type");
			b.article_content = rs.getString("article_content");
			b.article_status = rs.getString("article_status");
			b.article_createtime = rs.getTimestamp("article_createtime");
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
		String sql = "select * from iblog order by article_id DESC limit ?;";
		pStmt = c.prepareStatement(sql);
		pStmt.setInt(1, size);
		ResultSet rs = pStmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			blog_entities[i].article_id = rs.getInt("article_id");
			blog_entities[i].article_title = rs.getString("article_title");
			blog_entities[i].article_author_id = rs.getInt("article_author");
			blog_entities[i].article_sumary = rs.getString("article_sumary");
			blog_entities[i].article_coverimg_hash = rs.getString("article_coverimg");
			blog_entities[i].article_type = rs.getString("article_type");
			blog_entities[i].article_content = rs.getString("article_content");
			blog_entities[i].article_status = rs.getString("article_status");
			blog_entities[i].article_createtime = rs.getTimestamp("article_createtime");
			blog_entities[i].article_author = UserDao.getUserEntity(blog_entities[i].article_author_id);
			blog_entities[i].article_coverimg = ImageDao.getImageEntity(blog_entities[i].article_coverimg_hash);
			i+=1;
		}
		return JSONObject.toJSONString(blog_entities);

	}

	public static String getBlogListJson(int size, int page) throws ClassNotFoundException, SQLException {
		iBlog[] blog_entities = new iBlog[size];
		Connection c = InitSQL.getConnection();
		PreparedStatement pStmt;
		String sql = "select * from iblog order by article_id DESC limit ?,?;";
		pStmt = c.prepareStatement(sql);
		pStmt.setInt(1, size);
		pStmt.setInt(2, page);
		ResultSet rs = pStmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			blog_entities[i].article_id = rs.getInt("article_id");
			blog_entities[i].article_title = rs.getString("article_title");
			blog_entities[i].article_author_id = rs.getInt("article_author");
			blog_entities[i].article_sumary = rs.getString("article_sumary");
			blog_entities[i].article_coverimg_hash = rs.getString("article_coverimg");
			blog_entities[i].article_type = rs.getString("article_type");
			blog_entities[i].article_content = rs.getString("article_content");
			blog_entities[i].article_status = rs.getString("article_status");
			blog_entities[i].article_createtime = rs.getTimestamp("article_createtime");
			blog_entities[i].article_author = UserDao.getUserEntity(blog_entities[i].article_author_id);
			blog_entities[i].article_coverimg = ImageDao.getImageEntity(blog_entities[i].article_coverimg_hash);
			i+=1;
		}
		return JSONObject.toJSONString(blog_entities);
	}
}
