package com.sandwich.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.common.CommandMap;
import com.sandwich.admin.dao.OrderAdminDao;
import com.sandwich.admin.service.OrderAdminService;

@Service
public class OrderAdminServiceImpl implements OrderAdminService {
	
	@Autowired
	private OrderAdminDao orderDao;

	

	public List getOrderAdminList(Map param) {
		List orderAdminList = orderDao.getOrderAdminList(param);
		return orderAdminList;
	}



	@Override
	public void orderApproval(int orderNo) {
		
		orderDao.orderApproval(orderNo);
		orderDao.sandwichUpdate(orderNo);
	}



	@Override
	public void orderNoapproval(int orderNo) {
		
		orderDao.orderNoapproval(orderNo);
	}
	
}
