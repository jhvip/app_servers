package com.jh.app_food.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
	private static String url = "jdbc:mysql://127.0.0.1:3306/JH_SYS";
	private static String user = "root";
	private static String password = "jhJH123!";
	private static String driver = "com.mysql.jdbc.Driver";
	
	/*
	private static String url = "jdbc:mysql://qdm162607130.my3w.com:3306/qdm162607130_db";
	private static String user = "qdm162607130";
	private static String password = "jianghao";
	private static String driver = "com.mysql.jdbc.Driver";
	*/
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(ResultSet rs, PreparedStatement pst,
			Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pst != null) {
					try {
						pst.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (Exception e3) {
								e3.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
