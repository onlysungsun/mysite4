package com.bit2015.mysite4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.mysite4.dao.GuestBookDao;
import com.bit2015.mysite4.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	private GuestBookDao guestBookDao;
	GuestBookVo guestBookVo;

	@RequestMapping()
	public String list(Model model){
		List<GuestBookVo> list = guestBookDao.getList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}	

	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestBookVo guestBookVo){
		guestBookDao.insert(guestBookVo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable ("no") long no, Model model){
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping("/delete{no}")
	public String delete(@PathVariable ("no") String no, String password){

		guestBookDao.delete(no, password);
		return "redirect:/guestbook";
	}
}
