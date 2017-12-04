package com.sandwich.admin.service;

import java.util.List;

import com.sandwich.common.CommandMap;


public interface IngredientService {
	
	void ingredientInsert(CommandMap commandmap);
	
	List ingredientList();
}
