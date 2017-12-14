
package com.sandwich.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

public interface OrderAdminDao {
	
	
	String NAME_SPACE = "sandwich.order.";
	
	List getOrderAdminList(Map param);

	void orderApproval(int orderNo);

	void orderNoapproval(int orderNo);
	
	/**
	 * 샌드위치 수량 업데이트
	 * @param orderNo
	 */
	
	void sandwichUpdate(int orderNo);

}
