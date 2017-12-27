package com.sandwich.member.dao;

import java.util.HashMap;
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

	@Override
	public void insertBoard(CommandMap board) {
		insert(NAME_SPACE + "insertBoard", board.getMap());
	}

	public HashMap boardModify(int boardNo) {
		HashMap board = (HashMap) update(NAME_SPACE + "boardModify", boardNo);
		return board;
	}

	@Override
	public HashMap getBoard(int boardNo) {
		HashMap board = (HashMap) selectOne(NAME_SPACE + "getBoard", boardNo);
		return board;
	}

	@Override
	public void updateBoard(CommandMap board) {
		update(NAME_SPACE + "boardModify", board.getMap());
	}

	@Override
	public void boardDelete(int boardNo) {
		delete(NAME_SPACE + "boardDelete", boardNo);		
	}


}
