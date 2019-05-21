package chauncy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chauncy.mapper.UserMapper;
import chauncy.service.UserService;

@Service
public class UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public int addUser(String name, Integer age) {
		int insertUserFlag = userMapper.insertUser(name, age);
		int i=1/0;
		return insertUserFlag;
	}
}
