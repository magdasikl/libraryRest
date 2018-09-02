package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDescription;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.RentBook;
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

    public BookDescription saveBookDescription(final BookDescription description){
        return descriptionRepository.save(description);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public Book saveBook(final Book book){
        return bookRepository.save(book);
    }

    public List<Book> findBooksByIdTitleAndStatus(final BookDescription idTitle, final String status ){
        return bookRepository.findBooksByIdTitleAndStatus(idTitle,status);
    }

//    public BookDescription countBooksByTitle (final String title) {
//        return bookRepository.countBooksByTitle(title);
//    }

    public long countBooksByStatusAndIdTitle(final String status, final BookDescription idTitle) {
        return bookRepository.countBooksByStatusAndIdTitle(status, idTitle);

    }

    public RentBook saveRentBook(final RentBook rentBook) {
        return rentBookRepository.save(rentBook);
    }


}
