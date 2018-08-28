package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository <Book, Long> {
}
