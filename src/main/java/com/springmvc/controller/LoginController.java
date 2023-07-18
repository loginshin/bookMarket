package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//��ť��Ƽ ���� ���Ͽ� login-page="/login"���� ��û�� �� �����մϴ�.
	//�� ��û URL�� /login�϶��� ��û ó�� �޼����Դϴ�
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// ��ť��Ƽ ���� ���Ͽ� authentication-failure-url="/loginfailed(���� ����)
	// error�� true ���� �����Ѵ�.
	@GetMapping("loginfailed")
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	//�� ��û url�� /logout�϶� ��û ó�� �޼��� �� login.jsp ��ȯ
	@GetMapping("/logout")
	public String logout(Model model) {
		return "login";
	}
}
