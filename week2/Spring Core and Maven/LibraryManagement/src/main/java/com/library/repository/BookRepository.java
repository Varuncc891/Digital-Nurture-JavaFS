package com.library.repository;

import com.library.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
        System.out.println("Repository: Book saved: " + book.getTitle());
    }

    public List<Book> findAll() {
        System.out.println("Repository: Fetching all books");
        return books;
    }
}
