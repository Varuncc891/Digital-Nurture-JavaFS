package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Testing Setter Injection Bean ---");
        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        setterService.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));

        System.out.println("\n--- Testing Constructor Injection Bean ---");
        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        constructorService.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));

        System.out.println("\n--- Testing Annotation Configuration & AOP ---");
        BookService componentService = (BookService) context.getBean("bookService");
        componentService.addBook(new Book(3, "1984", "George Orwell"));
        componentService.getAllBooks();
    }
}
