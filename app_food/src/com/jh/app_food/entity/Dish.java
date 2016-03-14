package com.jh.app_food.entity;

public class Dish {
	/*
0	dish_no	varchar	20	0	1					0
0	dish_name	varchar	20	0	1					0
0	dish_price	float	0	0	1			0	0
0	dish_class	int	11	0	1			0	0	0
0	dish_discount	float	0	0	1			0	0
	 * 
	 */
	private String dish_no;
	private String dish_name;
	private double dish_price;
	public String getDish_pic() {
		return dish_pic;
	}
	public void setDish_pic(String dish_pic) {
		this.dish_pic = dish_pic;
	}
	private int dish_class;
	private double dish_discount;
	private String dish_pic;
	@Override
	public String toString() {
		return "Dish [dish_no=" + dish_no + ", dish_name=" + dish_name + ", dish_price=" + dish_price + ", dish_class="
				+ dish_class + ", dish_discount=" + dish_discount + "]";
	}
	public String getDish_no() {
		return dish_no;
	}
	public void setDish_no(String dish_no) {
		this.dish_no = dish_no;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public double getDish_price() {
		return dish_price;
	}
	public void setDish_price(double dish_price) {
		this.dish_price = dish_price;
	}
	public int getDish_class() {
		return dish_class;
	}
	public void setDish_class(int dish_class) {
		this.dish_class = dish_class;
	}
	public double getDish_discount() {
		return dish_discount;
	}
	public void setDish_discount(double dish_discount) {
		this.dish_discount = dish_discount;
	}
	

}
