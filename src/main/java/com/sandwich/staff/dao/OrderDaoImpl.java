package com.sandwich.staff.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

@Repository
public class OrderDaoImpl extends AbstractDAO implements OrderDao {

	public void insertOrder(CommandMap order) {
		insert(NAME_SPACE + "insertOrder", order.getMap());
	}

	public List getOrderList(Map param) {
		List orderList = selectList(NAME_SPACE + "getOrderList", param);
		
		return orderList;
	}
	
	public HashMap getOrder(int orderNo) {
		HashMap order = (HashMap) selectOne(NAME_SPACE + "getOrder", orderNo);
		return order;
	}
	
	public HashMap orderModify(int orderNo) {
		HashMap order = (HashMap) update(NAME_SPACE + "orderModify", orderNo);
		return order;
	}
	
	public void updateOrder(CommandMap order){
		update(NAME_SPACE + "orderModify", order.getMap());
		
	}
	
	public void orderDelete(int orderNo){
		delete(NAME_SPACE + "orderDelete", orderNo);
	}

	@Override
	public List getSandwich() {
		List result = selectList(NAME_SPACE + "getSandwich");
		
		return result;
	}
	
}
