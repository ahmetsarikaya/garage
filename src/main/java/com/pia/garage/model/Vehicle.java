package com.pia.garage.model;

public abstract class Vehicle {
    protected int width;
    protected String color;
    protected String plate;

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return this.plate+" "+this.color;
    }
}
