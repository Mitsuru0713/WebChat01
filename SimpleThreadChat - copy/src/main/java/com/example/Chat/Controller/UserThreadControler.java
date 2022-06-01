package com.example.Chat.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Chat.Entity.UserComment;
import com.example.Chat.Entity.UserThread;
import com.example.Chat.Form.UserCommentForm;
import com.example.Chat.Form.UserThreadForm;
import com.example.Chat.Service.UserCommentService;
import com.example.Chat.Service.UserThreadService;

@Controller
public class UserThreadControler {
	
	@Autowired
	UserThreadService userThreadService;
	
	@Autowired
	UserCommentService userCommentService;
	
	@ModelAttribute
	public UserThreadForm setUserThreadForm() {
		
		return new UserThreadForm();
	}
	
	@ModelAttribute
	public UserCommentForm setUserCommentForm() {
		
		return new UserCommentForm();
	}
	
	//降順にスレッド１０件取得
	@GetMapping("/")
	public String index(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
		
		Page<UserThread> page = userThreadService.getUserThreadList(pageable);
		model.addAttribute("page", page);
		model.addAttribute("userThreadListPage", page.getContent());
		
		return "index"; 
	}
	
	//新規スレッド作成リクエスト処理
	@PostMapping("/create")
	public String create(@Validated UserThreadForm form, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "index";
		}
		
		UserThread userThread = userThreadService.createUserThread(form.getTitle());
		model.addAttribute("userThread", userThread);
		
		userCommentService.addUserComment(form.getUserName(), form.getComment(),userThread );
		List<UserComment> list = userCommentService.getCommentList(userThread);
		model.addAttribute("userCommentList", list);
		
		
		return "bbs";
	}
}
