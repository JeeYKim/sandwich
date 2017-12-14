package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.common.CommandMap;
import com.sandwich.staff.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	public void saveOrder(CommandMap order) {
		int totalPrice = Integer.valueOf((String) order.get("orderPrice")) * 
					Integer.valueOf((String) order.get("orderAmount"));
		
		order.put("totalPrice", totalPrice);
		
		if(order.get("orderNo") == null) {
			orderDao.insertOrder(order);
		} else {
			orderDao.updateOrder(order);
		}
	}

	public List getOrderList(Map param) {
		List orderList = orderDao.getOrderList(param);
		return orderList;
	}
	
	public HashMap getOrder(int orderNo) {
		HashMap order = orderDao.getOrder(orderNo);
		
		return order;
	}
	
	public void orderDelete(int orderNo){
		orderDao.orderDelete(orderNo);
	}

	@Override
	public List getSandwich() {
		List result = orderDao.getSandwich();
		
		return result;
	}
	
}
