package chauncy.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chauncy.test01.mapper.UserMapper1;

@Service
public class UserService1 {
	
	@Autowired
	private UserMapper1 userMapper1;
	
	
	public int addUser(String name,Integer age){
		return userMapper1.addUser(name, age);
	}
}
