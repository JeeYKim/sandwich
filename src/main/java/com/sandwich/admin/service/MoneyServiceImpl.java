package com.sandwich.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sandwich.admin.dao.MoneyDAO;

@Service("moneyService")
public class MoneyServiceImpl implements MoneyService{

	@Resource(name="moneyDAO")
	private MoneyDAO moneyDAO;

	public List getMoneyList(Map DATE) {
		
		List moneyList = moneyDAO.getMoneyList(DATE);
		
		return moneyList;
	}
	
}
