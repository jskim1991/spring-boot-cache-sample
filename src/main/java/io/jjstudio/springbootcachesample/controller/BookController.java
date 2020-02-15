package io.jjstudio.springbootcachesample.controller;

import io.jjstudio.springbootcachesample.domain.Book;
import io.jjstudio.springbootcachesample.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        this.service.addBook(book);
    }

    @GetMapping("/find/{isbn}")
    public Book findBook(@PathVariable(value = "isbn", required = true) String isbn) {
        return this.service.findBook(isbn);
    }

    @GetMapping("/findAll")
    public List<Book> findAllBooks() {
        return this.service.findAll();
    }

    @PutMapping("/update")
    public void updateBook(@RequestBody Book book) {
        this.service.updateBook(book);
    }

    @GetMapping("/clear-cache")
    public void clearCache() {
        this.service.clearCache();
    }
}
