package com.pia.garage.service;

public interface GarageService {
    String park(String type,String color,String plate);
    String leave(int index);
    String status();

}
