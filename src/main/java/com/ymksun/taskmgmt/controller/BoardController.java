package com.ymksun.taskmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymksun.taskmgmt.model.dto.BoardDto;
import com.ymksun.taskmgmt.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/list")
	public ResponseEntity<List<BoardDto>> getAllBoards() {
		return new ResponseEntity<>(boardService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<BoardDto> createBoard(@Valid @RequestBody BoardDto board) {
		return new ResponseEntity<>(boardService.save(board), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BoardDto> getBoardById(@PathVariable(value = "id") Long boardId) {
		return new ResponseEntity<>(boardService.getById(boardId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<BoardDto> updateBoard(@PathVariable(value = "id") Long boardId,
			@Valid @RequestBody BoardDto boardDetails) {
		return new ResponseEntity<>(boardService.update(boardId, boardDetails), HttpStatus.OK);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStatusBoard(@PathVariable(value = "id") Long boardId) {
		BoardDto board = boardService.delete(boardId);
		return new ResponseEntity<>(board != null ? true : false, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable(value = "id") Long boardId) {
		boardService.terminate(boardId);
		return ResponseEntity.ok().build();
	}

}
