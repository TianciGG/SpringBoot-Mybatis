package chauncy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chauncy.entity.UserEntity;
import chauncy.mapper.UserMapper;

@Controller
@RequestMapping("/IndexController")
public class IndexController {

	@Autowired
	private UserMapper userMapper;

	@ResponseBody
	@RequestMapping("/getUserName")
	public UserEntity getUserName(String name) {
		return userMapper.findUser(name);

	}
}
