package com.sandwich.admin.service;

import java.util.List;

import com.sandwich.common.CommandMap;

public interface StaffMoneyService {

	void staffMoneyInsert(CommandMap commandmap);
	
	@SuppressWarnings("rawtypes")
	List getStaffMoney();

	@SuppressWarnings("rawtypes")
	List getStaffId();
	
	void staffMoneyDelete(int STAFF_NO);
}
