package com.pia.garage.model;

public class Car extends Vehicle {
    public  Car(String color,String plate){
        setColor(color);
        setPlate(plate);
        this.width = 1;
    }
}
