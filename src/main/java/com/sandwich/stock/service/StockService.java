package com.sandwich.stock.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface StockService {

	//유통기한 리스트
	public List<Map<String,Object>> dateList(Map<String,Object>map)throws Exception;
	//재고리스트
	public List<Map<String,Object>> stockList(Map<String,Object>map)throws Exception;
}