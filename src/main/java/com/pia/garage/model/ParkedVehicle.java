package com.pia.garage.model;

import java.util.ArrayList;
import java.util.List;

public class ParkedVehicle implements Comparable<ParkedVehicle>{
    private Vehicle vehicle;
    private int slotIndex;

    public ParkedVehicle(Vehicle vehicle, int slotIndex) {
        this.vehicle = vehicle;
        this.slotIndex = slotIndex;
    }

    public int getSlotIndex(){
        return  slotIndex;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    @Override
    public int compareTo(ParkedVehicle o) {
        return this.slotIndex-o.slotIndex;
    }

    private List<Integer> getSlotInterval(){
        List<Integer> interval = new ArrayList<>();
        for (int i = 0; i < this.getVehicle().getWidth(); i++) {
            interval.add(slotIndex+i);
        }
        return interval;
    }

    @Override
    public String toString() {
        return vehicle.toString() +" "+ getSlotInterval();
    }
}
