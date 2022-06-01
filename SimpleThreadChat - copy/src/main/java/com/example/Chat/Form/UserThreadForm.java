package com.example.Chat.Form;

import java.io.Serializable;

import com.sun.istack.NotNull;

//スレッド作成フォームに対応するクラス
public class UserThreadForm implements Serializable{
	public static final long serialVersionUID = 1L;

	public UserThreadForm() {
		
	}
	
	@NotNull
	private String title;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String comment;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
