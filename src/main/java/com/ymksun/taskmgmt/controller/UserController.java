package com.ymksun.taskmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymksun.taskmgmt.model.dto.UserDto;
import com.ymksun.taskmgmt.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/list")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") Long userId) {
		return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody UserDto userDetails) {
		return new ResponseEntity<>(userService.update(userId, userDetails), HttpStatus.OK);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStatusUser(@PathVariable(value = "id") Long userId) {
		UserDto user = userService.delete(userId);
		return new ResponseEntity<>(user != null ? true : false, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
		userService.terminate(userId);
		return ResponseEntity.ok().build();
	}

}
