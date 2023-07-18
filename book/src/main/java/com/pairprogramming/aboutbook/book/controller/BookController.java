package com.pairprogramming.aboutbook.book.controller;

import com.pairprogramming.aboutbook.book.dto.BookDto;
import com.pairprogramming.aboutbook.book.entity.Book;
import com.pairprogramming.aboutbook.book.service.BookService;
import com.pairprogramming.aboutbook.book.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> findAll() { return bookService.findAll();}

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable int bookId) {
        Book book =bookService.getBookById(bookId);
        if(book == null)
            throw new RuntimeException();
        return book;
    }

    @PostMapping("/books")
    public BookDto addBook(@RequestBody BookDto book) {
        book.setId(0);
        return bookService.saveBook(book);
    }

    @PutMapping("/book")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int bookId) {
        Book theBook=bookService.getBookById(bookId);
        if(theBook == null)
            throw  new RuntimeException();
        bookService.deleteBookById(bookId);
        return " deleted book id with" + bookId;
    }
}
