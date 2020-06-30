package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
// requestMapping을 클래스 단위로도 매길 수 있다. 폴더의 개념
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberDTO> list = memberService.list();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	// 파라미터로 dto객체를 주면 알아서 데이터를 넣는다.
	public String insert(MemberDTO dto) {

		memberService.insert(dto);

		// 리다이렉트로 보내고 싶으면 redirect:/를 붙이면됨
		return "redirect:/member/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insert";
	}
}
