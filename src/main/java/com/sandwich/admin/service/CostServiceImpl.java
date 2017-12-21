package com.sandwich.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sandwich.admin.dao.CostDAO;
import com.sandwich.common.CommandMap;

@Service("costService")
public class CostServiceImpl implements CostService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "costDAO")
	private CostDAO costDAO;
	
	public void costInsert(CommandMap commandmap) {
		
		costDAO.costInsert(commandmap);
	}
	
	@SuppressWarnings("rawtypes")
	public List getCost() {
		
		List cost = costDAO.getCost();
		
		return cost;
	}
	
	public void costDelete(int COST_NO) {
		costDAO.costDelete(COST_NO);
	}
}
