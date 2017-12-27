package com.sandwich.purchase.service;

import java.util.List;
import java.util.Map;

public interface diyService {
   
   List<Map<String, Object>> selectAll();
   
   Map<String, Object> selectOne(int no);
   
   Map<String, Object> selectIngre(int SANDWICH_NO);
   
   Map<String, Object> countfind3(String SANDWICH_SMALLTYPE);
   
   Map<String, Object> countfind4(String SANDWICH_SMALLTYPE);
   
   void updateAmount(String SANWICH_NO, int leftAmount);

   void goPurchase(Map<String, Object> map);

   void plusPurchasNo(Map map);
   
   List<Map<String, Object>> purchaseList();

}