package com.ymksun.taskmgmt.service;

import java.util.List;

import com.ymksun.taskmgmt.model.Board;

public interface BoardService {

	List<Board> getAll();

	Board save(Board board);

	Board getById(Long id);

	Board update(Long id, Board board);

	Board delete(Long id);

	void terminate(Long id);
}
