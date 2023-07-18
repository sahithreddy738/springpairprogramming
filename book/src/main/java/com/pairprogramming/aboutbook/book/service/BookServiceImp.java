package com.pairprogramming.aboutbook.book.service;

import com.pairprogramming.aboutbook.book.dto.BookDto;
import com.pairprogramming.aboutbook.book.entity.Book;
import com.pairprogramming.aboutbook.book.repositary.BookRepositary;

import java.util.List;
import java.util.Optional;

public class BookServiceImp implements BookService{

   private BookRepositary bookRepositary;

   public BookServiceImp(BookRepositary bookRepositary) {
       this.bookRepositary=bookRepositary;
   }

   @Override
   public List<Book> findAll() { return bookRepositary.findAll();}

    @Override
    public BookDto saveBook(BookDto theBookDto) {
        Book savedEntity= bookRepositary.save(theBookDto.convertDtoToEntity(theBookDto));
        BookDto updatedDto= theBookDto.convertEntityToDto(savedEntity);
        return updatedDto;
    }


    @Override
    public Book getBookById(int theId) {
        Optional<Book> result= bookRepositary.findById(theId);

        Book book =null;

        if(result.isPresent()) {
            book =result.get();
        }
        else {
            throw  new RuntimeException();
        }
        return book;
    }

    @Override
    public void deleteBookById(int theId) {
        bookRepositary.deleteById(theId);
    }


}
