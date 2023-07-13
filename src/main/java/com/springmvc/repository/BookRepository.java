package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;


//인터페이스 만들기
public interface BookRepository {
	//북데이터가 담긴 리스트를 꼭 호출해야한다.
	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	Book getBookById(String bookId);

}
