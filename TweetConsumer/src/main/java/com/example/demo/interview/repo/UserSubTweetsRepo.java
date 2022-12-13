package com.example.demo.interview.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.interview.model.UserSubTweets;

public interface UserSubTweetsRepo  extends JpaRepository<UserSubTweets, Long> {

	List<UserSubTweets> findByUserId(String userId);

}
