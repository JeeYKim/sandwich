package com.sandwich.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.common.CommandMap;
import com.sandwich.member.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	public List getBoardList(Map param) {
		List boardList = boardDao.getBoardList(param);
		return boardList;

	}

	@Override
	public void saveBoard(CommandMap board) {
		if(board	.get("boardNo") == null) {
			boardDao.insertBoard(board);
		} else {
			boardDao.updateBoard(board);
		}
	}

	@Override
	public HashMap getBoard(int boardNo) {
		HashMap board = boardDao.getBoard(boardNo);
		return board;
	}

	@Override
	public void boardDelete(int boardNo) {
		boardDao.boardDelete(boardNo);
	}
}
