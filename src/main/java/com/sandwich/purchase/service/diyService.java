package com.sandwich.purchase.service;

import java.util.List;
import java.util.Map;

public interface diyService {
   
   List<Map<String, Object>> selectAll();
   
   Map<String, Object> selectOne(int no);
   
   Map<String, Object> selectIngre(int SANDWICH_NO);

}