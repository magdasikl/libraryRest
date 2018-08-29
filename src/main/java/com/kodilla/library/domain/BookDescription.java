package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "BOOKDESCRIPTION")
public final class BookDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtitle")
    private Long idTitle;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "yearofpublication")
    private  Integer yearOfPublication;


}
