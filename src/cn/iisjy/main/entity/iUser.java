package cn.iisjy.main.entity;

import java.sql.Timestamp;

public class iUser {
	public int		user_id;
	public String	user_name;
	public String	user_pswd_hash;
	public String	user_pswd_salt;
	public String	user_login_phone;
	public String	user_login_email;
	public String	user_real_name;
	public int		user_certificate;
	public String	user_avatar;
	public char 	user_sex;
	public Timestamp	user_birthdate;
	public Timestamp	user_regtime;
	public String	user_login_token_qq;
	public String	user_login_token_wechat;
	
}
