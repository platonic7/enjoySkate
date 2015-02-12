package com.skate.store.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = -4562817783773006430L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
//	@Email(message="Please provide a valid email address")
//	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;
	
	private String password;
	private String username;
	
	private String quiz;
	private String quizResult;
	
	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.ROLE_READY;
	
	public UserRole getRole() {
		return role;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Board> boardList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<BoardComment> commentList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<News> newsList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Spot> spotList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<EnjoyBoard> enjoyBoardList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<BuyBoard> buyBoardList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<PpomppuBoard> ppomppuBoardList;
	
	
	@PrePersist
	private void perpersist(){
		this.createdTime = this.updatedTime = new Date();
	}
	
	@PreUpdate
	private void perpersistUpdate(){
		this.updatedTime = new Date();
	}
	
	enum UserRole {
		ROLE_USER,
		ROLE_READY,
		ROLE_ADMIN
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getQuizResult() {
		return quizResult;
	}

	public void setQuizResult(String quizResult) {
		this.quizResult = quizResult;
	}

	public User() {}
	
	public User(String userName, String password) {
		this.username = userName;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}

	public List<BoardComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<BoardComment> commentList) {
		this.commentList = commentList;
	}
	
	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<Spot> getSpotList() {
		return spotList;
	}

	public void setSpotList(List<Spot> spotList) {
		this.spotList = spotList;
	}
	
	public List<EnjoyBoard> getEnjoyBoardList() {
		return enjoyBoardList;
	}

	public void setEnjoyBoardList(List<EnjoyBoard> enjoyBoardList) {
		this.enjoyBoardList = enjoyBoardList;
	}
	
	public List<BuyBoard> getBuyBoardList() {
		return buyBoardList;
	}

	public void setBuyBoardList(List<BuyBoard> buyBoardList) {
		this.buyBoardList = buyBoardList;
	}
	
	public List<PpomppuBoard> getPpomppuBoardList() {
		return ppomppuBoardList;
	}

	public void setPpomppuBoardList(List<PpomppuBoard> ppomppuBoardList) {
		this.ppomppuBoardList = ppomppuBoardList;
	}

	public void update(User user) {
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.quiz = user.getQuiz();
		this.quizResult = user.getQuizResult();
	}
}