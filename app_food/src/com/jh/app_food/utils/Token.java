package com.jh.app_food.utils;

import java.util.UUID;

public class Token {
	public String getToken() {
		String s=UUID.randomUUID().toString();
		String token=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
		return token;
	}
}
