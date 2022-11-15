package com.harsha.learn.simpleBlog.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "postId")
	Long postId;
	
	@Column(name = "title", nullable = false)
	String title;
	
	
	@Column(name = "body")
	String body;
	
	@Column(name = "creationTimeStamp")
	LocalDateTime creationTimeStamp = LocalDateTime.now();
	
	@Column(name = "UpdatedTimeStamp")
	LocalDateTime UpdatedTimeStamp = LocalDateTime.now();

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(LocalDateTime creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}

	public LocalDateTime getUpdatedTimeStamp() {
		return UpdatedTimeStamp;
	}

	public void setUpdatedTimeStamp(LocalDateTime updatedTimeStamp) {
		UpdatedTimeStamp = updatedTimeStamp;
	}
	
	public Post() {
		
	}
	
	public Post(Long postId) {
		this.postId = postId;
	}
	
}
