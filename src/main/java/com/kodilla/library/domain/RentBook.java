package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RENTBOOK")
public class RentBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idbook")
    private Book idBook;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idreader")
    private Reader idReader;

    @Column(name = "dateofrent")
    @NotNull
    private String dateOfRent;

    @Column(name = "dateofreturn")
    private String dateOfReturn;
}
