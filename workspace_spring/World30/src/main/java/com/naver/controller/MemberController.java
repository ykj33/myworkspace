package com.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
// requestMapping을 클래스 단위로도 매길 수 있다. 폴더의 개념
@RequestMapping("member")
// 혹시 model객체에 키값으로 바인딩 된 것이 있으면 session에 바인딩시켜라.
@SessionAttributes({ "login" })
public class MemberController {
	@Autowired
	private MemberService memberService;

	// SessionStatus 인터페이스로 로그아웃 구현
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/member/list";
	}

	@RequestMapping(value = "/loginpost", method = RequestMethod.POST)
	public String loginpost(LoginDTO login, Model model) {
		MemberDTO dto = memberService.loginpost(login);

		System.out.println(login.getId());
		System.out.println(login.getPw());
		
		// SessionAttributes 어노테이션에선 null을 허용하지 않는다.
		// 계정이 DB에 없는 경우를 허용하지 않으므로 if문으로 계정이 틀렸을 경우에 대비
		if (dto != null) {

			model.addAttribute("login", dto);
			return "redirect:/member/list";
		} else {
			return "redirect:/member/login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	// 객체를 파라미터로 주어도 알아서 필요한 값만 받는다. id 등
	public void read(String id, Model model) {
		MemberDTO dto = memberService.read(id);
		model.addAttribute("dto", dto);
	}

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

	// ?id = 으로 값을 넘겨받지 않으므로 {}안에 해준다.
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	// PathVariable 어노테이션을 사용하여 계속 바뀌는 변수를 받아 해당 자료형으로 저장한다.
	public String updateui(@PathVariable("id") String id, Model model) {
		MemberDTO dto = memberService.updateui(id);
		model.addAttribute("dto", dto);
		// update로 가도록 해준다.
		return "member/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO dto) {
		memberService.update(dto);
		return "redirect:/member/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		memberService.delete(id);
		return "redirect:/member/list";
	}
}
