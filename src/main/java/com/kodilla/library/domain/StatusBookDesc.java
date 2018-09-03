package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;



public enum StatusBookDesc {
    Circulation("w obiegu"),
    Destroyed("zniszczona"),
    Lost("zagubiona"),
    Rented("wypozyczona");

    private final String status;

    StatusBookDesc (String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }


}
