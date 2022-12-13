package com.example.demo.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interview.model.Tweet;
import com.example.demo.interview.model.UserSubTweets;
import com.example.demo.interview.repo.UserSubTweetsRepo;

@Service
public class HashTagConsumerServiceImpl implements HashTagConsumerService {
	@Autowired
	private UserSubTweetsRepo userSubTweetsRepo;

	@Override
	public List<UserSubTweets> getTweets(String userId) {
		return userSubTweetsRepo.findByUserId(userId);
	}
	
	@Override
	public List<UserSubTweets> getUserSubTweets() {
		return userSubTweetsRepo.findAll();
	}

	@Override
	public void addTueets(List<UserSubTweets> tweets) {
		userSubTweetsRepo.saveAll(tweets);
	}

}


