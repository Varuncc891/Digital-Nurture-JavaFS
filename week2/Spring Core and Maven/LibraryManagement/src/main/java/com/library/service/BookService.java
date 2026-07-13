package com.library.service;

import com.library.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService() {}

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Service: Constructor Injection successful.");
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Service: Setter Injection successful.");
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
