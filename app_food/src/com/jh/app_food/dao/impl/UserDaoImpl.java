package com.jh.app_food.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jh.app_food.dao.UserDao;
import com.jh.app_food.entity.User;
import com.jh.app_food.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean userLogin(String userName, String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean userRegist(User user) {
		// TODO Auto-generated method stub
		
		String sql = "insert into guest(guest_name, guest_pw, guest_time) "
				+ "values(?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getGuest_name());
			preparedStatement.setString(2, user.getGuest_pw());
			preparedStatement.setString(3, user.getGuest_time());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}	
		return true;
	}

	

}
