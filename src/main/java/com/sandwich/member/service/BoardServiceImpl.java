package com.sandwich.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.member.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	public List getBoardList(Map param) {
		List boardList = boardDao.getBoardList(param);
		return boardList;

	}
}
