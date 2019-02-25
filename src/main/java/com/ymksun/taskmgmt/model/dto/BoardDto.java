package com.ymksun.taskmgmt.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.ymksun.taskmgmt.model.Board;
import com.ymksun.taskmgmt.model.TaskList;

public class BoardDto {

	private long id;
	private String name;
	private String description;
	private int type;
	private int status;
	private Set<TaskList> taskLists;

	public BoardDto() {
		setProperties();
	}

	public BoardDto(Long id, String name, String description, Integer type, Integer status, Set<TaskList> taskLists) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.status = status;
		this.taskLists = taskLists;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<TaskList> getTaskLists() {
		return taskLists;
	}

	public void setTaskLists(Set<TaskList> taskLists) {
		this.taskLists = (taskLists != null) ? taskLists : new HashSet<>();
	}

	public void setProperties() {
		this.id = 0l;
		this.name = "";
		this.description = "";
		this.type = 0;
		this.status = 0;
		this.taskLists = new HashSet<>();
	}

	public static BoardDto mapEntityToDto(Board obj) {
		BoardDto dto = new BoardDto();
		dto.id = obj.getId();
		dto.name = obj.getName();
		dto.description = obj.getDescription();
		dto.type = obj.getType();
		dto.status = obj.getStatus();
		dto.taskLists = obj.getTaskLists();
		return dto;
	}

	public static Board mapDtoToEntity(BoardDto dto) {
		Board obj = new Board();
		obj.setId(dto.id);
		obj.setName(dto.name);
		obj.setDescription(dto.description);
		obj.setType(dto.type);
		obj.setStatus(dto.status);
		return obj;
	}

}
