package com.example.SarathMotors.controller;


import com.example.SarathMotors.entity.Cars;
import com.example.SarathMotors.service.CarAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sarathrentals")
public class CarController {
    @Autowired
    public CarAvailabilityService carAvailabilityService;

    @PostMapping("/addcars")
    public Cars addCar(@RequestBody Cars cars){
        return carAvailabilityService.addCars(cars);
    }

    @GetMapping("/getall")
    public List<Cars>getAll(){
        return carAvailabilityService.getAll();
    }

    @GetMapping("/{date}")
    public List<Cars>getCarByDate(@PathVariable  String date){
        return carAvailabilityService.getCarByDate(date);


    }


}
