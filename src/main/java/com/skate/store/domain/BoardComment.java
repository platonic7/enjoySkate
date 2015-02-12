package com.skate.store.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class BoardComment implements Serializable {
	private static final long serialVersionUID = -4481114606192712687L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Board board;
	
	@ManyToOne
	private News news;
	
	@ManyToOne
	private Spot spot;
	
	@ManyToOne
	private EnjoyBoard enjoyBoard;
	
	@ManyToOne
	private BuyBoard buyBoard;
	
	@ManyToOne
	private PpomppuBoard ppomppuBoard;

	@PrePersist
	private void perpersist(){
		this.createdTime = this.updatedTime = new Date();
	}
	
	@PreUpdate
	private void perpersistUpdate(){
		this.updatedTime = new Date();
	}
	
	@Transient
	private long boardId;
	
	@Transient
	private long newsId;
	
	@Transient
	private long spotId;
	
	@Transient
	private long enjoyId;
	
	@Transient
	private long buyId;
	
	@Transient
	private long ppomppuId;
	
	
	public BoardComment() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setBoardId(long boardId){
		this.boardId = boardId;
	}
	public long getBoardId() {
		return this.boardId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public long getNewsId() {
		return newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	
	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public long getSpotId() {
		return spotId;
	}

	public void setSpotId(long spotId) {
		this.spotId = spotId;
	}
	
	public EnjoyBoard getEnjoyBoard() {
		return enjoyBoard;
	}

	public void setEnjoyBoard(EnjoyBoard enjoyBoard) {
		this.enjoyBoard = enjoyBoard;
	}
	
	public BuyBoard getBuyBoard() {
		return buyBoard;
	}

	public void setBuyBoard(BuyBoard buyBoard) {
		this.buyBoard = buyBoard;
	}

	public PpomppuBoard getPpomppuBoard() {
		return ppomppuBoard;
	}

	public void setPpomppuBoard(PpomppuBoard ppomppuBoard) {
		this.ppomppuBoard = ppomppuBoard;
	}
	
	public long getEnjoyId() {
		return enjoyId;
	}

	public void setEnjoyId(long enjoyId) {
		this.enjoyId = enjoyId;
	}

	public long getBuyId() {
		return buyId;
	}

	public void setBuyId(long buyId) {
		this.buyId = buyId;
	}

	public long getPpomppuId() {
		return ppomppuId;
	}

	public void setPpomppuId(long ppomppuId) {
		this.ppomppuId = ppomppuId;
	}
}
