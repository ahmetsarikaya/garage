package com.pia.garage.model;

public class Truck extends Vehicle {
    public  Truck(String color,String plate){
        setColor(color);
        setPlate(plate);
        this.width = 4;
    }
}