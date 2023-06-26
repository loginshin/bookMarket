package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
//	@Autowired를 하지않으면 setBookRepository로 가져와야한다.
	
	
	
	@Override
	public List<Book> getAllBookList() {
		return bookRepository.getAllBookList();
	}

}
