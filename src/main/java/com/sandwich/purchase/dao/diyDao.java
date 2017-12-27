package com.sandwich.purchase.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository
public class diyDao extends AbstractDAO {
   
   public List<Map<String, Object>> selectAll() {
      return selectList("diy.selectAll");   
   }
   
   public Map<String,Object> selectOne(int no){
      return (Map<String, Object>) selectOne("diy.selectOne", no);
   }
   
   public Map<String, Object> selectIngre(int SANDWICH_NO){
      return (Map<String, Object>) selectOne("diy.selectIngre", SANDWICH_NO);
   }
   
   public Map<String, Object> countfind3(String SANDWICH_SMALLTYPE){
      return (Map<String, Object>) selectOne("diy.countfind3",SANDWICH_SMALLTYPE);
   }
   
   public Map<String, Object> countfind4(String SANDWICH_SMALLTYPE){
      return (Map<String, Object>) selectOne("diy.countfind4",SANDWICH_SMALLTYPE);
   }
   
   public void updateAmount(Map map) {
	   update("diy.updateAmount", map);
   }

   public void goPurchase(Map<String, Object> map) {
		insert("diy.goPurchase", map);
	
}

   public void plusPurchasNo(Map map) {
    update("diy.plusPurchasNo", map);
 }
   @SuppressWarnings("unchecked")
public List<Map<String, Object>> purchaseList(){
	   return (List<Map<String, Object>>) selectList("diy.purchaseList");
   }
   
   
   
   

}