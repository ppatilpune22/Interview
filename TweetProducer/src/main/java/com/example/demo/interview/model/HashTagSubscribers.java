package com.example.demo.interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class HashTagSubscribers {
	
	@Id
	@GeneratedValue
	private Long id;
	private String hashTag;
	private String userId;
	
	public HashTagSubscribers() {}
	
	public HashTagSubscribers(String hashTag, String userId) {
		super();
		this.hashTag = hashTag;
		this.userId = userId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "HashTagSubscribers [id=" + id + ", hashTag=" + hashTag + ", userId=" + userId + "]";
	}


	
}
