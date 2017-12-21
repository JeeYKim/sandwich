package com.sandwich.common.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		Object member_id = request.getSession().getAttribute("MEMBER_ID");
		
		
		if(request.getRequestURI().equals("/sandwich/loginForm.jy")||request.getRequestURI().equals("sandwich/join.jy")) {
			
			if(member_id != null) {
				response.sendRedirect(request.getContextPath()+"/main.jy");
				
				return true;
			}else {
				return true;
			}
		}
		
		if(request.getRequestURI().equals("/sandwich/admin.jy")||request.getRequestURI().equals("/sandwich/ingredientInsertForm.jy")||request.getRequestURI().equals("/sandwich/ingredientInsert.jy")||
				request.getRequestURI().equals("/sandwich/ingredientList.jy")||request.getRequestURI().equals("/sandwich/ingredientView.jy")||request.getRequestURI().equals("/sandwich/ingredientDelete.jy")||
				request.getRequestURI().equals("/sandwich/MoneyList.jy")||request.getRequestURI().equals("/sandwich/MoneyChart.jy")||request.getRequestURI().equals("/sandwich/orderAdminList.jy")||
				request.getRequestURI().equals("/sandwich/orderApproval.jy")||request.getRequestURI().equals("/sandwich/orderNoapproval.jy")||request.getRequestURI().equals("/sandwich/staffMoney.jy")||
				request.getRequestURI().equals("/sandwich/staffMoneyInsert.jy")||request.getRequestURI().equals("/sandwich/staffMoneyDelete.jy")||request.getRequestURI().equals("/sandwich/cost.jy")||
				request.getRequestURI().equals("/sandwich/costInsert.jy")||request.getRequestURI().equals("/sandwich/costDelete.jy")) {
			
			if(member_id == null ) {		
				
				response.sendRedirect(request.getContextPath()+"/loginForm.jy");
				
				return true;
				}
				
				if (Integer.parseInt(String.valueOf(request.getSession().getAttribute("MEMBER_LEVEL"))) == 2){
				
				return true;
			}else {
				response.sendRedirect(request.getContextPath()+"/loginForm.jy");
				
				return true;
			}
		}
		
		if(request.getRequestURI().equals("/sandwich/staff.jy")||request.getRequestURI().equals("/sandwich/ingredientStaffInsertForm.jy")||request.getRequestURI().equals("/sandwich/ingredientStaffInsert.jy")||
				request.getRequestURI().equals("/sandwich/ingredientStaffList.jy")||request.getRequestURI().equals("/sandwich/ingredientStaffView.jy")||
				request.getRequestURI().equals("/sandwich/ingredientStaffDelete.jy")||request.getRequestURI().equals("/sandwich/noticeWriteForm.jy")||
				request.getRequestURI().equals("/sandwich/noticeSave.jy")||request.getRequestURI().equals("/sandwich/noticeList.jy")||request.getRequestURI().equals("/sandwich/noticeView.jy")||
				request.getRequestURI().equals("/sandwich/noticeModifyForm.jy")||request.getRequestURI().equals("/sandwich/noticeDelete.jy")||request.getRequestURI().equals("/sandwich/orderWriteForm.jy")||
				request.getRequestURI().equals("/sandwich/orderSave.jy")||request.getRequestURI().equals("/sandwich/orderList.jy")||request.getRequestURI().equals("/sandwich/orderView.jy")||
				request.getRequestURI().equals("/sandwich/orderModifyForm.jy")||request.getRequestURI().equals("/sandwich/orderDelete.jy")) {
			
			if( member_id == null) {
			
				response.sendRedirect(request.getContextPath()+"/loginForm.jy");
				
				return true;
			}if(Integer.parseInt(String.valueOf(request.getSession().getAttribute("MEMBER_LEVEL"))) == 1) {
				
				
				
				return true;
			}else {
				response.sendRedirect(request.getContextPath()+"/loginForm.jy");
				
				return true;
			}
			
		}
		
		if(request.getRequestURI().equals("/sandwich/mypage.jy")||request.getRequestURI().equals("/sandwich/memberInfo.jy")||request.getRequestURI().equals("/sandwich/meberUpdateForm.jy")||
				request.getRequestURI().equals("/sandwich/memberUpdateAction.jy")||request.getRequestURI().equals("/sandwich/memberDeleteAction.jy")) {
			
			if(member_id == null) {
				response.sendRedirect(request.getContextPath()+"/loginForm.jy");
				
				return true;
			}else {
				
				return true;
			}
		}
		
		return true;
		
	}
	
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		
	}
}
