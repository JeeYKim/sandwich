package com.sandwich.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;


@Repository("ingredientDAO")
public class IngredientDAO extends AbstractDAO{
	
	public void ingredientInsert(CommandMap commandmap) {
		insert("ingredient.insertIngredient", commandmap.getMap());
	}
	
	public List ingredientList() {
		List ingredientList = selectList("ingredient.listIngredient");
		
		return ingredientList;
	}
	
	public HashMap ingredientModifyForm(int SANDWITCH_NO) {
		
		HashMap ingredient = (HashMap) selectOne("ingredient.viewIngredient", SANDWITCH_NO);
		
		return ingredient;
	}
	
	public void ingredientDelete(int SANDWITCH_NO) {
		
		delete("ingredient.deleteIngredient", SANDWITCH_NO);
	}
	public void updateIngredient(CommandMap commandmap) {
		update("ingredient.updateIngredient", commandmap.getMap());
	}
}

