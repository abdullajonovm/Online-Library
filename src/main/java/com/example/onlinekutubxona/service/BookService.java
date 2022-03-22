package com.example.onlinekutubxona.service;

import com.example.onlinekutubxona.dto.BookDto;
import com.example.onlinekutubxona.entity.Category;
import com.example.onlinekutubxona.entity.Book;
import com.example.onlinekutubxona.repository.CategoryRepository;
import com.example.onlinekutubxona.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;


    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void edit(Integer id, Book bookDto) {
        Optional<Book> byId = bookRepository.findById(id);
        Book book1 = byId.get();
        book1.setName(bookDto.getName());
        book1.setPrice(bookDto.getPrice());

        Optional<Category> byId1 = categoryRepository.findById(bookDto.getCategory().getId());
        Category category = byId1.get();

        book1.setCategory(category);

        bookRepository.save(book1);
    }

    public void delet(Integer id) {
        bookRepository.deleteById(id);
    }

    public void save(BookDto bookDto) {
        Book book = new Book();
        book.setPrice(bookDto.getPrice());
        book.setName(bookDto.getName());

        Optional<Category> byId = categoryRepository.findById(bookDto.getCategoryId());
        Category category = byId.get();

        book.setCategory(category);

        bookRepository.save(book);
    }
}
