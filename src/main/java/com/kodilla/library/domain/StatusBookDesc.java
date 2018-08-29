package com.kodilla.library.domain;

public enum StatusBookDesc {
    Circulation("w obiegu"),
    Destroyed("zniszczona"),
    Lost("zagubiona");

    private final String status;

    StatusBookDesc (String status) {
        this.status = status;
    }

    public String getStatus(){
    return status;
    }
}
