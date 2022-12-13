package com.example.demo.interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.interview.model.Tweet;


public interface TweetRepo  extends JpaRepository<Tweet, Long> {

	void getByhashTag(String hashTag);

}
