package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;
public interface BookService {
	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String ,List<String>> filter);
	Book getBookById(String bookId);
	
	// 클라이언트가 전달한 책 등록 값들을 BookRepository에 전달해 책 추가하기
	void setNewBook(Book book);
}
