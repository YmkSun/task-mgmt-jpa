package com.ymksun.taskmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.model.Task;
import com.ymksun.taskmgmt.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> getAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task save(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task getById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
	}

	@Override
	public Task update(Long id, Task taskDetail) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
		
		task.setName(taskDetail.getName());
		task.setContent(taskDetail.getContent());
		
		Task updatedTask = taskRepository.save(task);
		return updatedTask;
	}

	@Override
	public Task delete(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
		
		task.setStatus(0);
		
		Task updatedTask = taskRepository.save(task);
		return updatedTask;
	}

	@Override
	public void terminate(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
		taskRepository.delete(task);
	}

}
