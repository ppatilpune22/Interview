package com.example.demo.interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue
	private Long id;
	private String tweetBy;
	private String hashTag;
	private String message;
	
	public Tweet() {}
	
	public Tweet(String tweetBy, String hashTag, String message) {
		super();
		this.tweetBy = tweetBy;
		this.hashTag = hashTag;
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTweetBy() {
		return tweetBy;
	}
	public void setTweetBy(String tweetBy) {
		this.tweetBy = tweetBy;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HashTagTweetRequest [tweetBy=" + tweetBy + ", hashTag=" + hashTag + ", message=" + message + "]";
	}

}
