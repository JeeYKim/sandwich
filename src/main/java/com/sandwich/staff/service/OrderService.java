package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;

public interface OrderService {
	
	void saveOrder(CommandMap notice);

	List getOrderList(Map param);
	
	HashMap getOrder(int orderNo);

	void orderDelete(int orderNo);

	List getSandwich();

}
