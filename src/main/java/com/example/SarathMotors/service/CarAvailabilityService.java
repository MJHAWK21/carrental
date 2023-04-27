package com.example.SarathMotors.service;

import com.example.SarathMotors.entity.Cars;
import com.example.SarathMotors.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarAvailabilityService {
    @Autowired
    private CarRepository carRepository;

    public Cars addCars(Cars cars) {
        return carRepository.save(cars);
    }


    public List<Cars>getAll(){
        return carRepository.findAll();
    }
    public List<Cars>getCarByDate(String date){
        return carRepository.findByDate(date);
    }



    }

