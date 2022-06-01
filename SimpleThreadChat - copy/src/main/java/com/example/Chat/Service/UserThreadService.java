package com.example.Chat.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Chat.Entity.UserThread;
import com.example.Chat.Repository.UserThreadRepository;

@Service
public class UserThreadService {

	@Autowired
	UserThreadRepository userThreadRepository;
	
	//スレッド一覧をページネーションを用いて取得
	@Transactional(readOnly = true)
	public Page<UserThread> getUserThreadList(Pageable pageable){
		
		return userThreadRepository.findAllByOrderByThreadIdDesc(pageable);
	}
	
	//新しいスレッドをつくる
	@Transactional
	public UserThread createUserThread(String title) {
		
		UserThread userThread = new UserThread();
		userThread.setTitle(title);
		
		userThreadRepository.save(userThread);
		 
		return userThread;
	}
}
