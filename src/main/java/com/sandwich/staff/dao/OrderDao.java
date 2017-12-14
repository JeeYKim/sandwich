package com.sandwich.staff.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

public interface OrderDao {
	String NAME_SPACE = "sandwich.order.";
	
	void insertOrder(CommandMap order);
	
	void updateOrder(CommandMap order);
	
	List getOrderList(Map param);
	
	
	HashMap getOrder(int orderNo);

	void orderDelete(int orderNo);

	List getSandwich();

	

}
