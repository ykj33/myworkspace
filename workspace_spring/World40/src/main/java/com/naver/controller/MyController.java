package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.utils.Utils;

@Controller
public class MyController {

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test(String name) {
		name = Utils.toKor(name);
		System.out.println(name);
	}

	@RequestMapping(value = "good", method = RequestMethod.GET)
	public void good(Model model) {
		model.addAttribute("test", "test입니다.");
	}

	// 반환형이 없을 시 value값이 view
	@RequestMapping(value = "world", method = RequestMethod.GET)
	public void world() {

	}

	// 배열로 value값을 주어도 된다.
	// 반환형은 view 페이지의 이름
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello() {

		return "hello";
	}
}
