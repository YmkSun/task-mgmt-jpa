package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.TaskList;

public interface TaskListService {
	
	List<TaskList> getAll();

	TaskList save(TaskList TaskList);

	TaskList getById(Long id);

	TaskList update(Long id, TaskList TaskList);

	TaskList delete(Long id);

	void terminate(Long id);
}
