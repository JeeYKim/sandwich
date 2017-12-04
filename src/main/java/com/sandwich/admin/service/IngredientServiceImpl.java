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
		
		if(commandmap.get("SANDWITCH_NO")==null) {
		ingredientDAO.ingredientInsert(commandmap);
		}else {
			if(commandmap.get("SANDWITCH_THUMBNAIL")==null) {
				commandmap.put("SANDWITCH_THUMBNAIL", commandmap.get("ORIGINAL_SANDWITCH_THUMBNAIL"));
			}
			ingredientDAO.updateIngredient(commandmap);
		}
	}

	public List ingredientList() {
		
		List list = ingredientDAO.ingredientList();
		
		return list;
	}
	
	public HashMap ingredientModifyForm(int SANDWITCH_NO) {
		HashMap ingredient = ingredientDAO.ingredientModifyForm(SANDWITCH_NO);
		
		return ingredient;
	}

	public void ingredientDelete(int SANDWITCH_NO) {
		ingredientDAO.ingredientDelete(SANDWITCH_NO);
	}
} 
