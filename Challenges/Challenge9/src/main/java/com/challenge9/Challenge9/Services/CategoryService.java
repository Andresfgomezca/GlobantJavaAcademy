package com.challenge9.Challenge9.Services;

import com.challenge9.Challenge9.Models.Book;
import com.challenge9.Challenge9.Models.Category;
import com.challenge9.Challenge9.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> get(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateName(Category category) {
        categoryRepository.getById(category.getId()).setName(category.getName());
        return categoryRepository.getById(category.getId());
    }


    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
