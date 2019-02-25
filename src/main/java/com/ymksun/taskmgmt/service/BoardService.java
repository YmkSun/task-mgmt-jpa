package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.dto.BoardDto;

public interface BoardService {

	List<BoardDto> getAll();

	BoardDto save(BoardDto dto);

	BoardDto getById(Long id);

	BoardDto update(Long id, BoardDto dto);

	BoardDto delete(Long id);

	void terminate(Long id);
}
