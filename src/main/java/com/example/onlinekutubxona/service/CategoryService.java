package com.example.onlinekutubxona.service;

import com.example.onlinekutubxona.dto.CategoryDto;
import com.example.onlinekutubxona.entity.Category;
import com.example.onlinekutubxona.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll() {
    return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public void edit(Integer id, Category categorys) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.get();
        category.setName(categorys.getName());
        categoryRepository.save(category);
    }

    public void delet(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
    }
}
