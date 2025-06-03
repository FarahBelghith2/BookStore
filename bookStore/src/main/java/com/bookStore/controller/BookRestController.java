package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBook();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        Book existing = service.getBookById(id);
        if (existing != null) {
            existing.setName(book.getName());
            existing.setAuthor(book.getAuthor());
            existing.setPrice(book.getPrice());
            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        service.deleteById(id);
        return "Book deleted";
    }
}
