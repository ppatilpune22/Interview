package com.example.demo.interview.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interview.model.HashTagSubscribers;
import com.example.demo.interview.model.Tweet;
import com.example.demo.interview.service.HashTagService;

@RestController
public class HashTagRestController {

	@Autowired
	private HashTagService hashTagService;

	@PostMapping("/follow")
	public void followHashTag(@RequestBody HashTagSubscribers request) {
		System.out.println("followHashTag - " + request);
		hashTagService.follow(request);
	}
	
	@PostMapping("/tweet")
	public Tweet tweetWithHashTag(@RequestBody Tweet request) {
		System.out.println("tweetWithHashTag - " + request);
		Tweet tweetResponse = hashTagService.tweetWithHashTag(request);
		hashTagService.PublishTheTweet(tweetResponse);
		return tweetResponse;
	}
	
	@GetMapping("/tweets")
	public List<Tweet> getTweets() {
		System.out.println("getTweets - ");
		return hashTagService.tweetWithHashTag();
	}
	
	@GetMapping("/hashTagSubscribers")
	public List<HashTagSubscribers> getHashTagSubscribers() {
		System.out.println("getHashTagSubscribers - ");
		return hashTagService.getHashTagSubscribers();
	}
	
}
