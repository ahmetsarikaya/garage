package com.pia.garage.model;

public class Jeep extends Vehicle {
    public  Jeep(String color,String plate){
        setColor(color);
        setPlate(plate);
        this.width = 2;
    }
}
