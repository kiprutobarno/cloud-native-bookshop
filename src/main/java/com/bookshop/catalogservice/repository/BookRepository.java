package com.bookshop.catalogservice.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.catalogservice.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    @Modifying
    @Transactional
    @Query("DELETE FROM book WHERE isbn=:isbn")
    void deleteByIsbn(String isbn);
}
