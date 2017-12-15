package com.sandwich.purchase.service;

import java.util.List;
import java.util.Map;


public interface purchaseService {
	//주문 내역 리스트
	List<Map<String, Object>> selectPurchaseList(Map<String, Object> commandMap)throws Exception;
	//주문 내역 1개 보기
	List<Map<String, Object>> selectPurchaseOne(Map<String, Object> map)throws Exception;
	//나의 주문 내역 리스트
	List<Map<String, Object>> myselectPurchaseList(Map<String, Object> commandMap)throws Exception;
	//나의 주문 내역 1개 보기
	List<Map<String, Object>> myselectPurchaseOne(Map<String, Object> map)throws Exception;
	// 장바구니 내역
	List<Map<String, Object>> selectBasketList(Map<String, Object> map)throws Exception;
	//장바구니 내역 1개 보기
	List<Map<String, Object>> basketListOne(Map<String, Object> map)throws Exception;
	 
	List<Map<String, Object>> countfind(String PURCHASE_SMALLTYPE) throws Exception;
	 
	List<Map<String, Object>> countfind2(String PURCHASE_SMALLTYPE) throws Exception;	
	
	List<Map<String, Object>> endDateOver(Map<String, Object> map) throws Exception;	
	//주문 조지기 
	void insertPurchase(Map<String, Object> map) throws Exception;
	
	//폐기 처리
	void sandDataOverAsGarbage(List<Map<String, Object>> check) throws Exception;
	
	// 장바구니 넣기
	void insertBasket(Map<String, Object> map) throws Exception;
	
	// 주문 시퀀스 하나 올리기
	void PurchaseSeqCount(Map<String, Object> map)throws Exception;
	
	// 장바구니 있는거 주문 조지기
	void basketAsPurchase(Map<String, Object>map) throws Exception;
	
	//주문시 제고에서 갯수 조지기
	void countSubPurchase(List<Map<String, Object>> list4) throws Exception;
	//재고 유통기한 지난거 삭제
	void sandDataOver(List<Map<String, Object>> check) throws Exception;
}
