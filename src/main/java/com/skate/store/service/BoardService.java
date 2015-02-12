package com.skate.store.service;

import java.util.List;

import com.skate.store.domain.Board;

public interface BoardService {

	void save(Board board);
	List<Board> findAll();
	void delete(long id);
	Board findById(long boardId);
	List<Board> findTopByOrderByTitleDesc();
	void save(Board board, String email);
	
}
