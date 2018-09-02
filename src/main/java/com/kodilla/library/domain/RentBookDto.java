package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentBookDto {
    private Long id;
    private BookDto idBook;
    private ReaderDto idReader;
    private String dateOfRent;
    private String dateOfReturn;
}
