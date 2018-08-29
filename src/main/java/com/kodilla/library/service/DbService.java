package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDescription;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.repository.BookDescriptionRepository;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DbService {
    @Autowired
    private BookDescriptionRepository descriptionRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public List<BookDescription> getAllTBookDescription() {
        return descriptionRepository.findAll();
    }

    public BookDescription saveBookDescription(final BookDescription description){
        return descriptionRepository.save(description);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }
}
