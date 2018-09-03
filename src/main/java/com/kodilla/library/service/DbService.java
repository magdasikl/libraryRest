package com.kodilla.library.service;

import com.kodilla.library.domain.*;
import com.kodilla.library.repository.BookDescriptionRepository;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private BookDescriptionRepository descriptionRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RentBookRepository rentBookRepository;

    public List<BookDescription> getAllTBookDescription() {
        return descriptionRepository.findAll();
    }

    public BookDescription saveBookDescription(final BookDescription description) {
        return descriptionRepository.save(description);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findBooksByIdTitleAndStatus(final BookDescription description, final StatusBookDesc status) {
        return bookRepository.findBooksByIdTitleAndStatus(description, status);
    }

    public Book findBookByIdBook (long idBook){
        return bookRepository.findBookByIdBook(idBook);
    }

    public long countBooksByIdTitle_TitleAndStatus(final String description, final StatusBookDesc status) {
        return bookRepository.countBooksByIdTitle_TitleAndStatus(description, status);
    }

    public RentBook saveRentBook(final RentBook rentBook) {
        return rentBookRepository.save(rentBook);
    }


}
