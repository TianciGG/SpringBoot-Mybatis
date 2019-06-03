package chauncy.test01.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
	
	//当一个方法执行时间比较长，就要使用多线程
	@Async
	public void sendSms(){
		System.out.println("sendSms()方法开始执行。。。");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("i:"+i);
		}
		System.out.println("sendSms()方法结束执行。。。");
	}
}
