package com.example.demo.interview.model;

public class HashTagSubScriber {
	
	private String hashTag;
	private String userId;
	
	public HashTagSubScriber() {}
	
	public HashTagSubScriber(String hashTag, String userId) {
		super();
		this.hashTag = hashTag;
		this.userId = userId;
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
		return "HashTagSubScriber [hashTag=" + hashTag + ", userId=" + userId + "]";
	}
	
}
