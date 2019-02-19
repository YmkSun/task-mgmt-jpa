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

import com.ymksun.taskmgmt.model.TaskList;
import com.ymksun.taskmgmt.service.TaskListService;

@RestController
@RequestMapping("/api/schedule")
public class TaskListController {

	@Autowired
	TaskListService taskListService;

	@GetMapping("/list")
	public ResponseEntity<List<TaskList>> getAllTaskLists() {
		return new ResponseEntity<>(taskListService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<TaskList> createTaskList(@Valid @RequestBody TaskList taskList) {
		return new ResponseEntity<>(taskListService.save(taskList), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TaskList> getTaskListById(@PathVariable(value = "id") Long taskListId) {
		return new ResponseEntity<>(taskListService.getById(taskListId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TaskList> updateTaskList(@PathVariable(value = "id") Long taskListId,
			@Valid @RequestBody TaskList taskListDetails) {
		return new ResponseEntity<>(taskListService.update(taskListId, taskListDetails), HttpStatus.OK);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStatusTaskList(@PathVariable(value = "id") Long taskListId) {
		TaskList taskList = taskListService.delete(taskListId);
		return new ResponseEntity<>(taskList != null ? true : false, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteTaskList(@PathVariable(value = "id") Long taskListId) {
		taskListService.terminate(taskListId);
		return ResponseEntity.ok().build();
	}
}
