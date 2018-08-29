package com.kodilla.library.repository;

import com.kodilla.library.domain.BookDescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDescriptionRepository extends CrudRepository<BookDescription, Long> {

    @Override
    List<BookDescription> findAll();

    @Override
    BookDescription save(BookDescription description);

}
