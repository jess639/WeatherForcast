package com.example.weather.biz;

import org.litepal.crud.DataSupport;

public class LoginUser extends DataSupport{
	private String username;
	private String password;
	private boolean isremember;
	
	
	public boolean isIsremember() {
		return isremember;
	}
	public void setIsremember(boolean isremember) {
		this.isremember = isremember;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
