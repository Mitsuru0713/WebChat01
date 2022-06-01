package com.example.Chat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Chat.Entity.UserComment;
import com.example.Chat.Entity.UserThread;
import com.example.Chat.Form.UserCommentForm;
import com.example.Chat.Service.UserCommentService;

@Controller
public class UserCommentController {
	
	
	@Autowired
	UserCommentService userCommentService;
	
	@ModelAttribute
	public UserCommentForm setForm() {
		
		return new UserCommentForm();
	}
	
	
	@GetMapping("/find/{userThread}")
	public String find(@PathVariable UserThread userThread, Model model) {
		
		List<UserComment> list = userCommentService.getCommentList(userThread);
		
		model.addAttribute("userThread", userThread);
		model.addAttribute("userCommentList", list);
		
		return "bbs";
	}
	
	@PostMapping("/add/{userThread}")
	public String add(@PathVariable UserThread userThread, 
			@Validated UserCommentForm form, BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			
		}
		
		userCommentService.addUserComment(form.getUserName(), form.getComment(), userThread);
		
		return "redirect:/find/{userThread}";
	}
}
