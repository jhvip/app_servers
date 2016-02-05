package com.jh.app_food.entity;

public class MenuDetail {
//	详情号	DETAIL_ID	int		主键唯一自增
//	菜单号	MENU_NO	char	20	时间毫秒唯一
//	菜号	DISH_NO	char	10	外键：根据菜表中的菜号
//	是否做完	MADE	int		默认：0（未做完）非空
//	备注	MARK	char	60	菜品备注
	
	private int detailId;
	private String menuNo;
	private String dishNo;
	private int made;
	private String mark;
	@Override
	public String toString() {
		return "MenuDetail [detailId=" + detailId + ", menuNo=" + menuNo + ", dishNo=" + dishNo + ", made=" + made
				+ ", mark=" + mark + "]";
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getDishNo() {
		return dishNo;
	}
	public void setDishNo(String dishNo) {
		this.dishNo = dishNo;
	}
	public int getMade() {
		return made;
	}
	public void setMade(int made) {
		this.made = made;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	
}
