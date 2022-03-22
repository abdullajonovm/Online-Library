package com.example.onlinekutubxona.controller;

import com.example.onlinekutubxona.dto.CategoryDto;
import com.example.onlinekutubxona.entity.Book;
import com.example.onlinekutubxona.entity.Category;
import com.example.onlinekutubxona.repository.BookRepository;
import com.example.onlinekutubxona.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categorylar")
    public String allCategoryUser(Model model){
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("category", categoryList);
        return "category_page";
    }

    @GetMapping("/categorylist")
    public String allCategoryAdmin(Model model){
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("category", categoryList);
        return "category_form_admin";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model){
        Category byId = categoryService.getById(id);
        model.addAttribute("category", byId);
        return "edit_category_page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model,Category category){
        categoryService.edit(id, category);
        return "redirect:/category/categorylist";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        categoryService.delet(id);
        return "redirect:/category/categorylist";
    }

    @GetMapping("/save")
    public String savePage(Model model){
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("category", categoryDto);
        return "category_save_page";
    }

    @PostMapping("/save")
    public String save(CategoryDto categoryDto){
        categoryService.save(categoryDto);
        return "redirect:/category/categorylist";
    }

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/booookkkkk/{id}")
    public String booklistFromCategoryIdAdmin(@PathVariable Integer id, Model model){
        List<Book> allByCategoryId = bookRepository.findAllByCategoryId(id);
        model.addAttribute("booklist", allByCategoryId);
        return "book_category_id";
    }

    @GetMapping("/booookkkkkuser/{id}")
    public String booklistFromCategoryIdUser(@PathVariable Integer id, Model model){
        List<Book> allByCategoryId = bookRepository.findAllByCategoryId(id);
        model.addAttribute("booklist", allByCategoryId);
        return "book_category_id_user";
    }

}
