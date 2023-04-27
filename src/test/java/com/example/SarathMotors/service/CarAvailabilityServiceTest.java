package com.example.SarathMotors.service;

import com.example.SarathMotors.entity.Cars;
import com.example.SarathMotors.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarAvailabilityServiceTest {

    @Mock
    private CarRepository mockCarRepository;

    @InjectMocks
    private CarAvailabilityService carAvailabilityServiceUnderTest;

    @Test
    void testAddCars() {
        // Setup
        final Cars cars = new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus");
        final Cars expectedResult = new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date",
                "availabilityStatus");

        // Configure CarRepository.save(...).
        final Cars cars1 = new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date",
                "availabilityStatus");
        when(mockCarRepository.save(new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date",
                "availabilityStatus"))).thenReturn(cars1);

        // Run the test
        final Cars result = carAvailabilityServiceUnderTest.addCars(cars);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAll() {
        // Setup
        final List<Cars> expectedResult = List.of(
                new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus"));

        // Configure CarRepository.findAll(...).
        final List<Cars> cars = List.of(
                new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus"));
        when(mockCarRepository.findAll()).thenReturn(cars);

        // Run the test
        final List<Cars> result = carAvailabilityServiceUnderTest.getAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAll_CarRepositoryReturnsNoItems() {
        // Setup
        when(mockCarRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Cars> result = carAvailabilityServiceUnderTest.getAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetCarByDate() {
        // Setup
        final List<Cars> expectedResult = List.of(
                new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus"));

        // Configure CarRepository.findByDate(...).
        final List<Cars> cars = List.of(
                new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus"));
        when(mockCarRepository.findByDate("date")).thenReturn(cars);

        // Run the test
        final List<Cars> result = carAvailabilityServiceUnderTest.getCarByDate("date");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetCarByDate_CarRepositoryReturnsNoItems() {
        // Setup
        when(mockCarRepository.findByDate("date")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Cars> result = carAvailabilityServiceUnderTest.getCarByDate("date");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
