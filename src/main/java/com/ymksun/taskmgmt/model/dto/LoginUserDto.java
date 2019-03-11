package com.ymksun.taskmgmt.model.dto;

public class LoginUserDto {
	
	private final String id;
	private final String password;
	
	public LoginUserDto() {
		this.id = "";
		this.password = "";
	}

	public LoginUserDto(final String id, final String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	

}
