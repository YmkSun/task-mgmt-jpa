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

import com.ymksun.taskmgmt.model.dto.TaskDto;
import com.ymksun.taskmgmt.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/list")
	public ResponseEntity<List<TaskDto>> getAllTasks() {
		return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto task) {
		return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable(value = "id") Long taskId) {
		return new ResponseEntity<>(taskService.getById(taskId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TaskDto> updateTask(@PathVariable(value = "id") Long taskId,
			@Valid @RequestBody TaskDto taskDetails) {
		return new ResponseEntity<>(taskService.update(taskId, taskDetails), HttpStatus.OK);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStatusTask(@PathVariable(value = "id") Long taskId) {
		TaskDto task = taskService.delete(taskId);
		return new ResponseEntity<>(task != null ? true : false, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) {
		taskService.terminate(taskId);
		return ResponseEntity.ok().build();
	}
}
