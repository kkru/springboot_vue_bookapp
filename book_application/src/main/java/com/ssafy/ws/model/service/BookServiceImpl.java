package com.ssafy.ws.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	/**
	 * has a 관계로 사용할 BookDao 타입의 dao를 선언한다.
	 */
	private BookDao dao;

	/**
	 * setter를 통해 BookDao를 주입받는다.
	 * 
	 * @Autowired를 통해 BookDao 타입의 빈을 주입 받는다.
	 * @param dao
	 */
	@Autowired
	public void setBookRepo(BookDao dao) {
		this.dao = dao;
	}

	public BookDao getBookRepo() {
		return dao;
	}
	
	@Override
	public List<Book> getBookList() {
		return dao.getBookList();
	}

	@Override
	@Transactional
	public int insert(Book book) {
		return dao.insert(book);
	}

	@Override
	@Transactional
	public int update(Book book) {
		return dao.update(book);
	}

	@Override
	@Transactional
	public int delete(String isbn) {
		return dao.delete(isbn);
	}

	@Override
	public Book select(String isbn) {
		return dao.select(isbn);
	}
}
