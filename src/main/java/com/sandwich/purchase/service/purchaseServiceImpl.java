package com.sandwich.purchase.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import com.sandwich.common.CommandMap;
import com.sandwich.purchase.dao.purchaseDAO;

@Service
public class purchaseServiceImpl implements purchaseService {
   Logger logger = Logger.getLogger(this.getClass());
   
   @Resource 
   private purchaseDAO purchaseDAO; 
   
   public Map<String, Object> countfind(String PURCHASE_SMALLTYPE) throws Exception {
      // TODO Auto-generated method stub
      
      return purchaseDAO.countfind(PURCHASE_SMALLTYPE);  
   }
   
   public Map<String, Object> countfind2(String PURCHASE_SMALLTYPE) throws Exception {
      // TODO Auto-generated method stub
      
      return purchaseDAO.countfind(PURCHASE_SMALLTYPE); 
   }
   
   public List<Map<String, Object>> basketListOne(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      
      return purchaseDAO.basketListOne(map);
   }

   public List<Map<String, Object>> selectPurchaseList(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      return purchaseDAO.selectPurchaseList(map);
   }
   
   public List<Map<String, Object>> myselectPurchaseOne(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      
      return purchaseDAO.myselectPurchaseOne(map); 
   }

   public List<Map<String, Object>> myselectPurchaseList(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      return purchaseDAO.myselectPurchaseList(map);
   }

   public List<Map<String, Object>> selectPurchaseOne(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      
      
      return purchaseDAO.selectPurchaseOne(map);
   }
    
   public List<Map<String, Object>> endDateOver(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      return purchaseDAO.endDateOver(map);
   }

   public List<Map<String, Object>> selectBasketList(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      return purchaseDAO.selectBasketList(map);
   }

   public void insertPurchase(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      purchaseDAO.insertPurchase(map);
   }

   public void insertBasket(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      purchaseDAO.insertBasket(map); 
   }

   public void PurchaseSeqCount(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      purchaseDAO.PurchaseSeqCount(map);
   }

   //장바구니 주문
   public void basketAsPurchase(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      purchaseDAO.basketAsPurchase(map);
   } 

   //주문 들어온거 수 뺴기
   public void countSubPurchase(Map<String, Object> List2) throws Exception {
      // TODO Auto-generated method stub 
      purchaseDAO.countSubPurchase(List2);
   }

   //유통기한 지난거 폐기로
   public void sandDataOverAsGarbage(List<Map<String, Object>> check) throws Exception { 
      purchaseDAO.sandDataOverAsGarbage(check);
      
   }
   
   
   //재고 유통기한 지난거 삭제
   public void sandDataOver(List<Map<String, Object>> map) throws Exception {
      // TODO Auto-generated method stub
      purchaseDAO.sandDataOver(map);
   }

   //재고 0 인거 삭제
   public void sandwichPurchase(Map<String, Object> map) throws Exception {
      // TODO Auto-generated method stub
      purchaseDAO.sandwichPurchase(map);
   }
   
   



   
   
}