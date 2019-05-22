package chauncy.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chauncy.test02.mapper.UserMapper2;

@Service
public class UserService2 {
	
	@Autowired
	private UserMapper2 userMapper2;
	
	
	public int addUser(String name,Integer age){
		return userMapper2.addUser(name, age);
	}
}
