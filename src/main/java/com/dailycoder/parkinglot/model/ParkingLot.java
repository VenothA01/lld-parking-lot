package com.dailycoder.parkinglot.model;

import com.dailycoder.parkinglot.exception.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private static int MAX_CAPACITY = 100000;
    private int capacity;
    private Map<Integer, Slot> slots;

    public int getCapacity() {
        return capacity;
    }

    public ParkingLot(int capacity) {
        if(capacity>MAX_CAPACITY || capacity < 0){
            throw new ParkingLotException("Invalid capacity given for parking lot.");
        }

        this.capacity =capacity;
        this.slots = new HashMap<>();
    }

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    private Slot getSlotForgivenSlotNumber(final Integer slotNumber){
        return null;
    }

    public void park(Car car, Integer nextFreeSlot) {
    }

    public void makeSlotFree(Integer slotNumber) {
    }
}
