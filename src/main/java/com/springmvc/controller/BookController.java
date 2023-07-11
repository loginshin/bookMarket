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


@Controller // 컨트롤러임을 나타내야한다.
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	// /books로 요청을 받으면 아래 컨트롤러를 작동시킨다. (GET 방식)
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("bookController 접근 완료");
		List<Book> list = bookService.getAllBookList(); //모든 책 객체를 리스트에 클래스 형식으로 담는다
		model.addAttribute("bookList", list); //모델에 추가한다.
		System.out.println("books.jsp로 이동합니다");
		return "books";
	}
		
	//
	@GetMapping(value="all")
	public ModelAndView requestAllBook() {
		ModelAndView modelAndView = new ModelAndView(); //ModelAndView클래스의 modelAndView 인스턴스를 생성합니다.
		List<Book> list = bookService.getAllBookList(); // 도서 목록을 가져와 저장된 list 값을 모델 속성 bookList에 저장합니다.
		modelAndView.addObject("bookList", list);		//뷰 이름을 books로 설정하여 books.jsp 파일을 출력합니다.
		modelAndView.setViewName("books");				//ModelAndVIew 클래스의 modelAndView 인스턴스를 반환합니다.
		
		return modelAndView;
	}
	
}
