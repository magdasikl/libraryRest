package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDescriptionDto {
    private Long idTitle;
    private String title;
    private String author;
    private Integer yearOfPublication;
}
