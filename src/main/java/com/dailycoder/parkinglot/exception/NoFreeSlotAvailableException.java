package com.dailycoder.parkinglot.exception;

public class NoFreeSlotAvailableException  extends RuntimeException {


    public NoFreeSlotAvailableException(String msg){
        super(msg);
    }

}
