package com.pia.garage.service;

import com.pia.garage.factory.VehicleFactory;
import com.pia.garage.model.Vehicle;
import com.pia.garage.park.ParkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl implements GarageService{
    @Autowired
    private ParkManager parkManager;

    @Override
    public String park(String type,String color,String plate) {
        Vehicle vehicle = VehicleFactory.getVehicle(type, color, plate);
        if(vehicle != null){
            return parkManager.park(vehicle);
        }
        return "Vehicle not found ["+type+"]";
    }

    @Override
    public String leave(int index) {
        return parkManager.leave(index);
    }

    @Override
    public String status() {
        return parkManager.status();
    }
}
