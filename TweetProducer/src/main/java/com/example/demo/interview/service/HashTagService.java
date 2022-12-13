package com.example.demo.interview.service;

import java.util.List;

import com.example.demo.interview.model.HashTagSubscribers;
import com.example.demo.interview.model.Tweet;


public interface HashTagService {
	
	List <String> loadHashTags() throws Exception;
	Tweet tweetWithHashTag(Tweet tweet);
	void getTweets(String hashTag);
	void follow(HashTagSubscribers request);
	List<Tweet> tweetWithHashTag();
	void PublishTheTweet(Tweet tweet);
	List<HashTagSubscribers> getHashTagSubscribers();
}
