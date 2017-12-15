package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sandwich.common.CommandMap;
import com.sandwich.staff.dao.IngredientStaffDAO;


@Service("ingredientStaffService")
public class IngredientStaffServiceImpl implements IngredientStaffService{
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="ingredientStaffDAO")
	private IngredientStaffDAO ingredientStaffDAO;
		

	public void ingredientStaffInsert(CommandMap commandmap){
		
		if(commandmap.get("SANDWICH_NO")==null) {
		ingredientStaffDAO.ingredientStaffInsert(commandmap);
		}else {
			if(commandmap.get("SANDWICH_THUMBNAIL")==null) {
				commandmap.put("SANDWICH_THUMBNAIL", commandmap.get("ORIGINAL_SANDWICH_THUMBNAIL"));
			}
			ingredientStaffDAO.updateStaffIngredient(commandmap);
		}
	}

	public List ingredientStaffList() {
		
		List list = ingredientStaffDAO.ingredientStaffList();
		
		return list;
	}
	
	public HashMap ingredientStaffModifyForm(int SANDWICH_NO) {
		HashMap ingredient = ingredientStaffDAO.ingredientStaffModifyForm(SANDWICH_NO);
		
		return ingredient;
	}

	public void ingredientStaffDelete(int SANDWICH_NO) {
		ingredientStaffDAO.ingredientStaffDelete(SANDWICH_NO);
	}
} 
