package com.jh.app_food.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jh.app_food.dao.UserDao;
import com.jh.app_food.entity.User;
import com.jh.app_food.utils.JdbcUtils;
import com.jh.app_food.utils.Token;

public class UserDaoImpl implements UserDao {

	@Override
	public JSONObject userLogin(String userName, String pw) {
		// TODO Auto-generated method stub
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=JdbcUtils.getConnection();
		String sql="select  guest_name,token from guest where guest_name=? and guest_pw=?";

		JSONObject jsonObject=new JSONObject();
		jsonObject.put("userName", userName);
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, pw);
			rs=pstm.executeQuery();
			rs.last();
			if (rs.getRow()==0) {
				jsonObject.put("error", "1002");
				System.out.println("error 账号密码错误");
			}
			rs.beforeFirst();
			while(rs.next()){
				Token tokenInfo=new Token();
				String token=tokenInfo.getToken();
				updateToken(userName, token);
				System.out.println("token+"+token);
				jsonObject.put("token", token);
				jsonObject.put("error", "1000");						
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
						
			jsonObject.put("error", "1001");

			System.out.println("error 异常错误");
		}finally{
			JdbcUtils.close(rs, pstm, conn);
		}
		
		return jsonObject;
	
	}

	
	@Override
	public boolean userRegist(User user) {
		// TODO Auto-generated method stub
		
		String sql = "insert into guest(guest_name, guest_pw, guest_time,token) "
				+ "values(?,?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getGuest_name());
			preparedStatement.setString(2, user.getGuest_pw());
			preparedStatement.setString(3, user.getGuest_time());
			preparedStatement.setString(4, user.getToken());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}	
		return true;
	}
	
	public void updateToken(String userName,String token){
		String sql = "update guest set token = ? "
				+"where guest_name= ?";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, token);
			
			preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("error 更新token失败");
			} finally {
				JdbcUtils.close(null, preparedStatement, connection);
			}	
	}

	

}
