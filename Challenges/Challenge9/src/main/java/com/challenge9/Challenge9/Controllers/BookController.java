package com.challenge9.Challenge9.Controllers;

import com.challenge9.Challenge9.Models.Book;
import com.challenge9.Challenge9.dto.BookUpdatedDto;
import com.challenge9.Challenge9.enums.Status;
import com.challenge9.Challenge9.Services.BookService;
import com.challenge9.Challenge9.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/byStatus", method = RequestMethod.GET)
    public ResponseEntity<Book> listByStatus(@RequestBody Status status) {
        List<Book> books = bookService.findByStatus(status);
        return new ResponseEntity(books, HttpStatus.OK);
    }


    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> bookById(@PathVariable(value = "id") Long id) {
        Optional<Book> book = bookService.get(id);
        if(book.isPresent()){
            return new ResponseEntity(book, HttpStatus.OK);
        }
        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity<Book> create(@RequestBody BookDTO book) {
        Book bookCreated = bookService.create(book);

        return new ResponseEntity(bookCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
    public ResponseEntity<Book> updateBookWithForm(@PathVariable Long id, @RequestBody BookUpdatedDto bookUpdatedDto) {
        Book bookUpdated = bookService.updateWithForm(id, bookUpdatedDto);
        return new ResponseEntity(bookUpdated, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@RequestBody BookDTO book) {
        Optional<Book> bookUpdate = bookService.get(book.getId());
        if(bookUpdate.isPresent()){
            Book bookCreated = bookService.update(book);
            return new ResponseEntity(bookCreated, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
}
