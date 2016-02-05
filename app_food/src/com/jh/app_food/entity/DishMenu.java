package com.jh.app_food.entity;

public class DishMenu {
//	菜单ID	menu_id	int		主键唯一自增
//	菜单号	menu_no	char	20	时间毫秒唯一
//	客人ID	guest_id	int		主键唯一自增
//	桌号		table_no	char	10	外键：根据桌子表中的桌号
//	房间号	room_no	char	10	外键：根据房间表中的房号
//	点菜时间	menuTime	date		提交菜单的时间
//	是否上菜	served	int		默认：0（未上）非空
	private String menu_no;
	private int guest_id;
	private String table_no;
	private String room_no;
	private String menuTime;
	private int served;
	@Override
	public String toString() {
		return "Dish_menu [menu_no=" + menu_no + ", guest_id=" + guest_id + ", table_no=" + table_no + ", room_no="
				+ room_no + ", menuTime=" + menuTime + ", served=" + served + "]";
	}
	public String getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}
	public int getGuest_id() {
		return guest_id;
	}
	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}
	public String getTable_no() {
		return table_no;
	}
	public void setTable_no(String table_no) {
		this.table_no = table_no;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getMenuTime() {
		return menuTime;
	}
	public void setMenuTime(String menuTime) {
		this.menuTime = menuTime;
	}
	public int getServed() {
		return served;
	}
	public void setServed(int served) {
		this.served = served;
	}
	
	
					
}
