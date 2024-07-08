package com.dailycoder.parkinglot.model.Parking.Strategy;

import com.dailycoder.parkinglot.exception.NoFreeSlotAvailableException;

import java.util.TreeSet;

public class NaturalOrderingParkingStrategy implements ParkingStrategy {

    TreeSet<Integer> treeSet;

    public NaturalOrderingParkingStrategy(){
        this.treeSet = new TreeSet<>();
    }

    @Override
    public void addSlot(Integer slotNumber) {
            treeSet.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        this.treeSet.remove(slotNumber);
    }

    @Override
    public Integer getNextSlot() {
       if(treeSet.isEmpty()){
           throw new NoFreeSlotAvailableException("No available seats");
       }
       return treeSet.first();
    }
}
