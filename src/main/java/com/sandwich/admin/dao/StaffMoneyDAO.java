package com.sandwich.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

@Repository("staffMoneyDAO")
public class StaffMoneyDAO extends AbstractDAO{

	public void staffMoneyInsert(CommandMap commandmap) {
		insert("cost.insertStaffMoney", commandmap.getMap());
	}
	
	@SuppressWarnings("rawtypes")
	public List getStaffMoney() {
		
		List staffMoneyList = selectList("cost.staffMoneyList");
		
		return staffMoneyList;
	}
	
	@SuppressWarnings("rawtypes")
	public List getStaffId() {
		
		List staffId = selectList("cost.staffId");
		
		return staffId;
	}
	public void staffMoneyDelete(int STAFF_NO) {
		
		delete("cost.deleteStaffMoney", STAFF_NO);
	}
}
