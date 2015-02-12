package com.skate.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skate.store.domain.BoardComment;
import com.skate.store.domain.News;
import com.skate.store.service.BoardCommentService;
import com.skate.store.service.NewsService;

@Controller
public class NewsCommentController {
	@Autowired private BoardCommentService commentService;
	@Autowired private NewsService newsService;
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/newsComment", method = RequestMethod.POST)
	public String newsCommentWrite(BoardComment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		commentService.saveNewsComment(comment, email);
		return "redirect:/news/"+comment.getNewsId()+"/detail";
	}
	
	@RequestMapping(value = "/newsCommentUpdate", method = RequestMethod.POST)
	public String newsCommentUpdate(BoardComment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		commentService.saveNewsComment(comment, email);
		return "redirect:/news/"+comment.getNewsId()+"/detail";
	}
	
	//News Comment
	@RequestMapping(value = "/news/{newsId}/{commentId}/commentUpdate", method = RequestMethod.GET)
	public String newsCommentUpdatePage(@PathVariable long newsId,@PathVariable long commentId, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		News news = newsService.findById(newsId);
		BoardComment boardComment = commentService.findById(commentId);
		
		if (news.getUser().getEmail().equals(email)) {
			model.addAttribute("news", news);
			model.addAttribute("boardComment", boardComment);
			
			return "news/commentUpdate";
		}
		return "redirect:/news/"+news+"/detail";
	}
	
	@RequestMapping(value = "/news/{commentId}/commentDelete", method = RequestMethod.GET)
	public String newsCommentDelete(@PathVariable long commentId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		BoardComment boardComment = commentService.findById(commentId);
		long newsId = boardComment.getNews().getId();
		if (boardComment.getUser().getEmail().equals(email)) {
			commentService.delete(commentId);
		}
		return "redirect:/news/"+newsId+"/detail";
	}
	/* News Comment end */
}
