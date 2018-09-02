package com.kodilla.library.mapper;

import com.kodilla.library.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class BookDescriptionMapper {
    public BookDescription mapToBookDescription(final BookDescriptionDto descriptionDto) {
        return new BookDescription(
                descriptionDto.getIdTitle(),
                descriptionDto.getTitle(),
                descriptionDto.getAuthor(),
                descriptionDto.getYearOfPublication());
    }

    public BookDescriptionDto mapToBookDescriptionDto(final BookDescription description) {
        return new BookDescriptionDto(
                description.getIdTitle(),
                description.getTitle(),
                description.getAuthor(),
                description.getYearOfPublication());
    }

    public List<BookDescriptionDto> mapToBookDescriptionDtoList(final List<BookDescription> bookDescriptionList) {
        return bookDescriptionList.stream()
                .map(t -> new BookDescriptionDto(t.getIdTitle(), t.getTitle(), t.getAuthor(),t.getYearOfPublication()))
                .collect(Collectors.toList());
    }

    public Book mapToBook(final BookDto bookDto){
        return new Book(
                bookDto.getIdBook(),
                bookDto.getStatus(),
                mapToBookDescription(bookDto.getDescription()));
    }

    public BookDto mapToBookDto(final Book book){
        BookDescription description = book.getIdTitle();
        return new BookDto(
                book.getIdBook(),
                book.getStatus(),
                mapToBookDescriptionDto(description));
    }


    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }

    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getIdReader(),
                readerDto.getFirstNameReader(),
                readerDto.getLastNameReader(),
                readerDto.getDateOfAccountCreation());
    }

    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getIdReader(),
                reader.getFirstNameReader(),
                reader.getLastNameReader(),
                reader.getDateOfAccountCreation());
    }


    public RentBook mapToRentBook(final RentBookDto rentBookDto){
        return new RentBook(
                rentBookDto.getId(),
                mapToBook(rentBookDto.getIdBook()),
                mapToReader(rentBookDto.getIdReader()),
                rentBookDto.getDateOfRent(),
                rentBookDto.getDateOfReturn());
    }

    public RentBookDto mapToRentBookDto(final RentBook rentBook) {
        return new RentBookDto(
                rentBook.getId(),
                mapToBookDto(rentBook.getIdBook()),
                mapToReaderDto(rentBook.getIdReader()),
                rentBook.getDateOfRent(),
                rentBook.getDateOfReturn());
    }

}
