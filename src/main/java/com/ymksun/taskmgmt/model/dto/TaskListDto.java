package com.ymksun.taskmgmt.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.ymksun.taskmgmt.model.Task;
import com.ymksun.taskmgmt.model.TaskList;

public class TaskListDto {
	
	private long id;
	private String name;
	private int status;
	private long boardId;
	private Set<Task> tasks;
	
	public TaskListDto() {
		setDefaultProperties();
	}
	
	public TaskListDto(long id) {
		this.id = id;
	}

	public TaskListDto(long id, String name, int status, long boardId, Set<Task> tasks) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.boardId = boardId;
		this.tasks = tasks;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public void setDefaultProperties() {
		this.id = 0l;
		this.name = "";
		this.status = 0;
		this.boardId = 0l;
		this.tasks = new HashSet<>();
	}
	
	public static TaskListDto mapEntityToDto(TaskList obj) {
		TaskListDto dto = new TaskListDto();
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		dto.setStatus(obj.getStatus());
		dto.setTasks(obj.getTasks());
		dto.setBoardId(obj.getBoard().getId());
		return dto;
	}
	
	public static TaskList mapDtoToEntity(TaskListDto dto) {
		TaskList obj = new TaskList();
		obj.setId(dto.getId());
		obj.setName(dto.getName());
		obj.setStatus(dto.getStatus());
		obj.setBoard(BoardDto.mapDtoToEntity(new BoardDto(dto.getBoardId())));
		return obj;
	}
}
