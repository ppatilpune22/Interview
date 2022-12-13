package com.example.demo.interview.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.interview.model.Tweet;
import com.example.demo.interview.model.TweetPublisher;
import com.example.demo.interview.model.UserSubTweets;
import com.example.demo.interview.service.HashTagConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HashtagNotificationConsumer {

	@Autowired
	private HashTagConsumerService hashTagConsumerService;
	
	// to-do inject as property file
	@KafkaListener(topics = "HashTagTweetTopic", groupId = "group_id")
	public void consume(String message) {
		System.out.println("message = " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		TweetPublisher data = null;
		try {
			data = objectMapper.readValue(message, TweetPublisher.class);
		} catch (JsonProcessingException e) {
			System.out.println("Invalid data");
			return;
		}
		Tweet tweet = data.getTweet();
		List<String> users = data.getUsers();
		List<UserSubTweets> userSubTweets = users.stream().map(s->new UserSubTweets(null, s, tweet.getMessage(), tweet.getHashTag())).toList();
		System.out.println(userSubTweets);
		
		hashTagConsumerService.addTueets(userSubTweets);
	}

}
