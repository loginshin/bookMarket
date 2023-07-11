package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired //필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList(){
		return bookRepository.getAllBookList();
	
	}
}

