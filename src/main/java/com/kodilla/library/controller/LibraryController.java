package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.BookDescriptionMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private DbService service;

    @Autowired
    private BookDescriptionMapper descriptionMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getBooksDesc")
    public List<BookDescriptionDto> getBookDescription() {
        return descriptionMapper.mapToBookDescriptionDtoList(service.getAllTBookDescription());
    }

    @RequestMapping(method = RequestMethod.POST,value ="createBookDescription",consumes = APPLICATION_JSON_VALUE)
    public BookDescriptionDto createBookDescription(@RequestBody BookDescriptionDto descriptionDto){
        BookDescription description = service.saveBookDescription(descriptionMapper.mapToBookDescription(descriptionDto));
        return descriptionMapper.mapToBookDescriptionDto(description);
    }

    @RequestMapping(method = RequestMethod.POST,value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = service.saveReader(descriptionMapper.mapToReader(readerDto));
        return descriptionMapper.mapToReaderDto(reader);
    }

    @RequestMapping(method = RequestMethod.POST,value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = service.saveBook(descriptionMapper.mapToBook(bookDto));
        return descriptionMapper.mapToBookDto(book);
    }

    @RequestMapping(method = RequestMethod.GET,value = "getBooks")
    public List<BookDto> getBooks(@RequestParam BookDescription idTitle, String status) {
        List<Book> bookList =  service.findBooksByIdTitleAndStatus(idTitle,status);
        return descriptionMapper.mapToBookDtoList(bookList);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "updateStatusBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto updateStatusBook(@RequestBody BookDto bookDto) {
        Book book = service.saveBook(descriptionMapper.mapToBook(bookDto));
        return descriptionMapper.mapToBookDto(book);
    }

}
