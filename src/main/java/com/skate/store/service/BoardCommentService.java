package com.skate.store.service;

import java.util.List;

import com.skate.store.domain.BoardComment;

public interface BoardCommentService {

	List<BoardComment> findAll();
	BoardComment findById(long commentId);
	void save(BoardComment comment);
	void printAllBoardComment();
	void delete(long commentId);
	void saveComment(BoardComment comment, String email);
	void saveNewsComment(BoardComment comment, String email);
	void saveSpotComment(BoardComment comment, String email);
	void savePpomppuComment(BoardComment comment, String email);
	void saveEnjoyTogetherComment(BoardComment comment, String email);
	void saveBuyComment(BoardComment comment, String email);

}
