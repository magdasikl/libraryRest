package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDescription;
import com.kodilla.library.domain.StatusBookDesc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Book save(Book book);

    BookDescription save(BookDescription description);

    List<Book> findBooksByIdTitleAndStatus(BookDescription idTitle, StatusBookDesc status);

    long countBooksByIdTitleAndStatus(BookDescription idTitle, StatusBookDesc status);

}
