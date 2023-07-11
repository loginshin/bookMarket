package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;


@Controller // 컨트롤러임을 나타내야한다.
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	// /books로 요청을 받으면 아래 컨트롤러를 작동시킨다. (GET 방식)
	@RequestMapping
	public String requestBookList(Model model) {
		System.out.println("bookController 접근 완료");
		List<Book> list = bookService.getAllBookList(); //모든 책 객체를 리스트에 클래스 형식으로 담는다
		model.addAttribute("bookList", list); //모델에 추가한다.
		System.out.println("books.jsp로 이동합니다");
		return "books";
	}
		
	@RequestMapping(value="all")
	public String requstAllBooks(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList",list);
		return "books";
	}
	
}
