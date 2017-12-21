package com.sandwich.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

@Repository("costDAO")
public class CostDAO extends AbstractDAO{

	public void costInsert(CommandMap commandmap) {
		insert("cost.insertCost", commandmap.getMap());
	}
	
	public List getCost() {
		
		List costList = selectList("cost.CostList");
		
		return costList;
	}
	public void costDelete(int COST_NO) {
		
		delete("cost.deleteCost", COST_NO);
	}
	
	
}
