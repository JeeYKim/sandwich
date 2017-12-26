package com.sandwich.purchase.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sandwich.purchase.dao.diyDao;

@Service
public class diyServiceImpl implements diyService{
   
   @Resource
   private diyDao dao;

   public List<Map<String, Object>> selectAll() {
      
      return dao.selectAll();
   }

   public Map<String, Object> selectOne(int no) {
      
      return dao.selectOne(no);
   }

public Map<String, Object> selectIngre(int SANDWICH_NO) {
	
	return dao.selectIngre(SANDWICH_NO);
}

@Override
public Map<String, Object> countfind3(String SANDWICH_SMALLTYPE) {
   
   return dao.countfind3(SANDWICH_SMALLTYPE);
}


@Override
public Map<String, Object> countfind4(String SANDWICH_SMALLTYPE) {
   // TODO Auto-generated method stub
   return dao.countfind4(SANDWICH_SMALLTYPE);
}

@Override
public void updateAmount(String sandwich_no, int leftAmount) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("SANDWICH_NO", sandwich_no);
	map.put("SANDWICH_AMOUNT", leftAmount);
	dao.updateAmount(map);
	
}

@Override
public void goPurchase(Map<String, Object> map) {
	dao.goPurchase(map);
	
}

@Override
public void plusPurchasNo(Map map) {
	dao.plusPurchasNo(map);
}


   
   
   
   

}