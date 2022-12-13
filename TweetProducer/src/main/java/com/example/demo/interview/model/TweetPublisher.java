package com.example.demo.interview.model;

import java.util.List;

public class TweetPublisher {
	private Tweet tweet;
	private List<String> users;
	
	public TweetPublisher() {}

	public TweetPublisher(Tweet tweet, List<String> users) {
		super();
		this.tweet = tweet;
		this.users = users;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "TweetPublisher [tweet=" + tweet + ", users=" + users + "]";
	}


}
