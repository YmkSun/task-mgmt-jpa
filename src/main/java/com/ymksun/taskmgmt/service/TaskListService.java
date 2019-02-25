package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.dto.TaskListDto;

public interface TaskListService {
	
	List<TaskListDto> getAll();

	TaskListDto save(TaskListDto dto);

	TaskListDto getById(Long id);

	TaskListDto update(Long id, TaskListDto dto);

	TaskListDto delete(Long id);

	void terminate(Long id);
}
