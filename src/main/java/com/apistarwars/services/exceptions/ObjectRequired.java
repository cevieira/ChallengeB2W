package com.apistarwars.services.exceptions;

public class ObjectRequired extends RuntimeException {

    public ObjectRequired(String msg){
        super(msg);
    }
}
