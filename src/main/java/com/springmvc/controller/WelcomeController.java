package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//컨트롤러 선언 해당 클래스가 컨트롤러임을 나타냄
public class WelcomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)//클라이언트 요청 URL /home이면 다음 메서드와 매핑
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to BookMarket");//Model 타입 객체를 이용하여 뷰에 전달할 정보를 담음
		model.addAttribute("Strapline", "Welcome to Web Shopping Mall!");
		return "welcome"; // ServletContext의 View Resolver한테 전달
	}
	
}