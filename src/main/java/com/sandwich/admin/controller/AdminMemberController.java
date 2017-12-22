package com.sandwich.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.Paging;
import com.sandwich.common.CommandMap;
import com.sandwich.admin.service.AdminMemberService;

@Controller
public class AdminMemberController {

	private int searchNum;

	private String isSearch;

	// 페이징
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	private String pagingHtml;
	private Paging page;

	@Resource(name = "AdminMemberService")
	private AdminMemberService AdminMemberService;

	
	@RequestMapping(value = "/adminMember.jy")
	public ModelAndView openMemberList(CommandMap commandMap, HttpServletRequest request) throws Exception {

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		ModelAndView mv = new ModelAndView();

		List<Map<String, Object>> adminMember = AdminMemberService.selectMemberList(commandMap.getMap());

		isSearch = request.getParameter("isSearch");

		if (isSearch != null) {

			searchNum = Integer.parseInt(request.getParameter("searchNum"));

			System.out.println("getMap : " + commandMap.getMap());
			System.out.println("검색 :>>>>>>>" + commandMap.get(isSearch));

			if (searchNum == 0) { // 아이디
				adminMember = AdminMemberService.searchMemberId(commandMap.getMap());
			} else if (searchNum == 1) { // 이름
				adminMember = AdminMemberService.searchMemberName(commandMap.getMap());
			} else if (searchNum == 2) { // 이메일
				adminMember = AdminMemberService.searchMemberEMAIL(commandMap.getMap());
			}

			totalCount = adminMember.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminMember", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			adminMember = adminMember.subList(page.getStartCount(), lastCount);

			mv.addObject("isSearch", isSearch);
			mv.addObject("searchNum", searchNum);
			mv.addObject("totalCount", totalCount);
			mv.addObject("pagingHtml", pagingHtml);
			mv.addObject("currentPage", currentPage);
			mv.addObject("member", adminMember);
			mv.setViewName("adminMemberList");

			return mv;

		} else {

			totalCount = adminMember.size();

			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminMember");
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			adminMember = adminMember.subList(page.getStartCount(), lastCount);

			mv.addObject("isSearch", isSearch);
			mv.addObject("searchNum", searchNum);
			mv.addObject("totalCount", totalCount);
			mv.addObject("pagingHtml", pagingHtml);
			mv.addObject("currentPage", currentPage);

			mv.addObject("member", adminMember);
			mv.setViewName("adminMemberList");

			return mv;
		}
		
	}

	// 회원정보 삭제
	@RequestMapping(value = "/adminMemberDelete.jy")
	public ModelAndView deleteMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("회원 삭제 : " + commandMap.getMap());

		AdminMemberService.deleteMember(commandMap.getMap());
		mv.setViewName("redirect:/adminMember.jy");

		return mv;
	}

	// 회원 상세정보
	@RequestMapping(value = "/adminMemberModifyForm.jy")
	public ModelAndView memberModifyForm(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("memberDetail : " + commandMap.getMap());

		Map<String, Object> member = AdminMemberService.selectMemberDetail(commandMap.getMap());

		mv.addObject("member", member);
		mv.setViewName("adminMemberModifyForm");

		return mv;
	}

	// 회원정보 수정
	@RequestMapping(value = "/adminUpdateMember.jy")
	public ModelAndView updateMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("updateMember : " + commandMap.getMap());

		AdminMemberService.updateMember(commandMap.getMap());
		mv.setViewName("redirect:/adminMember.jy");

		return mv;
	}

}
