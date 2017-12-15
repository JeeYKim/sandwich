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
   
   

}