package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory,
			Model model) {
		System.out.println("ī�װ� ���� :" + bookCategory );
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(
    @MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
        System.out.println("bookFilter ��Ʈ�ѷ� ����");
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		System.out.println("������ ���� : " + booksByFilter);
        model.addAttribute("bookList", booksByFilter); // model�� ����
        return "books";
    }
	
	
	
}
