package com.skate.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.Board;
import com.skate.store.domain.User;
import com.skate.store.repository.BoardRepository;
import com.skate.store.service.BoardService;
import com.skate.store.service.UserService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired private BoardRepository boardRepository;
	@Autowired private UserService userService;

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(Board board) {
		boardRepository.saveAndFlush(board);
	}

	@Override
	public List<Board> findAll() {
		return boardRepository.findAll();
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long id) {
		boardRepository.delete(id);
	}

	@Override
	@Transactional(readOnly=true, rollbackFor=Exception.class)
	public Board findById(long id) {
		return boardRepository.findOne(id);
	}

	@Override
	public List<Board> findTopByOrderByTitleDesc() {
		return boardRepository.findTopByOrderByTitleDesc();
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(Board board, String email) {
		User user = userService.findByEmail(email);
		board.setUser(user);
		boardRepository.saveAndFlush(board);
	}



	

}
