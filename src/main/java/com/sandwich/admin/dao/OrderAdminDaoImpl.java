package com.sandwich.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

@Repository
public class OrderAdminDaoImpl extends AbstractDAO implements OrderAdminDao {

	public List getOrderAdminList(Map param) {
		List orderAdminList = selectList(NAME_SPACE + "getOrderList", param);
		
		return orderAdminList;
	}

	@Override
	public void orderApproval(int orderNo) {
		//orderApproval 
		update(NAME_SPACE + "orderApproval", orderNo);
		
	}

	@Override
	public void orderNoapproval(int orderNo) {
		
		update(NAME_SPACE + "orderNoapproval", orderNo);
	}

	@Override
	public void sandwichUpdate(int orderNo) {
		update(NAME_SPACE + "sandwichUpdate", orderNo);
	}
	

	
	
	
}
