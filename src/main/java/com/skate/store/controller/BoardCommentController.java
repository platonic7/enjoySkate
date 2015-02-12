package com.skate.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skate.store.domain.BoardComment;
import com.skate.store.service.BoardCommentService;

@Controller
public class BoardCommentController {
	@Autowired private BoardCommentService commentService;
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public String commentWrite(BoardComment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		commentService.saveComment(comment, email);
		return "redirect:/boards/"+comment.getBoardId()+"/content";
	}
	
	@RequestMapping(value  = "/commentUpdate", method = RequestMethod.POST)
	public String commentUpdate(BoardComment boardComment) {
		commentService.save(boardComment);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/boards/comment", method = RequestMethod.GET)
	public String commentRead(ModelMap map) {
		List<BoardComment> commentList = commentService.findAll();
		map.put("commentList", commentList);
		return "boards/comment";
	}
	
	@RequestMapping(value = "/boards/{commentId}/commentUpdate", method = RequestMethod.GET)
	public String commentUpdatePage(@PathVariable long commentId, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		BoardComment boardComment = commentService.findById(commentId);
		long boardId = boardComment.getBoard().getId();
		if (boardComment.getUser().getEmail().equals(email)) {
			model.addAttribute("boardComment", boardComment);	
			return "boards/commentUpdate";
		}
		return "redirect:/boards/"+boardId+"/content";
	}
	
	@RequestMapping(value = "/boards/{commentId}/commentDelete", method = RequestMethod.GET)
	public String commentDelete(@PathVariable long commentId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		BoardComment boardComment = commentService.findById(commentId);
		long boardId = boardComment.getBoard().getId();
		if (boardComment.getUser().getEmail().equals(email)) {
			commentService.delete(commentId);
		}
		return "redirect:/boards/"+boardId+"/content";
	}
}






