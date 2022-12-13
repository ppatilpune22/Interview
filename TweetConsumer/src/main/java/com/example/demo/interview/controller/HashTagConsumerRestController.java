package com.example.demo.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.interview.model.HashTagSubScriber;
import com.example.demo.interview.model.UserSubTweets;
import com.example.demo.interview.service.HashTagConsumerService;

@RestController
public class HashTagConsumerRestController {
	
	@Autowired
	private HashTagConsumerService hashTagConsumerService;
	
	@GetMapping("/getUserSubTweets")
	List <UserSubTweets> getUserSubTweets()
	{
		System.out.println("getUserSubTweets - " );
		return hashTagConsumerService.getUserSubTweets();
	}
	
	@GetMapping("/getUserSubTweets/{userId}")
	List <UserSubTweets> getUserSubTweets(@PathVariable String userId)
	{
		 System.out.println("getUserSubTweets for " +userId);
		return hashTagConsumerService.getTweets(userId);
	}
	
	@PostMapping("/subscribeForHashTag")
	public void subscribeForHashTag(@RequestBody HashTagSubScriber subscriber)
	{
		 System.out.println("subscribe for " + subscriber);
		 RestTemplate restTemplate = new RestTemplate();
	     restTemplate.postForEntity("http://localhost:8771/follow",subscriber, HashTagSubScriber.class);
	}

}
