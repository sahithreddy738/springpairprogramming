package com.pairprogramming.aboutbook.book.service;

import com.pairprogramming.aboutbook.book.dto.BookDto;
import com.pairprogramming.aboutbook.book.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    BookDto saveBook(BookDto bookDto);

    void deleteBookById(int theId);

    Book getBookById(int theId);

}
