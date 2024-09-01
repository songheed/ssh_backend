package com.my.ssh_backend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ssh_backend.service.UserService;
import com.my.ssh_backend.vo.User;

@Controller
@RequestMapping(value="api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("unjoin")
	@ResponseBody
	public String nujoin(
			@RequestParam(value="user_idx") int userIdx
			) {
		
		User result = userService.findByIdx(userIdx);
		if(result == null) {
			return "no user";			
		}
		
		
		
		User u = new User();
		u.setUser_idx(userIdx);
		u.setDel_ny("y");
		
		userService.updateDelNy(u);
		
		return "ok";
	}
	
	
	@PostMapping("delete")
	@ResponseBody
	public String delete(
			@RequestParam(value="user_idx") int userIdx
			) {
		
		userService.delete(userIdx);
		return "ok";
	}
	
	
	@PostMapping("change_addr")
	@ResponseBody
	public String updateAddress( 
			@RequestParam(value="user_idx") int userIdx,
			@RequestParam(value="new_address") String address
			) {
		User user = new User();
		user.setUser_idx(userIdx);
		user.setAddress(address);
		userService.updateAddress(user);
		
		return "ok";
	}
	
	
	@GetMapping("all")
	@ResponseBody
	public List<User> all(
			@RequestParam(value="start", defaultValue="0") int s,
			@RequestParam(value="count", defaultValue="30") int c
			) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", s);
		map.put("count", c);
		
		List<User> list = userService.all(map);
		return list;
	}
	
	
	@GetMapping("create")
	@ResponseBody
	public String create(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				@RequestParam(value="nn") String nick,
				@RequestParam(value="addr") String address
			) {
		
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		user.setNick(nick);
		user.setAddress(address);
		
		
		
//		for(int i=0;i<1000;i++) {
//			User user1 = new User();
//			user1.setId(id+i);
//			user1.setPw(pw);
//			user1.setNick(nick+i);
//			user1.setAddress(address+i);
//			
//			userService.create(user1);
//			
//		}
//		
//		return "ok1";
		
		
		
		
		//아이디 검증
		User user1 = userService.findById(id);
		if(user1 != null) {
			return "id_duplicted";
		}
		
		//닉네임 검증
		User user2 = userService.findByNick(nick);
		if(user2 != null) {
			return "nick_duplicted";
		}
		
		userService.create(user);
		
		return "ok";
	}
	
	
	
	@GetMapping("user2-page")
	public String user2Page(
					Model model,
					@RequestParam(value="user_idx") int user_idx
			) {
		
//		User user = userService.getUser2();
		User user = userService.findByIdx(user_idx);
		
		model.addAttribute("u", user);
		return "user";
	}
	
	
	
	
	@GetMapping("user")
	@ResponseBody
	public User user(
				@RequestParam(value="user_idx") int user_idx
			) {
		
		User user = userService.findByIdx(user_idx);
		
		return user;
	}
	
}
