package com.sandwich.stock.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository
public class StockDao extends AbstractDAO {
	
	//유통기한 리스트
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> dateList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("stock.dateList",map);
	}
	//재고 리스트
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> stockList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("stock.stockList",map);
	}

}
