package online.shixun.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.UserMapper;
import online.shixun.project.pojo.User;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;

	public boolean getUser(User user) {
		User user1 =  userMapper.getUser(user);
		if(user1!=null) {
			return true;
		}else {
			return false;
		}
	}
	

}
