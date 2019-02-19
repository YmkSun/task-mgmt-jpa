package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.Task;

public interface TaskService {
	
	List<Task> getAll();

	Task save(Task task);

	Task getById(Long id);

	Task update(Long id, Task task);

	Task delete(Long id);

	void terminate(Long id);
}
