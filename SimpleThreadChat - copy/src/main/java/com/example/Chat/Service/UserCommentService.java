package com.example.Chat.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Chat.Entity.UserComment;
import com.example.Chat.Entity.UserThread;
import com.example.Chat.Repository.UserCommentRepository;
import com.example.Chat.Repository.UserThreadRepository;

@Service
public class UserCommentService {

	@Autowired
	UserThreadRepository userThreadRepository;
	
	@Autowired
	UserCommentRepository userCommentRepository;
	
	//コメント一覧の取得
	@Transactional(readOnly = true)
	public List<UserComment> getCommentList(UserThread userThread){
		
		return userCommentRepository.findAllByUserThreadOrderByDatetimeAsc(userThread);
	}
	
	//コメントの追加
	@Transactional
	public UserComment addUserComment(String userName,
			String comment, UserThread userThread) {
		
		UserComment userComment = new UserComment();
		
		userComment.setUserName(userName);
		userComment.setDateTime(LocalDateTime.now());
		userComment.setComment(comment);
		userComment.setUserThread(userThread);
		
		return userCommentRepository.saveAndFlush(userComment);
	}
}
