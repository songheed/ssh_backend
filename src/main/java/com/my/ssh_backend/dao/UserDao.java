package com.my.ssh_backend.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.ssh_backend.vo.User;

@Repository
public class UserDao {
	
	@Autowired
	SqlSession s;
	
	public int updateDelNy(User user) {
		return s.update("UserMapper.updateDelNy", user);
	}
	
	public int delete(int user_idx) {
		return s.delete("UserMapper.delete", user_idx);
	}
	
	public int updateAddress(User user) {
		return  s.update("UserMapper.updateAdress",user);
	}
	
	public List<User> all(HashMap<String, Object> map) {
		List<User> list = s.selectList("UserMapper.findAll",map); 
		
		return list;
	}
	
	
	public User findById(String id) {
		return s.selectOne("UserMapper.findById",id);
	}
	
	
	public User findNick(String nick) {
		User r = s.selectOne("UserMapper.findNick",nick);
		return r;
	}
	
	/*public void create() {
		
		User a = new User();
		a.setId("hello");
		s.insert("UserMapper.save",a);//mapper의 namespace.id
	}*/
	
	public int create(User u) {
//		return 2*s.insert("UserMapper.save",u);//mapper의 namespace.id
		return s.insert("UserMapper.save",u);//mapper의 namespace.id
	}
	
	public User getUser2() {
//		User u= s.selectOne("UserMapper.findUser2");
//		return u;
		
		return s.selectOne("UserMapper.findUser2");
	}
	
	public User findByIdx(int user_idx) {
		User result = s.selectOne("UserMapper.findByIdx",user_idx);
		return result;
	}
	
	
	
}

// 1 void 함수 생성
// 2 로직
// 3 매개변수 (선택)
// 4 리턴 (선택)








