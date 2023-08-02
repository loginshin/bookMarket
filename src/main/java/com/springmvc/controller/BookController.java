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

// ���� 2�� �����߽��ϴ�.
@Controller // ��Ʈ�ѷ����� ��Ÿ�����Ѵ�.
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	// /books�� ��û�� ������ �Ʒ� ��Ʈ�ѷ��� �۵���Ų��. (GET ���)
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("bookController ���� �Ϸ�");
		List<Book> list = bookService.getAllBookList(); // ��� å ��ü�� ����Ʈ�� Ŭ���� �������� ��´�
		model.addAttribute("bookList", list); // �𵨿� �߰��Ѵ�.
		System.out.println("books.jsp�� �̵��մϴ�");
		return "books";
	}

	//
	@GetMapping(value = "all")
	public ModelAndView requestAllBook() {
		ModelAndView modelAndView = new ModelAndView(); // ModelAndViewŬ������ modelAndView �ν��Ͻ��� �����մϴ�.
		List<Book> list = bookService.getAllBookList(); // ���� ����� ������ ����� list ���� �� �Ӽ� bookList�� �����մϴ�.
		modelAndView.addObject("bookList", list); // �� �̸��� books�� �����Ͽ� books.jsp ������ ����մϴ�.
		modelAndView.setViewName("books"); // ModelAndVIew Ŭ������ modelAndView �ν��Ͻ��� ��ȯ�մϴ�.

		return modelAndView;
	}

	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		System.out.println("ī�װ� ���� :" + bookCategory);
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);

		model.addAttribute("bookList", booksByCategory);
		return "books";
	}

	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter,
			Model model) {
		System.out.println("bookFilter ��Ʈ�ѷ� ����");
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		System.out.println("������ ���� : " + booksByFilter);
		model.addAttribute("bookList", booksByFilter); // model�� ����
		return "books";
	}

	//
	@GetMapping("/book")
	public String requsetBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById); // �� id���� �´� å�� ��ü�� ����ִ�.
		return "book";
	}

	// modelAttribute ��ü�� NewBook���� ������.
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		return "addBook";
	}

	// RequestMapping, GetMapping �� �Ȱ��� �������Ѵ�. �ܵ� GetMapping�� �� ���� ���
	// ����� �ϸ� bookService �� setNewBook�޼��带 ȣ���� ����ϰ� books �������� ���ư���.
	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Book book) {
		bookService.setNewBook(book);
		return "redirect:/books";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "�ű� ���� ���");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category",
				"unitsInStock", "totalPages", "releaseDate", "condition");
		
	}

}
