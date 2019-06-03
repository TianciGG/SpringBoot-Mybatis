package chauncy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import chauncy.entity.UserEntity;
import chauncy.mapper.UserMapper;
import chauncy.service.UserService;
import chauncy.test01.mapper.UserMapper1;
import chauncy.test01.service.UserService1;
import chauncy.test02.service.UserService2;

@RestController
@RequestMapping("/IndexController")
public class IndexController {
	
	private static Logger logger = Logger.getLogger(IndexController.class);

	@Autowired
	private UserService1 userService1;

	@Autowired
	private UserService2 userService2;
	
	@Autowired
	private UserMapper1 userMapper1;
	
	@Autowired
	private CacheManager cacheManager;

	/*@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/getUserName")
	public UserEntity getUserName(String name) {
		return userMapper.findUser(name);
	}

	@ResponseBody
	@RequestMapping("/insertUser")
	public String insertUser(String name, Integer age) {
		userService.addUser(name, age);
		return "sucess";
	}*/
	
	@RequestMapping("/add")
	public String add(String name, Integer age) {
		userService1.addUser(name, age);
		userService2.addUser(name, age);
		return "success";
	}
	
	@RequestMapping("/addUser1AndUser2")
	public String addUser1AndUser2(){
		userService1.addUser1AndUser2();
		return "success";
	}
	
	@RequestMapping("/log")
	public String log(){
		logger.info("test log");
		return "success";
	}
	
	@RequestMapping("/addUserName")
	public String addUserName(String name){
		return "success";
	}
	
	@RequestMapping("/getUserName")
	public UserEntity getUserName(String name){
		return userMapper1.findByUserName(name);
	}
	
	@RequestMapping("/removeCache")
	public String removeCache() {
		cacheManager.getCache("baseCache").clear();
		return "success";
	}
	
	@RequestMapping("/sendSms")
	public String sendSms(){
		System.out.println("userService1->sendSms()开始调用");
		userService1.sendSms();
		System.out.println("userService1->sendSms()结束调用");
		return "success";
	}
}
