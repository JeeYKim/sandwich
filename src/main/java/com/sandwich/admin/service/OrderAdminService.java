package com.sandwich.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;

public interface OrderAdminService {
	

	List getOrderAdminList(Map param);
	/**
	 * 주문 승인
	 * @param orderNo 
	 */
	void orderApproval(int orderNo);
	
	/**
	 * 주문  비승인 
	 * @param orderNo 
	 */
	
	void orderNoapproval(int orderNo);
	



}