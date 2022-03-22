package com.example.onlinekutubxona.controller;

import com.example.onlinekutubxona.dto.BookDto;
import com.example.onlinekutubxona.entity.Book;
import com.example.onlinekutubxona.repository.CategoryRepository;
import com.example.onlinekutubxona.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/booklar")
    public String allCategoryUser(Model model){
        List<Book> bookList = bookService.getAll();
        model.addAttribute("booklist", bookList);
        return "book_page";
    }

    @GetMapping("/booklist")
    public String allProductAdmin(Model model){
        List<Book> bookList = bookService.getAll();
        model.addAttribute("book", bookList);
        return "book_form_admin";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model){
        Book byId = bookService.getById(id);
        model.addAttribute("book", byId);
        return "edit_book_page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, Book book){
        bookService.edit(id, book);
        return "redirect:/book/booklist";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        bookService.delet(id);
        return "redirect:/book/booklist";
    }

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/save")
    public String savePage(Model model){
        BookDto bookDto = new BookDto();
        model.addAttribute("book", bookDto);
//        model.addAttribute("categories", categoryRepository.findAll());
        return "book_save_page";
    }

    @PostMapping("/save")
    public String save(BookDto bookDto){
        bookService.save(bookDto);
        return "redirect:/book/booklist";
    }
}
