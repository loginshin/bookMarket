package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

public class BookServiceImpl {
	@Autowired //�ʿ��� ���� ��ü�� "Ÿ��"�� �ش��ϴ� ���� ã�� ����
	private BookRepository bookRepository;
	
	public List<Book> getAllBookList(){
		return bookRepository.getAllBookList();
	}
}
