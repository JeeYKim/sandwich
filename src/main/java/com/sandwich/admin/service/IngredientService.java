package com.sandwich.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;


public interface IngredientService {
	
	void ingredientInsert(CommandMap commandmap);
	
	List ingredientList();
	
	HashMap ingredientModifyForm(int SANDWICH_NO);
	
	void ingredientDelete(int SANDWICH_NO);
	
	List<Map<String, Object>> garbageList(); 
}
