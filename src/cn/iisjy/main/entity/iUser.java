package cn.iisjy.main.entity;

import java.sql.Timestamp;

public class iUser {
	public int			user_id;					//用户唯一标识
	public String		user_name;					//用户昵称
	public String		user_pswd_hash;				//密码哈希值（SHA-512）
	public String		user_pswd_salt;				//用户的盐值
	public String		user_login_phone;			//登陆用的手机号
	public String		user_login_email;			//登陆用的电子邮箱
	public String		user_real_name;				//用户真实姓名
	public int			user_certificate;			//用户证件信息
	public String		user_avatar;				//用户头像（哈希）
	public char 		user_sex;					//用户性别
	public Timestamp	user_birthdate;				//用户出生日期
	public Timestamp	user_regtime;				//注册时间
	public String		user_regIPaddr;				//注册IP地址
	public String		user_regPort;				//注册IP地址
	public String		user_login_token_qq;
	public String		user_login_token_wechat;
	
}
