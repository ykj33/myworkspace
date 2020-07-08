package kr.co.ca;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

	// RequestBody를 파라미터로 준다.
	@RequestMapping(value = "rt1", method = RequestMethod.POST)
	public String rt1(@RequestBody String test1) {
		System.out.println(test1);
		return "ok";
	}

	@RequestMapping(value = "rt2", method = RequestMethod.POST)
	public Map<String, Object> rt2(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		return map;
	}

	@RequestMapping(value = "rt3", method = RequestMethod.POST)
	public List<Map<String, Object>> rt3(@RequestBody Map<String, Object> map) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("test4");
		for (Map<String, Object> m : list) {
			System.out.println(":::::::::::::::::::::::::::");
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("age"));
			System.out.println(":::::::::::::::::::::::::::");
		}
		return list;
	}

	@RequestMapping(value = "rt4", method = RequestMethod.POST)
	public String rt4(@RequestBody Map<String, Object> map) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("listStr");
		for (Map<String, Object> m : list) {
			System.out.println("=============");
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("age"));
			System.out.println("=============");
		}
		return "world";
	}
}
