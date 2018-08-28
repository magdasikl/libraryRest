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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name="id")
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idcopyofbook")
    private CopyOfBook idCopyOfBook;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="idreader")
    private Reader idReader;

    @Column(name = "dateofrent")
    @NotNull
    private LocalDate dateOfRent;

    @Column(name = "dateofreturn")
    @NotNull
    private LocalDate dateOfReturn;
}
