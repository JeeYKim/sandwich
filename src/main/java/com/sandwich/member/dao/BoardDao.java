package com.sandwich.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;

public interface BoardDao {
	
	String NAME_SPACE = "sandwich.board.";
	
	List getBoardList(Map param);

	void insertBoard(CommandMap board);

	void updateBoard(CommandMap board);

	HashMap getBoard(int boardNo);

	void boardDelete(int boardNo);

}
