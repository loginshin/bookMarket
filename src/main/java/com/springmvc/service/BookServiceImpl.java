package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

public class BookServiceImpl {
	@Autowired //필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입
	private BookRepository bookRepository;
	
	public List<Book> getAllBookList(){
		return bookRepository.getAllBookList();
	}
}
