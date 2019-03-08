package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.dto.UserDto;

public interface UserService {
	
	List<UserDto> getAll();

	UserDto save(UserDto dto);

	UserDto getById(Long id);

	UserDto update(Long id, UserDto dto);

	UserDto delete(Long id);

	void terminate(Long id);
	
	UserDto login(String id, String pwd);

}
