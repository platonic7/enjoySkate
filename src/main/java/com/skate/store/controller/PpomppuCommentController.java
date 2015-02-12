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
public class PpomppuCommentController {
	@Autowired private BoardCommentService commentService;
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/pommppuBoardComment" , method = RequestMethod.POST)
	public String ppomppuCommentWrite(BoardComment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		commentService.savePpomppuComment(comment, email);
		return "redirect:/ppomppu/"+comment.getPpomppuId()+"/content";
	}
	
	@RequestMapping(value = "/ppomppu/{commentId}/commentDelete", method = RequestMethod.GET)
	public String ppomppuCommentDelete(@PathVariable long commentId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		BoardComment boardComment = commentService.findById(commentId);
		long ppomppuBoardId = boardComment.getPpomppuBoard().getId();
		if (boardComment.getUser().getEmail().equals(email)) {
			commentService.delete(commentId);
		}
		return "redirect:/ppomppu/"+ppomppuBoardId+"/content";
	}

}



















