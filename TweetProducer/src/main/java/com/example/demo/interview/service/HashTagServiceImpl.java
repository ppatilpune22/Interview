package com.example.demo.interview.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.interview.model.HashTagSubscribers;
import com.example.demo.interview.model.Tweet;
import com.example.demo.interview.model.TweetPublisher;
import com.example.demo.interview.repo.HashTagSubscribersRepo;
import com.example.demo.interview.repo.TweetRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class HashTagServiceImpl implements HashTagService {

	@Autowired
	TweetRepo tweetRep;
	@Autowired
	HashTagSubscribersRepo hashTagSubscribersRepo;
	
    @Autowired 
    KafkaTemplate<String, String> kafkaTemplate;
 
    // to -do inject as proeprties
    private static final String TOPIC = "HashTagTweetTopic";
 
	@PostConstruct
	public void init() {
		try {
			loadHashTags();
		} catch (IOException e) {
			System.out.println("Failed to initialize the tags");
			// business logic will deside the action required
		}
	}

	@Override
	public List<String> loadHashTags() throws IOException {
		// load all hash tags from file
		String fileName = "";
		List<String> result;
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			result = lines.collect(Collectors.toList());
		}

		return result;
	}

	@Override
	public Tweet tweetWithHashTag(Tweet tweet) {
		// save the tweet (Not requirement) and send kafka message
		Tweet tweetResp = tweetRep.save(tweet);
		return tweetResp;
	}
	
	@Override
	public void PublishTheTweet(Tweet tweet) {
		List<HashTagSubscribers> subscribers = hashTagSubscribersRepo.findByHashTag(tweet.getHashTag());
		List<String> userList = subscribers.stream().map(s->s.getUserId()).toList();
		TweetPublisher publishTweet = new TweetPublisher(tweet, userList);
		// Put the message in kafka
		ObjectMapper Obj = new ObjectMapper();  
		String jsonStr = null;
		try {
			jsonStr = Obj.writeValueAsString(publishTweet);
		} catch (JsonProcessingException e) {
			
		}  
         
		System.out.println("sending -- "+jsonStr);
	    kafkaTemplate.send(TOPIC,jsonStr);
	    
	}

	@Override
	public void getTweets(String hashTag) {
		tweetRep.getByhashTag(hashTag);

	}

	@Override
	public void follow(HashTagSubscribers subscriber) {
		hashTagSubscribersRepo.save(subscriber);
	}

	@Override
	public List<Tweet> tweetWithHashTag() {
		return tweetRep.findAll();
	}

	@Override
	public List<HashTagSubscribers> getHashTagSubscribers() {
		return hashTagSubscribersRepo.findAll();
	}

}
