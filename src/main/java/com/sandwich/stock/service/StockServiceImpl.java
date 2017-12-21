package com.sandwich.stock.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sandwich.stock.dao.StockDao;

@Service

public class StockServiceImpl implements StockService{
	
	@Resource
	private StockDao stockDao;
	
	
	@Override
	public List<Map<String, Object>> dateList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return stockDao.dateList(map);
	}

	@Override
	public List<Map<String, Object>> stockList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return stockDao.stockList(map);
	}

}
