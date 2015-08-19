package com.bit2015.mysite4.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite4.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list = (List<GuestBookVo>)sqlMapClientTemplate.queryForList("guestbook.list");
		return list;
	}	

	public void insert(GuestBookVo vo){
		sqlMapClientTemplate.insert("guestbook.insert", vo);
	}	
	public void delete(String no, String password){
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("password", password);
		map.put("no", no);
		
		sqlMapClientTemplate.delete("guestbook.delete", map);
	}	
}
