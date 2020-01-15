package cn.iisjy.main.dao;

import com.alibaba.fastjson.JSONObject;

import cn.iisjy.main.entity.iImage;

public class ImageDao {
	public static String getImage(String hash) {
		iImage img=new iImage();
		return JSONObject.toJSONString(img);

	}
}
