package com.jh.app_food.dao;

import com.jh.app_food.entity.User;

public interface UserDao {
	//用户登陆
	public boolean userLogin(String userName,String pw);
	
	//用户注册
	public boolean userRegist(User user);
	
	
	
	
	
}
