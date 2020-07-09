package kr.co.ca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.MemberDTO;

@Controller
public class AjaxTestController {

	// ajax 통신을 하는 핸들러라고 표기하기 위해 @ResponseBody 어노테이션이 필요
	@ResponseBody
	@RequestMapping(value = "at1", method = RequestMethod.POST)
	public String at1(String msg) {

		return msg + "!!!";
	}

	@RequestMapping(value = "/at1", method = RequestMethod.GET)
	public void at1() {

	}

	@ResponseBody
	@RequestMapping(value = "/at2", method = RequestMethod.POST)
	public String[] at2(String[] arr) {
		for (String x : arr) {
			System.out.println(x);
		}
		return arr;
	}

	@RequestMapping(value = "/at2", method = RequestMethod.GET)
	public void at2() {

	}

	@RequestMapping(value = "at3", method = RequestMethod.GET)
	public void at3() {

	}

	@ResponseBody
	@RequestMapping(value = "at3", method = RequestMethod.POST)
	public MemberDTO at3(MemberDTO dto) {
		return dto;
	}

	@RequestMapping(value = "at4", method = RequestMethod.GET)
	public void at4() {

	}

	@ResponseBody
	@RequestMapping(value = "at4", method = RequestMethod.POST)
	// 자바에서는 Map이 이런 형태이므로 Map으로 받는다.
	public List<Map<String, Object>> at4(@RequestParam Map<String, Object> map) throws Exception {
//		json형태를 String으로 받는다
		String jsonStr = map.get("listStr").toString();
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>>() {
		});
		for (Map<String, Object> m : list) {
			System.out.println(":::::::::::::::::::::::::::::");
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("age"));
			System.out.println(":::::::::::::::::::::::::::::");
		}

		return list;
	}

}
