package com.sandwich.admin.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sandwich.admin.dao.IngredientDAO;
import com.sandwich.common.CommandMap;


@Service("ingredientService")
public class IngredientServiceImpl implements IngredientService{
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="ingredientDAO")
	private IngredientDAO ingredientDAO;
		

	public void ingredientInsert(CommandMap commandmap){
		
		if(commandmap.get("SANDWICH_NO")==null) {
		ingredientDAO.ingredientInsert(commandmap);
		}else {
			if(commandmap.get("SANDWICH_THUMBNAIL")==null) {
				commandmap.put("SANDWICH_THUMBNAIL", commandmap.get("ORIGINAL_SANDWICH_THUMBNAIL"));
			}
			ingredientDAO.updateIngredient(commandmap);
		}
	}

	public List ingredientList() {
		
		List list = ingredientDAO.ingredientList();
		
		return list;
	}
	
	public HashMap ingredientModifyForm(int SANDWICH_NO) {
		HashMap ingredient = ingredientDAO.ingredientModifyForm(SANDWICH_NO);
		
		return ingredient;
	}

	public void ingredientDelete(int SANDWICH_NO) {
		ingredientDAO.ingredientDelete(SANDWICH_NO);
	}
} 
