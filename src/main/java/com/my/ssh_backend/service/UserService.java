package com.my.ssh_backend.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ssh_backend.dao.UserDao;
import com.my.ssh_backend.vo.User;

@Service
public class UserService {
	
	
	@Autowired
	UserDao userDao;
	
	
	public int updateDelNy(User user) {
		return userDao.updateDelNy(user);
	}
	
	public int delete(int user_idx) {
		return userDao.delete(user_idx);
	}
	
	public int updateAddress(User user) {
		return userDao.updateAddress(user);
	}
	
	public List<User> all(HashMap<String, Object> map) {
		return userDao.all(map);
	}
	
	public User findById(String id) {
		return userDao.findById(id);
	}
	
	public User findByNick(String nick) {
		return userDao.findNick(nick);
	}
	
	
	public int create(User u) {
		return userDao.create(u);
		
	}
	
	
	public User getUser2() {
		return userDao.getUser2();
		
	}
	
	public User findByIdx(int user_dix) {
		return userDao.findByIdx(user_dix);
		
	}
	
}
