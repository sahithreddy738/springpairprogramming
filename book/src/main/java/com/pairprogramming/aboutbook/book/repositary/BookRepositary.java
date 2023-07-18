package com.pairprogramming.aboutbook.book.repositary;

import com.pairprogramming.aboutbook.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositary extends JpaRepository<Book,Integer> {
}
