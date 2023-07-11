package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;


@Controller // ��Ʈ�ѷ����� ��Ÿ�����Ѵ�.
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	// /books�� ��û�� ������ �Ʒ� ��Ʈ�ѷ��� �۵���Ų��. (GET ���)
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("bookController ���� �Ϸ�");
		List<Book> list = bookService.getAllBookList(); //��� å ��ü�� ����Ʈ�� Ŭ���� �������� ��´�
		model.addAttribute("bookList", list); //�𵨿� �߰��Ѵ�.
		System.out.println("books.jsp�� �̵��մϴ�");
		return "books";
	}
		
	//
	@GetMapping(value="all")
	public ModelAndView requestAllBook() {
		ModelAndView modelAndView = new ModelAndView(); //ModelAndViewŬ������ modelAndView �ν��Ͻ��� �����մϴ�.
		List<Book> list = bookService.getAllBookList(); // ���� ����� ������ ����� list ���� �� �Ӽ� bookList�� �����մϴ�.
		modelAndView.addObject("bookList", list);		//�� �̸��� books�� �����Ͽ� books.jsp ������ ����մϴ�.
		modelAndView.setViewName("books");				//ModelAndVIew Ŭ������ modelAndView �ν��Ͻ��� ��ȯ�մϴ�.
		
		return modelAndView;
	}
	
}
