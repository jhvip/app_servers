package com.jh.app_food.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jh.app_food.dao.DishDao;
import com.jh.app_food.entity.Dish;
import com.jh.app_food.utils.JdbcUtils;
import com.sun.org.apache.regexp.internal.recompile;

public class DishDaoImpl implements DishDao {

	@Override
	public boolean insertDish(Dish dish) {
		// TODO Auto-generated method stub
		String sql = "insert into dish(dish_no, dish_name, dish_price, dish_class, dish_discount,dish_pic) "
				+ "values(?,?,?,?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dish.getDish_no());
			preparedStatement.setString(2, dish.getDish_name());
			preparedStatement.setDouble(3, dish.getDish_price());
			preparedStatement.setInt(4, dish.getDish_class());
			preparedStatement.setDouble(5, dish.getDish_discount());
			preparedStatement.setString(6, dish.getDish_pic());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error 插入失败");
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}
	
		return true;
	}

	@Override
	public boolean deleteDish(String dish_no) {
		String sql = "delete from dish where dish_no=?";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dish_no);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error 删除失败");
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}
		return true;
	}

	@Override
	public boolean changeDish(Dish dish) {
		// TODO Auto-generated method stub
		String sql = "update dish set dish_name = ? ,dish_price = ?,dish_class= ?,dish_discount= ? "
				+"where dish_no= ?";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(5, dish.getDish_no());
			preparedStatement.setString(1, dish.getDish_name());
			preparedStatement.setDouble(2, dish.getDish_price());
			preparedStatement.setInt(3, dish.getDish_class());
			preparedStatement.setDouble(4, dish.getDish_discount());
				
			preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("error 更改失败");
				return false;
			} finally {
				JdbcUtils.close(null, preparedStatement, connection);
			}
			
			return true;		
	}

	@Override
	public JSONArray findDish(String dish_class) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=JdbcUtils.getConnection();
		String sql="select  dish_no,dish_name,dish_price,dish_class,dish_discount,dish_pic from dish where dish_class=?";
		JSONArray jsonArray =new JSONArray();
		
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, dish_class);
			rs=pstm.executeQuery();
			while(rs.next()){
				String dish_no=rs.getString(1);
				String dish_name=rs.getString(2);
				String dish_price=rs.getString(3);
				//String dish_class=rs.getString(4);
				String dish_discount=rs.getString(5);
				String dish_pic=rs.getString(6);
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("dish_no", dish_no);
				jsonObject.put("dish_name", dish_name);
				jsonObject.put("dish_price",dish_price );
				jsonObject.put("dish_class", dish_class);
				jsonObject.put("dish_discount",dish_discount );
				jsonObject.put("dish_pic", dish_pic);
				jsonArray.put(jsonObject);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error 查找失败");
		}finally{
			JdbcUtils.close(rs, pstm, conn);
		}
		
		return jsonArray;
	
	}

}
