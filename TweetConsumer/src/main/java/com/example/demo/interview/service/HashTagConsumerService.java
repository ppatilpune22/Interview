package com.example.demo.interview.service;

import java.util.List;

import com.example.demo.interview.model.Tweet;
import com.example.demo.interview.model.UserSubTweets;

public interface HashTagConsumerService {
	
	List<UserSubTweets> getTweets(String userId);
	List<UserSubTweets> getUserSubTweets();
	void addTueets(List<UserSubTweets> tweets);

}
