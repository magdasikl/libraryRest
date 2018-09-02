package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "READER")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idreader")
    private Long idReader;

    @Column(name = "firstnamereader")
    private String firstNameReader;

    @Column(name = "lastnamereader")
    private String lastNameReader;

    @Column(name = "dateofaccountcreation")
    private String dateOfAccountCreation;

}
