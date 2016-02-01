package com.jh.app_food.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;

import com.jh.app_food.dao.DishDao;
import com.jh.app_food.entity.Dish;
import com.jh.app_food.utils.JdbcUtils;

public class DishDaoImpl implements DishDao {

	@Override
	public boolean insertDish(Dish dish) {
		// TODO Auto-generated method stub
		String sql = "insert into dish(dish_no, dish_name, dish_price, dish_class, dish_discount) "
				+ "values(?,?,?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dish.getDish_no());
			preparedStatement.setString(2, dish.getDish_name());
			preparedStatement.setDouble(3, dish.getDish_price());
			preparedStatement.setInt(4, dish.getDish_class());
			preparedStatement.setDouble(5, dish.getDish_discount());
		
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}
		
		
		return false;
	}

	@Override
	public boolean deleteDish(String dish_no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeDish(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONArray findDish() {
		// TODO Auto-generated method stub
		return null;
	}

}
