package com.example.onlinekutubxona.repository;

import com.example.onlinekutubxona.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByCategoryId(Integer id);
}
