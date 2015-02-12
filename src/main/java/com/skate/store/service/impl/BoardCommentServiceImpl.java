package com.skate.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.Board;
import com.skate.store.domain.BoardComment;
import com.skate.store.domain.BuyBoard;
import com.skate.store.domain.EnjoyBoard;
import com.skate.store.domain.News;
import com.skate.store.domain.PpomppuBoard;
import com.skate.store.domain.Spot;
import com.skate.store.domain.User;
import com.skate.store.repository.BoardCommentRepository;
import com.skate.store.service.BoardCommentService;
import com.skate.store.service.BoardService;
import com.skate.store.service.BuyBoardService;
import com.skate.store.service.EnjoyBoardService;
import com.skate.store.service.NewsService;
import com.skate.store.service.PpomppuBoardService;
import com.skate.store.service.SpotService;
import com.skate.store.service.UserService;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	@Autowired private BoardCommentRepository boardCommentRepository;
	@Autowired private BoardService boardService;
	@Autowired private UserService userService;
	@Autowired private NewsService newsService; 
	@Autowired private SpotService spotService; 
	@Autowired private PpomppuBoardService ppomppuService;
	@Autowired private EnjoyBoardService enjoyBoardService;
	@Autowired private BuyBoardService buyBoardService;
	
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(BoardComment comment) {
		boardCommentRepository.saveAndFlush(comment);
	}

	@Override
	public List<BoardComment> findAll() {
		return boardCommentRepository.findAll();
	}
	
	@Override
	public void printAllBoardComment() {
		List<BoardComment> allBoard = boardCommentRepository.findAll();
		
		for (BoardComment boardComment : allBoard) {
			System.out.println(boardComment.getContent());
		}
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public BoardComment findById(long commentId) {
		return boardCommentRepository.findOne(commentId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long commentId) {
		boardCommentRepository.delete(commentId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void saveComment(BoardComment comment, String email) {
		Board board = boardService.findById(comment.getBoardId());
		User user = userService.findByEmail(email);
		comment.setUser(user);
		comment.setBoard(board);
		boardCommentRepository.saveAndFlush(comment);
	}
	
//	News Comment
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void saveNewsComment(BoardComment comment, String email) {
		News news = newsService.findById(comment.getNewsId());
		User user = userService.findByEmail(email);
		comment.setUser(user);
		comment.setNews(news);
		boardCommentRepository.saveAndFlush(comment);
	}
	
//	Spot Comment
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void saveSpotComment(BoardComment comment, String email) {
		Spot spot = spotService.findById(comment.getSpotId());
		User user = userService.findByEmail(email);
		comment.setUser(user);
		comment.setSpot(spot);
		boardCommentRepository.saveAndFlush(comment);
	}

//Ppomppu Comment
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void savePpomppuComment(BoardComment comment, String email) {
		PpomppuBoard ppomppuBoard = ppomppuService.findById(comment.getPpomppuId());
		User user = userService.findByEmail(email);
		comment.setUser(user);
		comment.setPpomppuBoard(ppomppuBoard);
		boardCommentRepository.saveAndFlush(comment);
	}

//EnjoyBoard Comment
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void saveEnjoyTogetherComment(BoardComment comment, String email) {
		EnjoyBoard enjoyBoard = enjoyBoardService.findById(comment.getEnjoyId());
		User user = userService.findByEmail(email);
		comment.setUser(user);
		comment.setEnjoyBoard(enjoyBoard);
		boardCommentRepository.saveAndFlush(comment);
	}

//BuyBoard Comment
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void saveBuyComment(BoardComment comment, String email) {
		BuyBoard buyBoard = buyBoardService.findById(comment.getBuyId());
		User user = userService.findByEmail(email);
		comment.setUser(user);
		comment.setBuyBoard(buyBoard);
		boardCommentRepository.saveAndFlush(comment);
	}
}
