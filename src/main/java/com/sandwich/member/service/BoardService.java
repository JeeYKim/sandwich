package com.sandwich.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;

public interface BoardService {

	List getBoardList(Map param);

	void saveBoard(CommandMap board);

	HashMap getBoard(int boardNo);

}
