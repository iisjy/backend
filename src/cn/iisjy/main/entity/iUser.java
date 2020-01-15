package cn.iisjy.main.entity;

import java.sql.Timestamp;

public class iUser {
	public int			user_id				=-1;		//用户唯一标识
	public String		user_name			="NULL";	//用户昵称
	public String		user_pswd_hash		="NULL";	//密码哈希值（SHA-512）
	public String		user_pswd_salt		="NULL";	//用户的盐值
	public String		user_login_phone	="NULL";	//登陆用的手机号
	public String		user_login_email	="NULL";	//登陆用的电子邮箱
	public String		user_real_name		="NULL";	//用户真实姓名
	public int			user_certificate	=-1;		//用户证件信息
	public String		user_avatar_hash	="NULL";	//用户头像（哈希）
	public iImage		user_avatar;					//用户头像（实体）
	public String 		user_sex			="X";		//用户性别
	public Timestamp	user_birthdate;					//用户出生日期
//	public Timestamp	user_regtime;					//注册时间
//	public String		user_regIPaddr;					//注册IP地址
//	public String		user_regPort;					//注册端口
	public String		user_login_token_qq="NULL";		//
	public String		user_login_token_wechat="NULL";	//
}
