package com.bit2015.mysite4.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite4.dao.UserDao;
import com.bit2015.mysite4.service.UserService;
import com.bit2015.mysite4.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	UserVo userVo;
	UserDao userDao;
	
	@RequestMapping("/joinform")
	public String joinform(){
		return "user/joinform";
	}
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo){
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping("/joinsuccess")
	public String joinsuccess(){
		return "user/joinsuccess";
	}
	@RequestMapping("/loginform")
	public String loginform(){
		return "user/loginform";
	}
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo){
		UserVo vo = userService.login(userVo);
		if(vo == null){
			return "redirect:/user/loginform";
		}
		//로긴처리
		session.setAttribute("authUser", vo);
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, @ModelAttribute UserVo userVo){
		session.removeAttribute( "authUser" );
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping("/modifyform")
	public String modifyform(){
		return "user/modifyform";
	}
	@RequestMapping("/modify")
	public String modify(@ModelAttribute UserVo userVo){
		userService.modify(userVo);
		return "redirect:/user/modifysuccess";
	}
	@RequestMapping("/modifysuccess")
	public String modifysuccess(){
		return "user/modifysuccess";
	}
	
	@RequestMapping("/checkemail")
	@ResponseBody
	public Object checkemail(String email){
		UserVo userVo = null;
		
		//UserVo userVo = userService.getUser(email)
		Map<String, String> map = new HashMap<String, String>();
		
		if (userVo == null){
			map.put("result","not exist");
		}else{
			map.put("result","exist");
		}
		return map;
	}
	
}
