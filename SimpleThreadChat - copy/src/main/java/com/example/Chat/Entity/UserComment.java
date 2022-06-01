package com.example.Chat.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comment")
public class UserComment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Long commentId;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "date")
	private LocalDateTime datetime;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userThread_id")
	private UserThread userThread;

	
	public UserComment(Long commentId, String userName, LocalDateTime datetime, String comment, UserThread userThread) {
		super();
		this.commentId = commentId;
		this.userName = userName;
		this.datetime = datetime;
		this.comment = comment;
		this.userThread = userThread;
	}

	public UserComment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getDateTime() {
		return datetime;
	}

	public void setDateTime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public UserThread getUserThread() {
		return userThread;
	}

	public void setUserThread(UserThread userThread) {
		this.userThread = userThread;
	}
	
}
