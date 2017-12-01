package com.sandwich.admin.dao;

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
}

