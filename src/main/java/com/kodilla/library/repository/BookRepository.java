package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Book save(Book book);

    BookDescription save(BookDescription description);

    List<Book> findBooksByIdTitleAndStatus(BookDescription idTitle, String status);

     long countBooksByStatusAndIdTitle (String status, BookDescription idTitle);

}
