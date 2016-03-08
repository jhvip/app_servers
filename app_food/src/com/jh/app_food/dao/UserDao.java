package com.jh.app_food.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jh.app_food.entity.User;

public interface UserDao {
	//用户登陆
	public JSONObject userLogin(String userName,String pw);
	
	//用户注册
	public boolean userRegist(User user);
	
	//验证token是否正确
	public boolean testToken(String userName,String token);
	
	
}
