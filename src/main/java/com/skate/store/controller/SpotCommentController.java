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
public class SpotCommentController {
	@Autowired private BoardCommentService commentService;
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/spotComment" , method = RequestMethod.POST)
	public String spotCommentWrite(BoardComment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		commentService.saveSpotComment(comment, email);
		return "redirect:/spots/"+comment.getSpotId()+"/detail";
	}
	
	@RequestMapping(value = "/spots/{commentId}/commentDelete", method = RequestMethod.GET)
	public String spotCommentDelete(@PathVariable long commentId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		BoardComment boardComment = commentService.findById(commentId);
		long spotId = boardComment.getSpot().getId();
		if (boardComment.getUser().getEmail().equals(email)) {
			commentService.delete(commentId);
		}
		return "redirect:/spots/"+spotId+"/detail";
	}
}



















