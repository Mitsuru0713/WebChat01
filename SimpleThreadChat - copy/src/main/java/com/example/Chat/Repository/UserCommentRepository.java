package com.example.Chat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Chat.Entity.UserComment;
import com.example.Chat.Entity.UserThread;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Long> {

	public List<UserComment>  findAllByUserThreadOrderByDatetimeAsc(UserThread userThread);

	
	
}
