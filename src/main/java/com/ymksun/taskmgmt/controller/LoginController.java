package com.ymksun.taskmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymksun.taskmgmt.model.dto.UserDto;
import com.ymksun.taskmgmt.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public ResponseEntity<UserDto> login(@PathVariable(value = "id") String userId,
			@PathVariable(value = "pwd") String password) {
		return new ResponseEntity<>(userService.login(userId, password), HttpStatus.OK);
	}

}
