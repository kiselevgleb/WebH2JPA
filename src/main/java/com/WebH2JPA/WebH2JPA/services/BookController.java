package com.WebH2JPA.WebH2JPA.services;

import com.WebH2JPA.WebH2JPA.models.Book;
import com.WebH2JPA.WebH2JPA.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookRepo repository;

    @Autowired
    public BookController(BookRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = repository.getAll();
        model.addAttribute("books", books);
        return "index";
    }
    @PostMapping("/")
    public String listPageUp(@RequestParam("id") int id, String name, Model model) {
        Book book = repository.getById(id);
        book.setName(name);
        repository.insert(book);
        List<Book> books = repository.getAll();
        model.addAttribute("books", books);
        return "index";
    }
    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        Book book = repository.getById(id);
        model.addAttribute("book", book);
        return "edit";
    }
    @PostMapping("/edited")
    public String delete(@RequestParam("id") int id, Model model) {
        Book book = repository.getById(id);
        repository.delete(book);
        List<Book> books = repository.getAll();
        model.addAttribute("books", books);
        return "index";
    }
}