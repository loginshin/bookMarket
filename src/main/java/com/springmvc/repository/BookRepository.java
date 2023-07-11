package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Book;


//인터페이스 만들기
public interface BookRepository {
	//북데이터가 담긴 리스트를 꼭 호출해야한다.
	List<Book> getAllBookList();

}
