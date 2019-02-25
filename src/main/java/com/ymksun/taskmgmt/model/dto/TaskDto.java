package com.ymksun.taskmgmt.model.dto;

import com.ymksun.taskmgmt.model.Task;

public class TaskDto {

	private long id;
	private String name;
	private String content;
	private int status;
	private long taskListId;
	
	public TaskDto() {
		setDefaultProperties();
	}
	
	public TaskDto(long id, String name, String content, int status, long taskListId) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.status = status;
		this.taskListId = taskListId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTaskListId() {
		return taskListId;
	}

	public void setTaskListId(long taskListId) {
		this.taskListId = taskListId;
	}
	
	public void setDefaultProperties() {
		this.id = 0l;
		this.name = "";
		this.content = "";
		this.status = 0;
		this.taskListId = 0l;
	}
	
	public static TaskDto mapEntityToDto(Task obj) {
		TaskDto dto = new TaskDto();
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		dto.setContent(obj.getContent());
		dto.setStatus(obj.getStatus());
		dto.setTaskListId(obj.getTaskList().getId());
		return dto;
	}
	
	public static Task mapDtoToEntity(TaskDto dto) {
		Task obj = new Task();
		obj.setId(dto.getId());
		obj.setName(dto.getName());
		obj.setContent(dto.getContent());
		obj.setStatus(dto.getStatus());
		obj.setTaskList(TaskListDto.mapDtoToEntity(new TaskListDto(dto.getTaskListId())));
		return obj;
	}
}
