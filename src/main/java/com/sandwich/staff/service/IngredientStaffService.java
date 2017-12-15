package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;

import com.sandwich.common.CommandMap;


public interface IngredientStaffService {
	
	void ingredientStaffInsert(CommandMap commandmap);
	
	List ingredientStaffList();
	
	HashMap ingredientStaffModifyForm(int SANDWICH_NO);
	
	void ingredientStaffDelete(int SANDWICH_NO);
}
