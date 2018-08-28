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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name="idreader")
    private Long idReader;

    @Column(name = "firstnamereader")
    @NotNull
    private String firstNameReader;

    @Column(name = "lastnamereader")
    @NotNull
    private String lastNameReader;

    @Column(name = "dateofaccountcreation")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private LocalDate dateOfAccountCreation;

}
