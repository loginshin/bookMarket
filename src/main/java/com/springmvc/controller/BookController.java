package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;


@Controller // ��Ʈ�ѷ����� ��Ÿ�����Ѵ�.
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	// /books�� ��û�� ������ �Ʒ� ��Ʈ�ѷ��� �۵���Ų��. (GET ���)
	@RequestMapping
	public String requestBookList(Model model) {
		System.out.println("bookController ���� �Ϸ�");
		List<Book> list = bookService.getAllBookList(); //��� å ��ü�� ����Ʈ�� Ŭ���� �������� ��´�
		model.addAttribute("bookList", list); //�𵨿� �߰��Ѵ�.
		System.out.println("books.jsp�� �̵��մϴ�");
		return "books";
	}
		
	@RequestMapping(value="all")
	public String requstAllBooks(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList",list);
		return "books";
	}
	
}
