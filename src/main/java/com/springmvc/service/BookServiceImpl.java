package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service // DB ←→ (Domain(DTO)) ←→ BookRepository(Dao) ←→ BookServiceImpl ←→ Controller  ←→ View
// model can conclude data in DTO
public class BookServiceImpl implements BookService {
	@Autowired //필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList(){
		return bookRepository.getAllBookList();
	
	}

	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}
}

