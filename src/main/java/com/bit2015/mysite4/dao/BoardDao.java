package com.bit2015.mysite4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite4.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public List<BoardVo> getList(){
		List<BoardVo> list = (List<BoardVo>)sqlMapClientTemplate.queryForList("board.list");
		return list;
	}		

	public void write(BoardVo vo){
		sqlMapClientTemplate.insert("board.write", vo);
	}
	
	public BoardVo view(long no){
		BoardVo vo = (BoardVo)sqlMapClientTemplate.queryForObject("board.view", no);
		return vo;
	}
	
	public BoardVo modifyform(long no){
		BoardVo vo = (BoardVo)sqlMapClientTemplate.queryForObject("board.modify", no);
		return vo;
	}
	
	public void modify(BoardVo vo){
		sqlMapClientTemplate.update("board.modify",vo);
	}

	public void delete(long no){
		sqlMapClientTemplate.delete("board.delete",no);
	}
	
	public void count(long no){
		sqlMapClientTemplate.update("board.count",no);
	}
		
	public List<BoardVo> search(String kwd){
		List<BoardVo> list = (List<BoardVo>)sqlMapClientTemplate.queryForList("board.search");
		return list;
	}

	public void dap(BoardVo vo) {
		sqlMapClientTemplate.insert("board.dap2", vo);
	}
	
}
