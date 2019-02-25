package com.ymksun.taskmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.model.TaskList;
import com.ymksun.taskmgmt.model.dto.TaskListDto;
import com.ymksun.taskmgmt.repository.TaskListRepository;
import com.ymksun.taskmgmt.service.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {
	
	@Autowired
	TaskListRepository taskListRepository;

	private static final String ENTITY_NAME = "TaskList";
	
	@Override
	public List<TaskListDto> getAll() {
		List<TaskList> entityList = taskListRepository.findAll();
		List<TaskListDto> dtoList = new ArrayList<>();
		for(TaskList obj: entityList) {
			dtoList.add(TaskListDto.mapEntityToDto(obj));
		}
		return dtoList;
	}

	@Override
	public TaskListDto save(TaskListDto dto) {
		TaskList obj = taskListRepository.save(TaskListDto.mapDtoToEntity(dto));
		return TaskListDto.mapEntityToDto(obj);
	}

	@Override
	public TaskListDto getById(Long id) {
		TaskList obj = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		return TaskListDto.mapEntityToDto(obj);
	}

	@Override
	public TaskListDto update(Long id, TaskListDto dto) {
		TaskList obj = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		
		obj.setName(dto.getName());
		obj.getBoard().setId(dto.getBoardId());
		
		TaskList updatedObj = taskListRepository.save(obj);
		return TaskListDto.mapEntityToDto(updatedObj);
	}

	@Override
	public TaskListDto delete(Long id) {
		TaskList obj = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		
		obj.setStatus(0);
		
		TaskList updatedObj = taskListRepository.save(obj);
		return TaskListDto.mapEntityToDto(updatedObj);
	}

	@Override
	public void terminate(Long id) {
		TaskList taskList = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		taskListRepository.delete(taskList);
	}

}
