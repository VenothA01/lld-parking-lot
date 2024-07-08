package com.dailycoder.parkinglot.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingLotException extends RuntimeException {

    public ParkingLotException(String msg){
        super(msg);
    }
}
