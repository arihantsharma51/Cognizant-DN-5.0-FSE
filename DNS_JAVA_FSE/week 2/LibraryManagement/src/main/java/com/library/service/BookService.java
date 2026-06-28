package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    // Dependency
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService Bean Created");
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {

        System.out.println("Displaying Book Details");

        bookRepository.saveBook();

    }
}