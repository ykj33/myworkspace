package kr.co.inter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInter extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle:::::::::::::::::::::::::");

		// Object 타입이므로 HandlerMethod 타입으로 받는다.
		HandlerMethod hmethod = (HandlerMethod) handler;
		Method method = hmethod.getMethod();
		System.out.println(hmethod.getBean()); // 컨트롤러의 정보
		System.out.println(method); // 어떤 메소드가 MVC 핸들러로 사용되는지 알려줌
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHande:::::::::::::::::::::::::");
		// 이것 자체가 Map, key값을 설정해준다. Object로 받는건 모든 종류의 데이터를 받을 수 있기 때문
		Object test = modelAndView.getModel().get("test");
		modelAndView.getModel().put("show", "show");
		System.out.println(test);
	}
}
