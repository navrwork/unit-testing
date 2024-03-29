package com.navr.mockitodemo;


import com.navr.mockitodemo.bookservice.Book;
import com.navr.mockitodemo.bookservice.BookLenderMapRepository;
import com.navr.mockitodemo.bookservice.BookRepository;
import com.navr.mockitodemo.bookservice.BookService;
import com.navr.mockitodemo.bookservice.EmailService;
import com.navr.mockitodemo.bookservice.Lender;
import com.navr.mockitodemo.bookservice.LenderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTest {

    BookRepository mockBookRepository;
    LenderRepository mockLenderRepository;
    BookLenderMapRepository mockBookLenderRepository;

    EmailService mockEmailService;

    BookService bookService;

    @BeforeEach
    public void setUp() {
        // Mock objects and method calls
        this.mockBookRepository = mock(BookRepository.class);
        this.mockBookLenderRepository = mock(BookLenderMapRepository.class);
        this.mockLenderRepository = mock(LenderRepository.class);
        this.mockEmailService = mock(EmailService.class);
        this.bookService = new BookService(mockBookRepository, mockLenderRepository, mockBookLenderRepository);
//        System.out.printf("bookService=%s%n", bookService.getClass().getCanonicalName());

        // Mock BookRepository
        when(mockBookRepository.findAll()).thenReturn(fetchAllBooks());
        when(mockBookRepository.findByBookTitle(anyString())).thenReturn(fetchAllBooks().get(0));
        // Mock void method call
        doNothing().when(mockBookRepository).save(any(Book.class));

        when(mockBookLenderRepository.findLenderByBookId("b1002", LocalDate.now())).thenReturn("l50002");
    }

    @Order(1)
    @Test
    public void test_01_FindAll() {
        List<Book> allBooks = this.bookService.findAll();
        System.out.printf("test_01_FindAll: allBooks.size=%s%n", allBooks.size());
        assertTrue(!allBooks.isEmpty());
    }


    @Order(2)
    @Test
    public void test_02_FindByBookTitle() {
        Book b = this.bookService.findByBookTitle("abcde");
        System.out.printf("test_02_FindByBookTitle: book=%s%n", b);
        assertNotNull(b);
    }

    @Order(3)
    @Test
    public void test_03_Save() {
        Book b = new Book("b1999", "aaa", 100, LocalDate.now());
        this.bookService.addBook(b);
        System.out.printf("test_03_Save complete.%n");
        verify(mockBookRepository, times(1)).save(b);
    }

    @Order(4)
    @Test
    public void test_04_notifyBookLender() {
        when(mockBookLenderRepository.findLenderByBookId(anyString(), any(LocalDate.class)))
                .thenReturn("l5001");
        when(mockLenderRepository.findByLenderId(anyString())).thenReturn(fetchMockLender());
        doNothing().when(mockEmailService).sendReturnReminder(anyString());
        this.bookService.setEmailService(mockEmailService);
        this.bookService.notifyBookLender("b1001");
        System.out.printf("test_04_notifyBookLender complete.%n");
        verify(mockEmailService, times(1)).sendReturnReminder(anyString());
    }

    @Order(5)
    @Test
    public void test_10_UnusedMethods() {
        mockBookRepository.dummyMethod();
        mockBookRepository.findByBookTitle("aaa");
        mockBookRepository.findByBookTitle("bbb");
        verify(mockBookRepository, times(1)).dummyMethod();
        verify(mockBookRepository, times(2)).findByBookTitle(anyString());
        System.out.printf("test_10_UnusedMethods complete.%n");
        verify(mockBookRepository).dummyMethod();
    }

    private List<Book> fetchAllBooks() {
        return Arrays.asList(
                new Book("b1001", "abcd", 100, LocalDate.now()),
                new Book("b1002", "How to Eat", 10000, LocalDate.now())
        );
    }

    private Lender fetchMockLender() {
        Lender lender = new Lender();
        lender.setLenderEmail("lender007@gmail.com");
        return lender;
    }
}
