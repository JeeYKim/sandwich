package com.sandwich.admin.service;

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
		}
	}

	public List ingredientList() {
		
		List list = ingredientDAO.ingredientList();
		
		return list;
	}


} 
