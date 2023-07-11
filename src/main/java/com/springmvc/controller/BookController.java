package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// /books로 요청을 받으면 아래 컨트롤러를 작동시킨다. (GET 방식)
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList(); //모든 책 객체를 리스트에 클래스 형식으로 담는다
		model.addAttribute("bookList", list); //모델에 추가한다.
		return "books";
	}
		
	
	
	
}
