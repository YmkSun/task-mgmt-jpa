package com.ymksun.taskmgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.model.TaskList;
import com.ymksun.taskmgmt.repository.TaskListRepository;
import com.ymksun.taskmgmt.service.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {
	
	@Autowired
	TaskListRepository taskListRepository;

	@Override
	public List<TaskList> getAll() {
		return taskListRepository.findAll();
	}

	@Override
	public TaskList save(TaskList taskList) {
		return taskListRepository.save(taskList);
	}

	@Override
	public TaskList getById(Long id) {
		return taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskList", "id", id));
	}

	@Override
	public TaskList update(Long id, TaskList taskListDetail) {
		TaskList taskList = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskList", "id", id));
		
		taskList.setName(taskListDetail.getName());
		
		TaskList updatedTaskList = taskListRepository.save(taskList);
		return updatedTaskList;
	}

	@Override
	public TaskList delete(Long id) {
		TaskList taskList = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskList", "id", id));
		
		taskList.setStatus(0);
		
		TaskList updatedTaskList = taskListRepository.save(taskList);
		return updatedTaskList;
	}

	@Override
	public void terminate(Long id) {
		TaskList taskList = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskList", "id", id));
		taskListRepository.delete(taskList);
	}

}
