package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//시큐리티 설정 파일에 login-page="/login"으로 요청할 때 매핑합니다.
	//웹 요청 URL이 /login일때의 요청 처리 메서드입니다
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// 시큐리티 설정 파일에 authentication-failure-url="/loginfailed(인증 실패)
	// error에 true 값을 저장한다.
	@GetMapping("loginfailed")
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	//웹 요청 url이 /logout일때 요청 처리 메서드 → login.jsp 반환
	@GetMapping("/logout")
	public String logout(Model model) {
		return "login";
	}
}
