package com.sandwich.member.dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	
	String NAME_SPACE = "sandwich.board.";
	
	List getBoardList(Map param);

}
