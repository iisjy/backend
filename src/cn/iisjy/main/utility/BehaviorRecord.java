package cn.iisjy.main.utility;

public class BehaviorRecord {
	public static void regRecord() {		//永久保留
		//用户唯一标识
		//用户名称
		//注册时间
		//IP地址、端口
		//设备（web:浏览器UA；app:设备识别码）
	}
	public static void loginRecord() {		//保存12个月
		//用户唯一标识
		//登陆时间
		//登陆方式（用户名、手机号、QQ授权、微信授权）
		//IP地址、端口
		//设备（web:浏览器UA；app:设备识别码）
	}
	public static void publishRecord() {	//保存6个月
		//用户唯一标识
		//信息表示
		//发布时间
		//IP地址、端口
		//信息摘要
		//设备（web:浏览器UA；app:设备识别码）
	}
	public static void replyRecord() {		//保存6个月
		
	}
}
