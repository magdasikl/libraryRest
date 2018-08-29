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
                bookDto.getIdTitle());
    }

    public BookDto mapToBookDto(final Book book){
        return new BookDto(
                book.getIdBook(),
                book.getStatus(),
                book.getIdTitle());
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


    public RentBook mapToRentBook(final RentBokDto rentBokDto){
        return new RentBook(
                rentBokDto.getId(),
                rentBokDto.getIdBook(),
                rentBokDto.getIdReader(),
                rentBokDto.getDateOfRent(),
                rentBokDto.getDateOfReturn());
    }

    public RentBokDto mapToRentBokDto(final RentBook rentBook) {
        return new RentBokDto(
                rentBook.getId(),
                rentBook.getIdBook(),
                rentBook.getIdReader(),
                rentBook.getDateOfRent(),
                rentBook.getDateOfReturn());
    }

}
