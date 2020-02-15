package io.jjstudio.springbootcachesample.db;

import io.jjstudio.springbootcachesample.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
}
