package com.dailycoder.parkinglot.model.Parking.Strategy;

public interface ParkingStrategy {

    void    addSlot(Integer slotNumber);
    void    removeSlot(Integer slotNumber);


    Integer getNextSlot();
}
