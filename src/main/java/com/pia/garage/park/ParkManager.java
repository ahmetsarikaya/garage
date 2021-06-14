package com.pia.garage.park;

import com.pia.garage.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ParkManager {
    private static final int MAX_SLOT = 10;
    private TreeSet<ParkedVehicle> parkedVehicles = new TreeSet<>();

    public String park(Vehicle vehicle){
      String result = "";
      if(vehicle!=null){
          if(parkedVehicles.isEmpty()){
              parkedVehicles.add(new ParkedVehicle(vehicle,1));
              result = "Allocated "+vehicle.getWidth()+" slot(s).";
          }else{
              Iterator<ParkedVehicle> parkedVehicleIterator = parkedVehicles.iterator();
              int currentSlotIndex = 0;
              boolean placed = false;
              while (parkedVehicleIterator.hasNext()){
                  ParkedVehicle parkedVehicle = parkedVehicleIterator.next();
                  if((parkedVehicle.getSlotIndex()-currentSlotIndex) > (vehicle.getWidth()+1)){
                      parkedVehicles.add(new ParkedVehicle(vehicle,currentSlotIndex+1));
                      result = "Allocated "+vehicle.getWidth()+" slot(s).";
                      placed = true;
                      break;
                  }else{
                      currentSlotIndex = parkedVehicle.getSlotIndex()+parkedVehicle.getVehicle().getWidth();
                  }
              }
              if(!placed){
                  if(currentSlotIndex+vehicle.getWidth()<=MAX_SLOT){
                    parkedVehicles.add(new ParkedVehicle(vehicle,currentSlotIndex+1));
                    result = "Allocated "+vehicle.getWidth()+" slot(s).";
                  }else {
                      result = "Garage is full.";
                  }
              }
          }
      }
      return result;
    }

    public String leave(int index){
        String resultMsg = null;
        if(!parkedVehicles.isEmpty()){
            int idx = 1;
            ParkedVehicle parkedVehicle = null;
            Iterator<ParkedVehicle> pvi = parkedVehicles.iterator();
            while (pvi.hasNext()){
                if(idx == index){
                    parkedVehicle = pvi.next();
                    break;
                }
                pvi.next();
                idx++;
            }
            if(parkedVehicle != null){
                parkedVehicles.remove(parkedVehicle);
                resultMsg = index +" Numbered car leaved.";
            }else {
                resultMsg = "Slot Number not found.";
            }
        }else{
            resultMsg = "Garage is already empty.";
        }
        return resultMsg;
    }

    public String status(){
        String status= "";
        if(!parkedVehicles.isEmpty()){
            Iterator<ParkedVehicle> parkedVehicleIterator = parkedVehicles.iterator();
            while (parkedVehicleIterator.hasNext()){
                status += parkedVehicleIterator.next().toString()+"\n";
            }
        }else{
            status = "Garage is empty.";
        }
        return status;
    }
}
