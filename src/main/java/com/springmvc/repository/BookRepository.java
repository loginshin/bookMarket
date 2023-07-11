package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Book;


//�������̽� �����
public interface BookRepository {
	//�ϵ����Ͱ� ��� ����Ʈ�� �� ȣ���ؾ��Ѵ�.
	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);

}
