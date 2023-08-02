package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

// 나는 2번 개발했습니다.
@Controller // 컨트롤러임을 나타내야한다.
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	// /books로 요청을 받으면 아래 컨트롤러를 작동시킨다. (GET 방식)
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("bookController 접근 완료");
		List<Book> list = bookService.getAllBookList(); // 모든 책 객체를 리스트에 클래스 형식으로 담는다
		model.addAttribute("bookList", list); // 모델에 추가한다.
		System.out.println("books.jsp로 이동합니다");
		return "books";
	}

	//
	@GetMapping(value = "all")
	public ModelAndView requestAllBook() {
		ModelAndView modelAndView = new ModelAndView(); // ModelAndView클래스의 modelAndView 인스턴스를 생성합니다.
		List<Book> list = bookService.getAllBookList(); // 도서 목록을 가져와 저장된 list 값을 모델 속성 bookList에 저장합니다.
		modelAndView.addObject("bookList", list); // 뷰 이름을 books로 설정하여 books.jsp 파일을 출력합니다.
		modelAndView.setViewName("books"); // ModelAndVIew 클래스의 modelAndView 인스턴스를 반환합니다.

		return modelAndView;
	}

	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		System.out.println("카테고리 값은 :" + bookCategory);
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);

		model.addAttribute("bookList", booksByCategory);
		return "books";
	}

	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter,
			Model model) {
		System.out.println("bookFilter 컨트롤러 접근");
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		System.out.println("전달할 필터 : " + booksByFilter);
		model.addAttribute("bookList", booksByFilter); // model로 전달
		return "books";
	}

	//
	@GetMapping("/book")
	public String requsetBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById); // 그 id값에 맞는 책의 객체가 들어있다.
		return "book";
	}

	// modelAttribute 객체명 NewBook으로 보낸다.
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		return "addBook";
	}

	// RequestMapping, GetMapping 과 똑같은 역할을한다. 단디 GetMapping을 더 많이 사용
	// 등록을 하면 bookService 의 setNewBook메서드를 호출해 등록하고 books 페이지로 돌아간다.
	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Book book) {
		bookService.setNewBook(book);
		return "redirect:/books";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 도서 등록");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category",
				"unitsInStock", "totalPages", "releaseDate", "condition");
		
	}

}
