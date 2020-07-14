package kr.co.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInter extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object login = session.getAttribute("login");
		
		if (login == null) {
			// path 출력
			String uri = request.getRequestURI();
			String querystring = request.getQueryString();
			if (querystring == null) {
				// querystring이 없다면 공백으로
				querystring = "";
			} else {
				// ?가 중간에 들어가야 정상적인 형태로 출력
				querystring = "?" + querystring;
			}

			// 요청이 GET 방식일 때
			if (request.getMethod().equals("GET")) {
				String path = uri + querystring;
				session.setAttribute("path", path);
			}

			response.sendRedirect("/member/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
