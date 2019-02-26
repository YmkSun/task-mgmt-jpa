package com.ymksun.taskmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.exception.ResourceCannotBeSavedException;
import com.ymksun.taskmgmt.exception.ResourceCannotBeSavedException.RESOURCE_CANNOT_BE_CREATED_REASON;
import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.model.Board;
import com.ymksun.taskmgmt.model.dto.BoardDto;
import com.ymksun.taskmgmt.repository.BoardRepository;
import com.ymksun.taskmgmt.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	private static final String ENTITY_NAME = "Board";

	@Override
	public List<BoardDto> getAll() {
		List<Board> entityList = boardRepository.findAll();
		List<BoardDto> dtoList = new ArrayList<>();
		for(Board obj: entityList) {
			dtoList.add(BoardDto.mapEntityToDto(obj));
		}
		return dtoList;
	}

	@Override
	public BoardDto save(BoardDto dto) {
		if(dto.getName().isEmpty()) {
			new ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON.NAME_VALUE_NULL_STAGE, ENTITY_NAME);
		}
		
		Board obj = boardRepository.save(BoardDto.mapDtoToEntity(dto));		
		return BoardDto.mapEntityToDto(obj);
	}

	@Override
	public BoardDto getById(Long id) {
		Board obj = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		return BoardDto.mapEntityToDto(obj);
	}

	@Override
	public BoardDto update(Long id, BoardDto dto) {
		if(dto.getName().isEmpty()) {
			new ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON.NAME_VALUE_NULL_STAGE, ENTITY_NAME);
		}
		
		Board obj = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));

		obj.setName(dto.getName());
		obj.setDescription(dto.getDescription());
		obj.setStatus(dto.getStatus());
		obj.setType(dto.getType());

		Board updatedObj = boardRepository.save(obj);
		return BoardDto.mapEntityToDto(updatedObj);
	}
	
	@Override
	public BoardDto delete(Long id) {
		Board obj = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));

		obj.setStatus(0);

		Board updatedObj = boardRepository.save(obj);
		return BoardDto.mapEntityToDto(updatedObj);
	}

	@Override
	public void terminate(Long id) {
		Board obj = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, "id", id));
		boardRepository.delete(obj);
	}

}
