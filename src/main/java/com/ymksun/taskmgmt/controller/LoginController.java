package com.ymksun.taskmgmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymksun.taskmgmt.model.dto.LoginUserDto;
import com.ymksun.taskmgmt.model.dto.UserDto;
import com.ymksun.taskmgmt.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("")
	public ResponseEntity<UserDto> login(@RequestParam(value = "id") String userId,
			@RequestParam(value = "pwd") String password) {
		return new ResponseEntity<>(userService.login(userId, password), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody LoginUserDto user) {
		return new ResponseEntity<>(userService.login(user.getId(), user.getPassword()), HttpStatus.OK);
	}

}
