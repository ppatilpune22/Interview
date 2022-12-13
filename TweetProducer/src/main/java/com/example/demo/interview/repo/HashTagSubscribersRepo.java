package com.example.demo.interview.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.interview.model.HashTagSubscribers;

public interface HashTagSubscribersRepo extends JpaRepository<HashTagSubscribers, Long>  {

	List<HashTagSubscribers> findByHashTag(String string);

}
