package com.sandwich.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;

public interface CostService {

	void costInsert(CommandMap commandmap);
	
	@SuppressWarnings("rawtypes")
	List getCost();

	void costDelete(int COST_NO);
}
