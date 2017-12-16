package com.sandwich.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository("moneyDAO")
public class MoneyDAO extends AbstractDAO{
	
	@SuppressWarnings("rawtypes")
	public List getMoneyList(Map DATE) {
				

		List moneyList = selectList("money.Money", DATE);
		
		
		return moneyList;
	}
	
	@SuppressWarnings("rawtypes")
	public List getMoney(Map DATE) {
		
		List money = selectList("money.MoneyList", DATE);
		
		return money;
	}


}
