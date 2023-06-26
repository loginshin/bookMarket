package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//��Ʈ�ѷ� ���� �ش� Ŭ������ ��Ʈ�ѷ����� ��Ÿ��
public class WelcomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)//Ŭ���̾�Ʈ ��û URL /home�̸� ���� �޼���� ����
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to BookMarket");//Model Ÿ�� ��ü�� �̿��Ͽ� �信 ������ ������ ����
		model.addAttribute("Strapline", "Welcome to Web Shopping Mall!");
		return "welcome"; // ServletContext�� View Resolver���� ����
	}
	
}