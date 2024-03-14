package com.navr.mockitodemo.bookservice;

import java.time.LocalDate;
import java.util.List;

public class BookService {
	
	private BookRepository bookRepository;

	private LenderRepository lenderRepository;

	private BookLenderMapRepository bookLenderMapRepository;

	private EmailService emailService;

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public BookService(BookRepository bookRepository, LenderRepository lenderRepository, BookLenderMapRepository bookLenderMapRepository) {
		this.bookRepository = bookRepository;
		this.lenderRepository = lenderRepository;
		this.bookLenderMapRepository = bookLenderMapRepository;
	}
	
	public void addBook(Book book){
		bookRepository.save(book);
	}

	public Book findByBookTitle(String title) {
		return bookRepository.findByBookTitle(title);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public void notifyBookLender(String bookId) {
		String lenderId = bookLenderMapRepository.findLenderByBookId(bookId, LocalDate.now());
		Lender lender = lenderRepository.findByLenderId(lenderId);
		emailService.sendReturnReminder(lender.getLenderEmail());
	}

	public void unusedMethod() {
		// this is an unused method
	}
	
}