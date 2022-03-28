package com.challenge9.Challenge9.Controllers;

import com.challenge9.Challenge9.Models.Book;
import com.challenge9.Challenge9.Models.Category;
import com.challenge9.Challenge9.Services.BookService;
import com.challenge9.Challenge9.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<Book> list() {
        List<Category> categories = categoryService.list();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> tagById(@PathVariable(value = "id") Long id) {
        Optional<Category> category = categoryService.get(id);
        if(category.isPresent()){
            return new ResponseEntity(category, HttpStatus.OK);
        }
        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category categoryCreated = categoryService.create(category);
        return new ResponseEntity(categoryCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") Long itemId) {
        categoryService.delete(itemId);
    }
}
