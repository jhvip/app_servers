package com.jh.app_food.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jh.app_food.dao.DishMenuDao;
import com.jh.app_food.entity.DishMenu;
import com.jh.app_food.utils.JdbcUtils;

public class DishMenuDaoImpl implements DishMenuDao {

	@Override
	public boolean insertDish(DishMenu dishMenu,JSONArray menuInfo) {
//		菜单ID	menu_id	int		主键唯一自增
//		菜单号	menu_no	char	20	时间毫秒唯一
//		客人ID	guest_id	int		主键唯一自增
//		桌号		table_no	char	10	外键：根据桌子表中的桌号
//		房间号	room_no	char	10	外键：根据房间表中的房号
//		点菜时间	menuTime	date		提交菜单的时间
//		是否上菜	served	int		默认：0（未上）非空
		
		String sql = "insert into dish(menu_no, guest_id, table_no, room_no, menuTime,served) "
				+ "values(?,?,?,?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dishMenu.getMenu_no());
			preparedStatement.setInt(2, dishMenu.getGuest_id());
			preparedStatement.setString(3, dishMenu.getTable_no());
			preparedStatement.setString(4, dishMenu.getRoom_no());
			preparedStatement.setString(5, dishMenu.getMenu_no());
			preparedStatement.setInt(6, dishMenu.getServed());
			if (createMenuInfo(dishMenu.getMenu_no(),menuInfo)) {
				preparedStatement.executeUpdate();
			}else {
				System.out.println("菜单细节插入失败");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error 插入订单失败");
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}
	
		return true;
	}

	@Override
	public int changeServed() {
		// TODO Auto-generated method stub
		return 0;
	}
	//插入菜单详情
	private boolean createMenuInfo(String menuNo,JSONArray menuInfo){
		String sql = "insert into menu_detail(menu_no, dish_no, mark) "
				+ "values(?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("关闭事务操作失败");
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < menuInfo.length(); i++) {
				JSONObject jsonObject=menuInfo.getJSONObject(i);
				preparedStatement.setString(1, menuNo);
				preparedStatement.setString(2, jsonObject.getString("dish_no"));
				preparedStatement.setString(3, jsonObject.getString("mark"));
				preparedStatement.addBatch();
			}
			
			preparedStatement.executeBatch();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error 插入菜单详情失败");
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}
	
		return true;
	}

}
