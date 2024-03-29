package com.springmvc.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	private List<Book> listOfBooks = new ArrayList<Book>();

	// set에 담고 리스트에 추가하기
	public BookRepositoryImpl() {
		Book book1 = new Book("ISBN1234", "C# 교과서", 30000);
		book1.setAuthor("박용준");
		book1.setDescription(
				"C# 교과서는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로 한다. 특히 응용 프로그래머를 위한 C# 입문서로, C#을 사용하여 게임(유니티), 웹, 모바일, IoT 등을 개발할 때 필요한 C# 기초 문법을 익히고 기본기를 탄탄하게 다지는 것이 목적이다.");
		book1.setPublisher("길벗");
		book1.setCategory("IT전문서");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2020/05/29");

		Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000);
		book2.setAuthor("조현영");
		book2.setDescription(
				"이 책은 프런트부터 서버, 데이터베이스, 배포까지 아우르는 광범위한 내용을 다룬다. 군더더기 없는 직관적인 설명으로 기본 개념을 확실히 이해하고, 노드의 기능과 생태계를 사용해 보면서 실제로 동작하는 서버를 만들어보자. 예제와 코드는 최신 문법을 사용했고 실무에 참고하거나 당장 적용할 수 있다.");
		book2.setPublisher("길벗");
		book2.setCategory("IT전문서");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2020/07/25");

		Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000);
		book3.setAuthor("김두한");
		book3.setDescription(
				"어도비 XD 프로그램을 통해 UI/UX 디자인을 배우고자 하는 예비 디자이너의 눈높이에 맞게 기본적인 도구를 활용한 아이콘 디자인과 웹&앱 페이지 디자인, UI 디자인, 앱 디자인에 애니메이션과 인터랙션을 적용한 프로토타이핑을 학습합니다.");
		book3.setPublisher("길벗");
		book3.setCategory("IT활용서");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2019/05/29");

		// 데이터가 담긴 리스트를 만들어 전달하기 위함
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}

	@Override
	public List<Book> getAllBookList() {
		// 함수 사용시 리스트 전달 도메인 객체가 사용한다.
		return listOfBooks;
	}

	// 책을 순차적으로 카테고리를 검사해서 맞다면 카테고리에 그 책을 추가한다.
	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = new ArrayList<Book>();
		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (category.equalsIgnoreCase(book.getCategory())) {
				booksByCategory.add(book);
			}

		}

		return booksByCategory;
	}

	
	
	//중복되지 않게 set으로 주머니에 집어넣기 => map형태로 집어넣어서 key값만 겹치지 않는다면 넣을 수 있다.
	//filter 는 map에대한 변수명이다
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();
		Set<String> booksByFilter = filter.keySet(); //키값들을 전부 집어넣는다.

		
		//1)매트릭스 변수 중 publisher를 포함하는 경우에 실행됩니다.
		//  전체 도서 목록 중에서 publisher 필드 값과 일치하는 도서를 검색하여
		//  booksByPublisher 객체에 등록합니다.
		if (booksByFilter.contains("publisher")) { 
			for (int j = 0; j < filter.get("publisher").size(); j++) { // 
				String publisherName = filter.get("publisher").get(j);
				System.out.println(publisherName); // 출판사 이름 출력
				for (int i = 0; i < listOfBooks.size(); i++) {
					Book book = listOfBooks.get(i);

					if (publisherName.equalsIgnoreCase(book.getPublisher()))
						booksByPublisher.add(book);
				}
			}
		}
		
		//2) 매트릭스 변수 중 category를 포함하는 경우에 실행되고,
		//	전체 도서 목록 중 category값과 일치하는 도서를 검색하여
		//	booksByCategory 객체에 등록합니다.
        if (booksByFilter.contains("category")) {
            for (int i = 0; i < filter.get("category").size(); i++) { 
               String category = filter.get("category").get(i); 
               List<Book> list = getBookListByCategory(category); 
               booksByCategory.addAll(list); 
           }
       }
		// booksByCategory 객체에 등록된 도서와 booksByPublisher에 등록된
        // 도서 목록 중 중복되는 도서만 남기고 나머지는 삭제한 후 booksByCategory 객체로 반환합니다.
        // 공통 요소만 남기고 나머지값 제거.
        booksByCategory.retainAll(booksByPublisher);
        return booksByCategory;
	}
	
	
	@Override
	public Book getBookById(String bookId) {
		Book bookInfo = null;
		for ( int i = 0 ; i< listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			// 책을 순서대로 가지고와서 책이 있고 가져온 책의 정보가 dto에 있다면 bookInfo에 책을 집어넣는다.
			if (book != null && book.getBookId() !=null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
		}
		if ( bookInfo == null) {
			throw new IllegalArgumentException("도서ID가 " + bookId + "인 해당 도서를 찾을 수 없습니다.");
		}
		
		return bookInfo;
	}

	// 책 추가하기
	@Override
	public void setNewBook(Book book) {
		listOfBooks.add(book);
		
	}

}
