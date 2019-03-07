package com.ymksun.taskmgmt.model.dto;

import com.ymksun.taskmgmt.model.User;

public class UserDto {
	
	private long id;
	private String userId;
	private String password;
	private String userName;
	private String phoneNo;
	private String mail;
	private int status;
	
	public UserDto() {
		setDefaultProperties();
	}
	
	public UserDto(long id, String userId, String password, String userName, String phoneNo, String mail,
			Integer status) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.mail = mail;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setDefaultProperties() {
		this.id = 0l;
		this.userId = "";
		this.password = "";
		this.userName = "";
		this.phoneNo = "";
		this.mail = "";
		this.status = 0;
	}
	
	public static UserDto mapEntityToDto(User obj) {
		UserDto dto = new UserDto();
		dto.setId(obj.getId());
		dto.setUserId(obj.getUserId());
		dto.setPassword(obj.getPassword());
		dto.setUserName(obj.getUserName());
		dto.setPhoneNo(obj.getPhoneNo());
		dto.setMail(obj.getMail());
		dto.setStatus(obj.getStatus());
		return dto;
	}
	
	public static User mapDtoToEntity(UserDto dto) {
		User obj = new User();
		obj.setId(dto.getId());
		obj.setUserId(dto.getUserId());
		obj.setPassword(dto.getPassword());
		obj.setUserName(dto.getUserName());
		obj.setPhoneNo(dto.getPhoneNo());
		obj.setMail(dto.getMail());
		obj.setStatus(dto.getStatus());
		return obj;
	}
}
