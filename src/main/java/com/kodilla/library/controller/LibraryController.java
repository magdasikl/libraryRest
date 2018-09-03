package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.BookDescriptionMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kodilla.library.domain.StatusBookDesc.Circulation;
import static com.kodilla.library.domain.StatusBookDesc.Rented;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private DbService service;


    @Autowired
    private BookDescriptionMapper descriptionMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooksDesc")
    public List<BookDescriptionDto> getBookDescription() {
        return descriptionMapper.mapToBookDescriptionDtoList(service.getAllTBookDescription());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookDescription", consumes = APPLICATION_JSON_VALUE)
    public BookDescriptionDto createBookDescription(@RequestBody BookDescriptionDto descriptionDto) {
        BookDescription description = service.saveBookDescription(descriptionMapper.mapToBookDescription(descriptionDto));
        return descriptionMapper.mapToBookDescriptionDto(description);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = service.saveReader(descriptionMapper.mapToReader(readerDto));
        return descriptionMapper.mapToReaderDto(reader);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = service.saveBook(descriptionMapper.mapToBook(bookDto));
        return descriptionMapper.mapToBookDto(book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks(@RequestParam Long idTitle, @RequestParam StatusBookDesc status) {
        List<Book> bookList = service.findBooksByIdTitleAndStatus(new BookDescription(idTitle), status);
        return descriptionMapper.mapToBookDtoList(bookList);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatusBook")
    public BookDto updateStatusBook(@RequestParam long idBook, @RequestParam StatusBookDesc status) {
        BookDto bookDto = descriptionMapper.mapToBookDto(service.findBookByIdBook(idBook));
        bookDto.setStatus(status);
        Book book = service.saveBook(descriptionMapper.mapToBook(bookDto));
        return descriptionMapper.mapToBookDto(book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getcountBooks")
    public long getcountBooks(@RequestParam StatusBookDesc status, @RequestParam String title) {
      //  return service.countBooksByStatusAndIdTitle(new BookDescription(title), status);
        return service.countBooksByIdTitle_TitleAndStatus(title, status);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createRentBook", consumes = APPLICATION_JSON_VALUE)
    public RentBookDto createRentBook(@RequestBody RentBookDto rentBookDto) {
        BookDto bookDto2 = descriptionMapper.mapToBookDto(service.findBookByIdBook(rentBookDto.getIdBook().getIdBook()));
        if (bookDto2.getStatus().equals(Circulation)){
            RentBook rentBook = service.saveRentBook(descriptionMapper.mapToRentBook(rentBookDto));
            BookDto bookDto = descriptionMapper.mapToBookDto(service.findBookByIdBook(rentBook.getIdBook().getIdBook()));
            bookDto.setStatus(Rented);
            service.saveBook(descriptionMapper.mapToBook(bookDto));

            return descriptionMapper.mapToRentBookDto(rentBook);
        }else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateRentBook", consumes = APPLICATION_JSON_VALUE)
    public RentBookDto updateRentBook(@RequestBody RentBookDto rentBookDto) {
        service.saveBook(descriptionMapper.mapToBook(rentBookDto.getIdBook()));
        RentBook rentBook = service.saveRentBook(descriptionMapper.mapToRentBook(rentBookDto));
        return descriptionMapper.mapToRentBookDto(rentBook);
    }
}
