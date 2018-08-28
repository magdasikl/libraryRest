package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long idTitle;
    private String title;
    private String author;
    private  Integer yearOfPublication;
}
