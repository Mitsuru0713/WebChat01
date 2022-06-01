package com.example.Chat.Form;

import java.io.Serializable;

import com.sun.istack.NotNull;

public class UserCommentForm implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String comment;

	
	public UserCommentForm() {
		
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
