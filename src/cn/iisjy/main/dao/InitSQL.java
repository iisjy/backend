package cn.iisjy.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitSQL {
	
	public static Connection getConnection() throws Exception {
		Connection c = null;
		Class.forName("org.postgresql.Driver"); // 加载JDBC驱动
//		String user = "postgres";
//		String host = "pg.iisjy.cn";
//		String port = "5432";
//		String pswd = "JingYang1999";
//		String dtbs = "iisjy";
//		c = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + dtbs, user, pswd);
		c = DriverManager.getConnection("jdbc:postgresql://pg.iisjy.cn:5432/iisjy", "postgres", "JingYang1999");
		return c;
	}
}
