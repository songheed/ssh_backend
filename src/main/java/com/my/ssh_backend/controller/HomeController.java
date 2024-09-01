package com.my.ssh_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HomeController {
	
	
	@GetMapping("/getUser/{userIdx}")
	//@ResponseBody 
	public String addUser(
				@PathVariable("userIdx") int userIdx,
				Model model
			) {
		
		String id = "test@gmail.com";
		String name = "김철수";
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "home";
	}
	
	@GetMapping("/saveUser")
	@ResponseBody
	public String saveUser(
			@RequestParam(value="uid") String id,
			@RequestParam(value="upw") String pw
			) {
		//회원가입
		System.out.println(id);
		System.out.println(pw);

		return "ok";
	}
	
	
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	

}
