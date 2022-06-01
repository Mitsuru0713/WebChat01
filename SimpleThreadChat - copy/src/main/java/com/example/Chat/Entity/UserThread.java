package com.example.Chat.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Thread")
public class UserThread implements Serializable{
	
	//主キーのid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "thread_id")
	private Long threadId;
	
	//タイトル
	@Column(name = "title")
	private String title;
	
	//一つのスレッドに対してコメントは多
	@OneToMany(mappedBy = "userThread")
	private List<UserComment> comments;

	
	public UserThread(Long threadId, String title, List<UserComment> comments) {
		super();
		this.threadId = threadId;
		this.title = title;
		this.comments = comments;
	}

	
	public UserThread() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public Long getThreadId() {
		return threadId;
	}

	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
