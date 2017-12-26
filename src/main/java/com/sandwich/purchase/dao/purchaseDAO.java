package com.sandwich.purchase.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository
public class purchaseDAO extends AbstractDAO {


       
      @SuppressWarnings("unchecked")
      public List<Map<String, Object>> selectPurchaseList(Map<String, Object> map) throws Exception{
          return (List<Map<String, Object>>)selectList("purchase.selectPurchaseList", map);
      }
      
      @SuppressWarnings("unchecked") 
      public List<Map<String, Object>> selectPurchaseOne(Map<String, Object> map) throws Exception{
          return (List<Map<String, Object>>)selectList("purchase.selectPurchaseOne", map);
      }
      @SuppressWarnings("unchecked")
      public List<Map<String, Object>> myselectPurchaseList(Map<String, Object> map) throws Exception{
          return (List<Map<String, Object>>)selectList("purchase.myselectPurchaseList", map);
      }
      
      @SuppressWarnings("unchecked") 
      public List<Map<String, Object>> myselectPurchaseOne(Map<String, Object> map) throws Exception{
          return (List<Map<String, Object>>)selectList("purchase.myselectPurchaseOne", map);
      }
   
      @SuppressWarnings("unchecked")
      public List<Map<String, Object>> selectBasketList(Map<String, Object> map) throws Exception{
          return (List<Map<String, Object>>)selectList("purchase.selectBasketList", map);
      }
      
      @SuppressWarnings("unchecked") 
      public List<Map<String, Object>> basketListOne(Map<String, Object> map) throws Exception{
          return (List<Map<String, Object>>)selectList("purchase.basketListOne", map);
      }
      
      @SuppressWarnings("unchecked")
      public Map<String, Object> countfind(String PURCHASE_SMALLTYPE) {
         // TODO Auto-generated method stub
         return (Map<String, Object>) selectOne("purchase.countfind", PURCHASE_SMALLTYPE);
      }

      
      @SuppressWarnings("unchecked")
      public Map<String, Object> countfind2(Map<String, Object> map) {
         // TODO Auto-generated method stub
         return (Map<String, Object>) selectOne("purchase.countfind2");
      }         
      
      @SuppressWarnings("unchecked")
      public List<Map<String, Object>> endDateOver(Map<String, Object> map) {
         // TODO Auto-generated method stub
         return (List<Map<String, Object>>) selectList("purchase.endDateOver");
      }
      
      public void insertPurchase(Map<String, Object> map)throws Exception{
         insert("purchase.insertPurchase", map);
      }
      
      public void insertBasket(Map<String, Object> map)throws Exception{
         insert("purchase.insertBasket", map);
      }
      
      public void sandDataOverAsGarbage(List<Map<String, Object>> check)throws Exception{
         insert("purchase.sandDataOverAsGarbage", check);
      }
      
      public void PurchaseSeqCount(Map<String, Object> map)throws Exception{
         update("purchase.PurchaseSeqCount", map);
      }
      
      public void basketAsPurchase(Map<String, Object> map)throws Exception{
         update("purchase.basketAsPurchase", map);
      }
      
      public void countSubPurchase(Map<String, Object> list2)throws Exception{  
         update("purchase.countSubPurchase", list2);
      }
      
      public void sandDataOver(List<Map<String, Object>> map)throws Exception{
         delete("purchase.sandDataOver", map);
      }
      
      public void sandwichPurchase(Map<String, Object> map)throws Exception{
         update("purchase.sandwichPurchase", map);
      }      
      
      

   
      
      
}