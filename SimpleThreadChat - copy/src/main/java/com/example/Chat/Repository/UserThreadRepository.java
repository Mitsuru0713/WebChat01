package com.example.Chat.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Chat.Entity.UserThread;

@Repository
public interface UserThreadRepository extends JpaRepository<UserThread, Long>{
	
	//ページングのため
	public Page<UserThread> findAllByOrderByThreadIdDesc(Pageable pageable);

}
