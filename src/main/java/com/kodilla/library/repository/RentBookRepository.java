package com.kodilla.library.repository;

import com.kodilla.library.domain.RentBook;
import org.springframework.data.repository.CrudRepository;

public interface RentBookRepository extends CrudRepository <RentBook, Long> {

    RentBook save(RentBook rentBook);

}
