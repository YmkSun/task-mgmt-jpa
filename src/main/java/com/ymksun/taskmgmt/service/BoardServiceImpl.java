package com.ymksun.taskmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymksun.taskmgmt.exception.ResourceNotFoundException;
import com.ymksun.taskmgmt.model.Board;
import com.ymksun.taskmgmt.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository;

	@Override
	public List<Board> getAll() {
		return boardRepository.findAll();
	}

	@Override
	public Board save(Board board) {
		return boardRepository.save(board);
	}

	@Override
	public Board getById(Long id) {
		return boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board", "id", id));
	}

	@Override
	public Board update(Long id, Board boardDetail) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board", "id", id));

		board.setName(boardDetail.getName());
		board.setDescription(boardDetail.getDescription());
		board.setStatus(boardDetail.getStatus());
		board.setType(boardDetail.getType());

		Board updatedBoard = boardRepository.save(board);
		return updatedBoard;
	}
	
	@Override
	public Board delete(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board", "id", id));

		board.setStatus(0);

		Board updatedBoard = boardRepository.save(board);
		return updatedBoard;
	}

	@Override
	public void terminate(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board", "id", id));

		boardRepository.delete(board);

	}

}
