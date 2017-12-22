package com.sandwich.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;
import com.sandwich.common.CommandMap;

@Repository
public class BoardDaoImpl extends AbstractDAO implements BoardDao  {
	
	
	public List getBoardList(Map param) {
		List boardList = selectList(NAME_SPACE + "getBoardList", param);
		
		return boardList;
	}

}
