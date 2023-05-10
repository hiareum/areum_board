package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value=	"/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�...");
		vo.setId("TEST");
		vo.setPassword("TEST123");
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		//����ȭ�� Ŭ���̾�Ʈ���� �����ϱ�
		if (vo.getId() == null || vo.getId().equals("")) {
			return "login";
		}
		
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "redirect:/getBoardList.do";
		} else
			System.out.println("ȸ���̾����ϴ�."); return "login";
	}
	
}
