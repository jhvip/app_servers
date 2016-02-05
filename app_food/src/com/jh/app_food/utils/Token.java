package com.jh.app_food.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class Token {
	public String getToken() {
		String s=UUID.randomUUID().toString();
		String token=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
		return token;
	}
	public int verifyToken(String token) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=JdbcUtils.getConnection();
		String sql="select guest_id from guest where token=?";
		int guest_id = 0;
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				guest_id=rs.getInt(1);				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error 查找失败");
		}finally{
			JdbcUtils.close(rs, pstm, conn);
		}
		return guest_id;
	}
}
