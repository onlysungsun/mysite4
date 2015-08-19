package com.bit2015.mysite4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite4.dao.UserDao;
import com.bit2015.mysite4.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void join(UserVo userVo){
		userDao.insert(userVo);
	}
	
	public UserVo login(UserVo userVo){
		UserVo vo = userDao.get(userVo.getEmail(), userVo.getPassword());
		return vo;	
	}
	public void modify(UserVo userVo){
		userDao.modify(userVo);
	}
		

}
