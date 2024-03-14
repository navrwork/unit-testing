package com.navr.mockitodemo.bookservice;

import java.util.List;

public interface BookRepository {
	void save(Book book);

	Book findByBookTitle(String bookTitle);

	List<Book> findAll();

	void dummyMethod();

}