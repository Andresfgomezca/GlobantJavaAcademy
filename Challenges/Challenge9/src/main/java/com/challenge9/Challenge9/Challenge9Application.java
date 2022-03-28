package com.challenge9.Challenge9;

import com.challenge9.Challenge9.Controllers.BookController;
import com.challenge9.Challenge9.Models.Book;
import com.challenge9.Challenge9.Models.Category;
import com.challenge9.Challenge9.Models.Tag;
import com.challenge9.Challenge9.Repositories.BookRepository;
import com.challenge9.Challenge9.Repositories.CategoryRepository;
import com.challenge9.Challenge9.Repositories.TagRepository;
import com.challenge9.Challenge9.Services.BookService;
import com.challenge9.Challenge9.Services.CategoryService;
import com.challenge9.Challenge9.Services.TagService;
import com.challenge9.Challenge9.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class Challenge9Application {

	public static void main(String[] args) {
		SpringApplication.run(Challenge9Application.class, args);
		/*
		BookService bookService = new BookService();
		TagService tagService = new TagService();
		CategoryService categoryService = new CategoryService();

		categoryService.create(Category.builder().id(1).name("test1").build());
		categoryService.create(Category.builder().id(2).name("test2").build());

		tagService.create(Tag.builder().id(1).name("testTag1").build());

		bookService.create(BookDTO.builder().id(1).name("testBook1").status("new").category(categoryService.get(1).get()).tags(tagService.list()).build());
		bookService.create(BookDTO.builder().id(1).name("testBook2").status("used").category(categoryService.get(1).get()).tags(tagService.list()).build());
		 */


	}

}
