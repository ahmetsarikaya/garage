package com.pia.garage.factory;

import com.pia.garage.enums.Types;
import com.pia.garage.model.Car;
import com.pia.garage.model.Jeep;
import com.pia.garage.model.Truck;
import com.pia.garage.model.Vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(String type,String color,String plate){
        if(Types.CAR.toString().equalsIgnoreCase(type)){
            return new Car(color,plate);
        }else if(Types.JEEP.toString().equalsIgnoreCase(type)) {
            return new Jeep(color, plate);
        }else if(Types.TRUCK.toString().equalsIgnoreCase(type)) {
            return new Truck(color, plate);
        }else{
            return null;
        }
    }
}
