package com.navr.mockitodemo.bookservice;

import java.time.LocalDate;

public interface BookLenderMapRepository {

    String findLenderByBookId(String bookId, LocalDate date);
}
