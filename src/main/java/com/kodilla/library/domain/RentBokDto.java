package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentBokDto {
    private Long id;
    private Book idBook;
    private Reader idReader;
    private LocalDate dateOfRent;
    private LocalDate dateOfReturn;
}
