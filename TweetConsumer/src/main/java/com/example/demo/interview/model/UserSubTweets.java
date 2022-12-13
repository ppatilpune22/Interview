package com.example.demo.interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserSubTweets {

	@Id
	@GeneratedValue
	private Long id;
	private String userId;
	private String tweetMessage;
	private String hashTag;
	
	public UserSubTweets() {}
	public UserSubTweets(Long id,String userId, String tweetMessage, String hashTag) {
	
		this.id = id;
		this.userId = userId;
		this.tweetMessage = tweetMessage;
		this.hashTag = hashTag;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTweetMessage() {
		return tweetMessage;
	}
	public void setTweetMessage(String tweetMessage) {
		this.tweetMessage = tweetMessage;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	@Override
	public String toString() {
		return "UserSubTweets [id=" + id + ", userId=" + userId + ", tweetMessage=" + tweetMessage + ", hashTag="
				+ hashTag + "]";
	}

}
