package com.ymksun.taskmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.exception.ResourceCannotBeSavedException;
import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.exception.ResourceCannotBeSavedException.RESOURCE_CANNOT_BE_CREATED_REASON;
import com.ymksun.taskmgmt.model.Task;
import com.ymksun.taskmgmt.model.dto.TaskDto;
import com.ymksun.taskmgmt.repository.TaskRepository;
import com.ymksun.taskmgmt.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	private static final String ENTITY_NAME = "Task";

	@Override
	public List<TaskDto> getAll() {
		List<Task> entityList = taskRepository.findAll();
		List<TaskDto> dtoList = new ArrayList<>();
		for(Task obj: entityList) {
			dtoList.add(TaskDto.mapEntityToDto(obj));
		}
		return dtoList;
	}

	@Override
	public TaskDto save(TaskDto dto) {
		if(dto.getName().isEmpty()) {
			throw new ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON.NAME_VALUE_NULL_STAGE, ENTITY_NAME);
		}
		
		Task obj = taskRepository.save(TaskDto.mapDtoToEntity(dto));
		return TaskDto.mapEntityToDto(obj);
	}

	@Override
	public TaskDto getById(Long id) {
		Task obj = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		return TaskDto.mapEntityToDto(obj);
	}

	@Override
	public TaskDto update(Long id, TaskDto dto) {
		if(dto.getName().isEmpty()) {
			throw new ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON.NAME_VALUE_NULL_STAGE, ENTITY_NAME);
		}
		
		Task obj = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		
		obj.setName(dto.getName());
		obj.setContent(dto.getContent());
		
		Task updatedObj = taskRepository.save(obj);
		return TaskDto.mapEntityToDto(updatedObj);
	}

	@Override
	public TaskDto delete(Long id) {
		Task obj = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		
		obj.setStatus(0);
		
		Task updatedObj = taskRepository.save(obj);
		return TaskDto.mapEntityToDto(updatedObj);
	}

	@Override
	public void terminate(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		taskRepository.delete(task);
	}

}
