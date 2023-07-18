package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;


//�������̽� �����
public interface BookRepository {
	// �ϵ����Ͱ� ��� ����Ʈ�� �� ȣ���ؾ��Ѵ�. (�������̽�, �ʼ� �������̵�)
	// ��� å ��� �ҷ�����
	List<Book> getAllBookList();
	//ī�װ����� å ��� �ҷ�����
	List<Book> getBookListByCategory(String category);
	// ��Ͽ��� å ���͸��ϱ�
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	// å id�� �������� (å �� ���������� ���)
	Book getBookById(String bookId);
	// å �߰��ϱ�
	void setNewBook(Book book);
	

}
