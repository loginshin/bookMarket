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

@Controller // �ؿ� Ŭ������ ��Ʈ�ѷ� ������ �ϴ°��� ��Ÿ���ϴ�.
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// ������Ʈ���� ������̼��� �Ű��������� ������ �ش� �޼��尡 �۵��Ѵ�.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to BookMarket");
		model.addAttribute("strapline", "Welcome to Web Shopping Mall!");
		return "welcome";
	}
}