package com.hibernate.bootstrappinghibernate5.services;

import com.hibernate.springbootwhibernate.models.Book;
import com.hibernate.springbootwhibernate.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }
}