package com.skate.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skate.store.domain.BoardComment;
import com.skate.store.service.BoardCommentService;

@Controller
public class BuyBoardCommentController {
	@Autowired private BoardCommentService commentService;
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/buyBoardComment" , method = RequestMethod.POST)
	public String buyCommentWrite(BoardComment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		commentService.saveBuyComment(comment, email);
		return "redirect:/buyandsell/"+comment.getBuyId()+"/content";
	}
	
	@RequestMapping(value = "/buyandsell/{commentId}/commentDelete", method = RequestMethod.GET)
	public String buyCommentDelete(@PathVariable long commentId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		BoardComment boardComment = commentService.findById(commentId);
		long buyBoardId = boardComment.getBuyBoard().getId();
		if (boardComment.getUser().getEmail().equals(email)) {
			commentService.delete(commentId);
		}
		return "redirect:/buyandsell/"+buyBoardId+"/content";
	}

}



















