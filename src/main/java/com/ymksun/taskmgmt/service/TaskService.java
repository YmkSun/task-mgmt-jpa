package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.dto.TaskDto;

public interface TaskService {
	
	List<TaskDto> getAll();

	TaskDto save(TaskDto dto);

	TaskDto getById(Long id);

	TaskDto update(Long id, TaskDto dto);

	TaskDto delete(Long id);

	void terminate(Long id);
}
