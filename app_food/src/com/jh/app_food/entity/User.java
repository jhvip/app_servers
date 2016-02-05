package com.jh.app_food.entity;

public class User {
	
	/*1	GUEST_ID	int	11	0	0			1	0	0
0	GUEST_NAME	varchar	20	0	1					0
0	GUEST_PW	varchar	20	0	1					0
0	GUEST_TIME	datetime	0	0	1			0 
	 */
	
	private String guest_name;
	private String guest_pw;
	private String guest_time;
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public String getGuest_pw() {
		return guest_pw;
	}
	public void setGuest_pw(String guest_pw) {
		this.guest_pw = guest_pw;
	}
	public String getGuest_time() {
		return guest_time;
	}
	public void setGuest_time(String guest_time) {
		this.guest_time = guest_time;
	}
	@Override
	public String toString() {
		return "User [guest_name=" + guest_name + ", guest_pw=" + guest_pw + ", guest_time=" + guest_time + "]";
	}
	
	
	
}
