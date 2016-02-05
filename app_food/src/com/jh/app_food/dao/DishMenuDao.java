package com.jh.app_food.dao;

import org.json.JSONArray;

import com.jh.app_food.entity.DishMenu;

public interface DishMenuDao {
	public boolean insertDish(DishMenu dishMenu,JSONArray menuInfo);
	
	public int changeServed();
}
