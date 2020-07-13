package kr.co.ca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.AOPTestService;

@Controller
public class AOPTestController {

	
	@Autowired
	private AOPTestService aopService;
	
	// aop는 서비스 단에서만 작업하므로 DAO까지 갈 필요가 없다.
	@RequestMapping(value = "aoptest", method = RequestMethod.GET)
	public void aoptest() {
		aopService.aoptest();
	}
	
	@RequestMapping(value = "aoptest2", method = RequestMethod.GET)
	public void aoptest2() {
		aopService.aoptest2();
	}
	
	@RequestMapping(value = "aoptest3", method = RequestMethod.GET)
	public void aoptest3() {
		aopService.aoptest3();
	}
}
