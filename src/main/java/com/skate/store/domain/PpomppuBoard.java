package com.skate.store.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PpomppuBoard implements Serializable{
	private static final long serialVersionUID = 9157605259884361546L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String imagePath;
	private String title;
	private String content;
	private int count;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@PrePersist
	private void perpersist(){
		this.createdTime = this.updatedTime = new Date();
	}
	
	@PreUpdate
	private void perpersistUpdate(){
		this.updatedTime = new Date();
	}
	
	@OneToMany(mappedBy="ppomppuBoard")
	private List<BoardComment> boardcommentList;
	
	@ManyToOne
	private User user;
	
	public PpomppuBoard() {};
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<BoardComment> getBoardcommentList(){
		return this.boardcommentList;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void setBoardcommentList(List<BoardComment> boardcommentList) {
		this.boardcommentList = boardcommentList;
	}
}
