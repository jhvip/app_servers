package com.jh.app_food.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jh.app_food.dao.DishDetailDao;
import com.jh.app_food.utils.JdbcUtils;

public class DishDetailImpl implements DishDetailDao {

	public JSONObject dishDetail(String dish_no) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=JdbcUtils.getConnection();
		String sql="select dish_name,dish_pic,dish_detail,dish_tag,dish.dish_no from dish left join dish_detail on dish.dish_no=dish_detail.dish_no where dish.dish_no=?";
		JSONObject jsonObject =new JSONObject();
		
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, dish_no);
			
			rs=pstm.executeQuery();
			while(rs.next()){
				
				String dish_name=rs.getString(1);
				String dish_pic=rs.getString(2);
				String dish_detail=rs.getString(3);
				String dish_tag=rs.getString(4);
				
				jsonObject.put("dish_no", rs.getString(5));
				jsonObject.put("dish_name", dish_name);
				jsonObject.put("dish_pic",dish_pic );
				jsonObject.put("dish_detail",dish_detail );
				jsonObject.put("dish_tag", dish_tag);
				
				System.out.println(jsonObject.toString());
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error 菜单详情查找失败");
		}finally{
			JdbcUtils.close(rs, pstm, conn);
		}
		System.out.println(jsonObject.toString());
		return jsonObject;

	}

	
}
