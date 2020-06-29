package kr.co.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ca.HomeController;

@Controller // controller라고 선언
public class MyController {

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show() {
		return "show";
	}
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	// 반환형이 void인 경우에도 인식하므로 jsp를 만들어주어야 한다.
	public void list() {

	}

	// MVC 핸들러를 만들기 위해 어노테이션과 value를 통해 선언한다.
	// return값과 value를 다르게 하여 uri를 의도적으로 숨길 수 있으나 권장되지 않는다.
	// Model model을 파라미터로 주어 사용할 수 있게 함
	// request로 값을 받지 않고 그냥 String으로 값을 줄 수 있다.
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, String name) {
		
		name = toKor(name);
		
		model.addAttribute("name", name);
		return "insert";
	}

	private String toKor(String name) {
		
		try {
			return new String(name.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		

		
		// model.addAttribute로 class에 있는 데이터를 jsp로 보낼 수 있다.
		model.addAttribute("serverTime", "안녕하세요");

		return "home";
	}
}
