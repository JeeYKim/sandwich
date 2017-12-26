package com.sandwich.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sandwich.admin.dao.StaffMoneyDAO;
import com.sandwich.common.CommandMap;

@Service("staffMoneyService")
public class StaffMoneyServiceImpl implements StaffMoneyService{


	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "staffMoneyDAO")
	private StaffMoneyDAO staffMoneyDAO;
	
	public void staffMoneyInsert(CommandMap commandmap) {
		
		staffMoneyDAO.staffMoneyInsert(commandmap);
	}
	
	@SuppressWarnings("rawtypes")
	public List getStaffMoney() {
		
		List staffMoneyList = staffMoneyDAO.getStaffMoney();
		
		return staffMoneyList;
	}
	
	@SuppressWarnings("rawtypes")
	public List getStaffId(){
		
		List staffId = staffMoneyDAO.getStaffId();
		
		return staffId;
	}
	
	public void staffMoneyDelete(int STAFF_NO) {
		
		staffMoneyDAO.staffMoneyDelete(STAFF_NO);
	}
}
