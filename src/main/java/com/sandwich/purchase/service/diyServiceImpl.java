package com.sandwich.purchase.service;

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
      dao.selectAll();
      return null;
   }

   public Map<String, Object> selectOne(int no) {
      dao.selectOne(no);
      return null;
   }
   
   
   
   

}