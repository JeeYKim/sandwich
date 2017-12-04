package com.sandwich.admin.service;

import java.util.HashMap;
import java.util.List;

import com.sandwich.common.CommandMap;


public interface IngredientService {
	
	void ingredientInsert(CommandMap commandmap);
	
	List ingredientList();
	
	HashMap ingredientModifyForm(int SANDWITCH_NO);
	
	void ingredientDelete(int SANDWITCH_NO);
}
