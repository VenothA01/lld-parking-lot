package com.dailycoder.parkinglot.exception;

public class InvalidCommandException extends RuntimeException{

    public InvalidCommandException(String msg){
        super(msg);
    }
}
