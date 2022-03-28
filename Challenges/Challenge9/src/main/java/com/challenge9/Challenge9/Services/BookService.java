package com.challenge9.Challenge9.Services;

import com.challenge9.Challenge9.Models.Book;
import com.challenge9.Challenge9.dto.BookUpdatedDto;
import com.challenge9.Challenge9.enums.Status;
import com.challenge9.Challenge9.Repositories.BookRepository;
import com.challenge9.Challenge9.dto.BookDTO;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> list() {
        return bookRepository.findAll();
    }
    public List<Book> findByStatus(Status status){
        return bookRepository.findAll().stream().filter(book -> book.getStatus().equals(status)).collect(Collectors.toList());
    }

    public Book create(BookDTO bookDTO) {
        categoryService.create(bookDTO.getCategory());
        tagService.createAll(bookDTO.getTags());
        return bookRepository.save(Book.builder()
                .id(bookDTO.getId())
                .name(bookDTO.getName())
                .status(bookDTO.getStatus())
                .category(bookDTO.getCategory())
                .tags(bookDTO.getTags()).build());
    }
    public Book update(BookDTO bookDTO) {
        categoryService.updateName(bookDTO.getCategory());
        tagService.createAll(bookDTO.getTags());
        bookRepository.getById(bookDTO.getId()).setName(bookDTO.getName());
        bookRepository.getById(bookDTO.getId()).setId(bookDTO.getId());
        bookRepository.getById(bookDTO.getId()).setCategory(bookDTO.getCategory());
        bookRepository.getById(bookDTO.getId()).setTags(bookDTO.getTags());
        bookRepository.getById(bookDTO.getId()).setStatus(bookDTO.getStatus());
        return bookRepository.getById(bookDTO.getId());

    }

    public Book updateWithForm(Long id, BookUpdatedDto bookUpdatedDto) {
        Optional<Book> UpdatedBook =  bookRepository.findById(id);
        UpdatedBook.get().setName(bookUpdatedDto.getName());
        UpdatedBook.get().setStatus(bookUpdatedDto.getStatus());
        bookRepository.save(UpdatedBook.get());

        return bookRepository.getById(id);

    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
