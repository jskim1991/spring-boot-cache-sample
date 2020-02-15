package io.jjstudio.springbootcachesample.service;

import io.jjstudio.springbootcachesample.db.BookRepository;
import io.jjstudio.springbootcachesample.domain.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    public Book addBook(Book book) {
        return this.repository.save(book);
    }

    @Cacheable(value = "books", key ="#isbn", unless="#result == null")
//    @CachePut(value = "books", key ="#isbn", unless="#result == null")
    public Book findBook(String isbn) {
        System.out.println("LOOKING FOR THIS BOOK IN DB");
        Optional<Book> byId = this.repository.findById(isbn);
        if (byId.isPresent()) {
            return byId.get();
        }
        else {
            return null;
        }
    }

    @CachePut(value = "books", key ="#p0.isbn", unless="#result == null")
    public Book updateBook(Book book) {
        System.out.println("UPDATING THIS BOOK");
        return this.repository.save(book);
    }

    @CacheEvict(value = "books", allEntries = true)
    public void clearCache() {

    }

    public List<Book> findAll() {
        return this.repository.findAll();
    }
}
