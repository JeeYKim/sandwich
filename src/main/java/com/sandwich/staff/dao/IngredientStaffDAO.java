package com.sandwich.staff.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;


@Repository("ingredientStaffDAO")
public class IngredientStaffDAO extends AbstractDAO{
	
	public void ingredientStaffInsert(CommandMap commandmap) {
		insert("ingredient.insertIngredient", commandmap.getMap());
	}
	
	public List ingredientStaffList() {
		List ingredientList = selectList("ingredient.listIngredient");
		
		return ingredientList;
	}
	
	public HashMap ingredientStaffModifyForm(int SANDWICH_NO) {
		
		HashMap ingredient = (HashMap) selectOne("ingredient.viewIngredient", SANDWICH_NO);
		
		return ingredient;
	}
	
	public void ingredientStaffDelete(int SANDWICH_NO) {
		
		delete("ingredient.deleteIngredient", SANDWICH_NO);
	}
	public void updateStaffIngredient(CommandMap commandmap) {
		update("ingredient.updateIngredient", commandmap.getMap());
	}
}

