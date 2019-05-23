package chauncy.test01.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chauncy.test01.mapper.UserMapper1;
import chauncy.test02.mapper.UserMapper2;

@Service
public class UserService1 {
	
	@Autowired
	private UserMapper1 userMapper1;
	@Autowired
	private UserMapper2 userMapper2;
	
	
	public int addUser(String name,Integer age){
		return userMapper1.addUser(name, age);
	}
	
	@Transactional
	public int addUser1AndUser2(){
		userMapper1.addUser("test01", 18);
		System.out.println("数据库01插入完毕。。");
		userMapper2.addUser("test02", 19);
		int i=1/0;
		return 0;
	}
}
