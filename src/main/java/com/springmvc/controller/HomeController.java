package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //밑에 클래스가 컨트롤러 역할을 하는것을 나타냅니다.
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//리퀘스트매핑 어노테이션은 매개변수값과 같으면 해당 메서드가 작동한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate ); //비즈니스 로직을 수행한 결과를 뷰에 보냅니다.
		return "home";
	}
	
}