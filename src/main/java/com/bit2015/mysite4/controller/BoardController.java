package com.bit2015.mysite4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.mysite4.dao.BoardDao;
import com.bit2015.mysite4.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	BoardVo boardVo;

	@RequestMapping()
	public String list(Model model){
		List<BoardVo> list = boardDao.getList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@RequestMapping("/writeform")
	public String writeform(){
		return "board/write";
	}
	
	@RequestMapping("/write")
	public String write(@ModelAttribute BoardVo boardVo){
		boardDao.write(boardVo);
		return "redirect:/board";	
	}
	
	@RequestMapping("/view/{no}")
	public String view(@PathVariable("no") long no, Model model){
		model.addAttribute("board", boardDao.view(no));
		boardDao.count(no);
		return "board/view";
	}
	
	@RequestMapping("/modifyform/{no}")
	public String modifyform(@PathVariable("no") long no, Model model){
		model.addAttribute("board", boardDao.view(no));
		return "board/modify";
	}
	
	@RequestMapping("/modify/{no}")
	public String modify(@ModelAttribute BoardVo boardVo){
		boardDao.modify(boardVo);
		return "redirect:/board";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable ("no") long no){
		boardDao.delete(no);
		return "redirect:/board";
	}
	
	@RequestMapping("/search")
	public String search(@PathVariable("kwd") String kwd, Model model){
		List<BoardVo> list = boardDao.search(kwd);
		System.out.println("111");
		model.addAttribute("list", list);		
		return "redirect:/board";
	}
	
	@RequestMapping("/write_dap")
	public String write_dap(@ModelAttribute BoardVo boardVo){
		return "board/write_dap";			
	}
	@RequestMapping("/dap")
	public String dap(@ModelAttribute BoardVo boardVo){
		boardDao.dap(boardVo);
		return "redirect:/board";			
	}	
}