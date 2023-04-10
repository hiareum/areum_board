package com.springbook.view.user;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;  //어떤 Controller 객체가 검색되더라도 같은 코드로 실행하려면 모든 컨트롤의 최상위 인터페이스 필요

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("로그인 처리");

		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. 화면 네비게이션 기존 패키지에있는 컨트롤러 사용시
//		if (user != null) {
//			System.out.println("로그인정보 "+user);
//			return "getBoardList.do";
//		} else {
//			return "login";
//		}

		// 3. 화면 네비게이션 스프링 컨테이너사용시
		//redirect:를 사용하는 이유는 뷰리졸버가 설정되어 있더라도 이를 무시하고 리다이렉트함
		ModelAndView mv =new ModelAndView(); //spring 컨트롤러를 사용했기 때문에 ModelAndView로 바꿔야한다
		if (user != null) {
			mv.setViewName("redirect:getBoardList.do");
			
		} else {
			mv.setViewName("redirect:login.jsp");
		}
		return mv;

		
	}

}


