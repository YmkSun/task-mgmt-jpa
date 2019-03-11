package com.ymksun.taskmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.TaskMgmtApplication;
import com.ymksun.taskmgmt.exception.ResourceCannotBeSavedException;
import com.ymksun.taskmgmt.exception.ResourceCannotBeSavedException.RESOURCE_CANNOT_BE_CREATED_REASON;
import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.model.User;
import com.ymksun.taskmgmt.model.dto.UserDto;
import com.ymksun.taskmgmt.repository.UserRepository;
import com.ymksun.taskmgmt.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	private static final String ENTITY_NAME = "User";

	@Override
	public List<UserDto> getAll() {
		List<User> entityList = userRepository.findAll();
		List<UserDto> dtoList = new ArrayList<>();
		for(User obj: entityList) {
			dtoList.add(UserDto.mapEntityToDto(obj));
		}
		return dtoList;
	}

	@Override
	public UserDto save(UserDto dto) {
		if(dto.getUserId().isEmpty()) {
			throw new ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON.NAME_VALUE_NULL_STAGE, ENTITY_NAME);
		}
		
		User obj = userRepository.save(UserDto.mapDtoToEntity(dto));
		
		if(obj!=null) 
			TaskMgmtApplication.logResult(ENTITY_NAME + " saved!", "INFO");
		
		return UserDto.mapEntityToDto(obj);
	}

	@Override
	public UserDto getById(Long id) {
		User obj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		return UserDto.mapEntityToDto(obj);
	}

	@Override
	public UserDto update(Long id, UserDto dto) {
		if(dto.getUserId().isEmpty()) {
			throw new ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON.NAME_VALUE_NULL_STAGE, ENTITY_NAME);
		}
		
		User obj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		
		obj.setUserId(dto.getUserId());
		obj.setUserName(dto.getUserName());
		obj.setPassword(dto.getPassword());
		obj.setPhoneNo(dto.getPhoneNo());
		obj.setMail(dto.getMail());
		
		User updatedObj = userRepository.save(obj);
		
		if(obj!=null) 
			TaskMgmtApplication.logResult(ENTITY_NAME + " updated!", "INFO");
		
		return UserDto.mapEntityToDto(updatedObj);
	}

	@Override
	public UserDto delete(Long id) {
		User obj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		
		obj.setStatus(0);
		
		User updatedObj = userRepository.save(obj);
		
		if(obj!=null) 
			TaskMgmtApplication.logResult(ENTITY_NAME + " deleted!", "INFO");
		
		return UserDto.mapEntityToDto(updatedObj);
	}

	@Override
	public void terminate(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		userRepository.delete(user);
	}

	@Override
	public UserDto login(String id, String pwd) {
		User user = userRepository.login(id, pwd);
		return UserDto.mapEntityToDto(user);
	}

}
