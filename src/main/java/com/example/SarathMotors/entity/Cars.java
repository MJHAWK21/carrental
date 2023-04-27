package com.example.SarathMotors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cars {
    @Id
    @GeneratedValue
    private Long carId;
    private String carName;
    private String price;
    private String brand;
    private String color;
    private String noOfSeats;
    private String date;
    private String availabilityStatus;

}
