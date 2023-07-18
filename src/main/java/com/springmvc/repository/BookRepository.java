package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;


//인터페이스 만들기
public interface BookRepository {
	// 북데이터가 담긴 리스트를 꼭 호출해야한다. (인터페이스, 필수 오버라이딩)
	// 모든 책 목록 불러오기
	List<Book> getAllBookList();
	//카테고리별로 책 목록 불러오기
	List<Book> getBookListByCategory(String category);
	// 목록에서 책 필터링하기
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	// 책 id값 가져오기 (책 상세 페이지에서 사용)
	Book getBookById(String bookId);
	// 책 추가하기
	void setNewBook(Book book);
	

}
