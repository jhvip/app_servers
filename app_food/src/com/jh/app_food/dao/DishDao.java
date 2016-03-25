package com.jh.app_food.dao;

import org.json.JSONArray;

import com.jh.app_food.entity.Dish;

public interface DishDao {
	public boolean insertDish(Dish dish);
	
	public boolean deleteDish(String dish_no);
	
	public boolean changeDish(Dish dish);
	
	public JSONArray findDish(String dish_class);
	
	public JSONArray findComment(String dish_no);
	
}
