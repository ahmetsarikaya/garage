package com.pia.garage.controller;

import com.pia.garage.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garage")
public class GarageController {

    @Autowired
    GarageService garageService;

    @PostMapping("/park/{type}")
    public String park(@PathVariable("type")String type, @RequestParam("color")String color,@RequestParam("plate")String plate){
        return garageService.park(type,color,plate);
    }

    @DeleteMapping("/leave/{id}")
    public String leave(@PathVariable("id") int id){
        return garageService.leave(id);
    }

    @GetMapping("/status")
    public String status(){
        return garageService.status();
    }
}
