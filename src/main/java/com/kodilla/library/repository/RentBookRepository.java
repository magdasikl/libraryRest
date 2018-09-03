package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDescription;
import com.kodilla.library.domain.RentBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentBookRepository extends CrudRepository <RentBook, Long> {

    RentBook save(RentBook rentBook);

}
